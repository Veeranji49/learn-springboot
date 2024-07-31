package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
public class SqlMaskingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SqlMaskingApplication.class, args);

		String sqlQuery = "SELECT \n" +
				"    e1.employee_id, \n" +
				"    e1.name, \n" +
				"    e1.department_id, \n" +
				"    d1.department_name,\n" +
				"    (SELECT AVG(salary) \n" +
				"     FROM employees e2 \n" +
				"     WHERE e2.department_id = e1.department_id) AS avg_department_salary,\n" +
				"    (CASE \n" +
				"        WHEN e1.salary > (SELECT AVG(salary) FROM employees e3 WHERE e3.department_id = e1.department_id)\n" +
				"        THEN 'Above Average'\n" +
				"        ELSE 'Below Average'\n" +
				"    END) AS salary_comparison\n" +
				"FROM \n" +
				"    employees e1\n" +
				"JOIN \n" +
				"    departments d1 ON e1.department_id = d1.department_id\n" +
				"WHERE \n" +
				"    e1.status = 'Active'\n" +
				"    AND e1.department_id IN (SELECT department_id FROM departments WHERE location = 'New York')\n" +
				"GROUP BY \n" +
				"    e1.employee_id, \n" +
				"    e1.name, \n" +
				"    e1.department_id, \n" +
				"    d1.department_name,\n" +
				"    e1.salary\n" +
				"ORDER BY \n" +
				"    e1.name ASC;";

		String maskedQuery = maskColumnNamesInQuery(sqlQuery);
		System.out.println(maskedQuery);
	}

	public static String maskColumnNamesInQuery(String sqlQuery) {
		// Remove string literals to avoid false positives
		sqlQuery = sqlQuery.replaceAll("'[^']*'", "''");

		// Regular expression to match column names in various contexts
		Pattern pattern = Pattern.compile(
				"\\b([a-zA-Z_]\\w*)\\.([a-zA-Z_]\\w*)\\b|" +  // table.column
						"\\bFROM\\s+([a-zA-Z_]\\w*)\\b|" +            // table names after FROM
						"\\bJOIN\\s+([a-zA-Z_]\\w*)\\b|" +            // table names after JOIN
						"\\b(AVG|COUNT|SUM|MAX|MIN)\\s*\\([^()]*\\)"  // function calls
		);

		StringBuffer maskedQuery = new StringBuffer();
		Matcher matcher = pattern.matcher(sqlQuery);

		while (matcher.find()) {
			if (matcher.group(1) != null && matcher.group(2) != null) {
				// table.column format
				String maskedColumnName = maskColumnName(matcher.group(1) + "." + matcher.group(2));
				matcher.appendReplacement(maskedQuery, maskedColumnName);
			} else if (matcher.group(3) != null) {
				// table name after FROM
				matcher.appendReplacement(maskedQuery, "FROM " + matcher.group(3));
			} else if (matcher.group(4) != null) {
				// table name after JOIN
				matcher.appendReplacement(maskedQuery, "JOIN " + matcher.group(4));
			} else if (matcher.group(5) != null) {
				// function call
				String functionCall = matcher.group(5);
				String maskedFunctionCall = maskFunctionCall(functionCall);
				matcher.appendReplacement(maskedQuery, maskedFunctionCall);
			}
		}
		matcher.appendTail(maskedQuery);

		return maskedQuery.toString();
	}

	private static String maskFunctionCall(String functionCall) {
		Pattern columnPattern = Pattern.compile("\\b([a-zA-Z_]\\w*)\\.([a-zA-Z_]\\w*)\\b");
		Matcher columnMatcher = columnPattern.matcher(functionCall);
		StringBuffer maskedFunction = new StringBuffer();

		while (columnMatcher.find()) {
			String maskedColumnName = maskColumnName(columnMatcher.group(1) + "." + columnMatcher.group(2));
			columnMatcher.appendReplacement(maskedFunction, maskedColumnName);
		}
		columnMatcher.appendTail(maskedFunction);

		return maskedFunction.toString();
	}

	public static String maskColumnName(String columnName) {
		String[] parts = columnName.split("\\.");
		if (parts.length == 2) {
			return parts[0] + "." + maskString(parts[1]);
		}
		return maskString(columnName);
	}

	private static String maskString(String input) {
		if (input.length() <= 2) {
			return input;
		}
		return input.charAt(0) + "*".repeat(input.length() - 2) + input.charAt(input.length() - 1);
	}
}