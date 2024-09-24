package com.example;

import net.sf.jsqlparser.expression.*;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.StatementVisitorAdapter;
import net.sf.jsqlparser.statement.select.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

/*
import java.util.regex.Matcher;
import java.util.regex.Pattern;
*/

@SpringBootApplication
public class SqlMaskingApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SqlMaskingApplication.class, args);

		// The query with the masking function in the output
		/*String sqlQuery = "SELECT \n" +
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
}*/

		//Extracting column names -Task-2
/*

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

		Set<String> columnNames = getColumnNamesFromQuery(sqlQuery);

		for (String columnName : columnNames) {
			System.out.println(columnName);
		}
	}

	public static Set<String> getColumnNamesFromQuery(String sqlQuery) throws Exception {
		Set<String> columnNames = new HashSet<>();
		Statement statement = CCJSqlParserUtil.parse(sqlQuery);

		statement.accept(new StatementVisitorAdapter() {
			@Override
			public void visit(Select select) {
				SelectBody selectBody = select.getSelectBody();
				extractColumnNamesFromSelectBody(selectBody, columnNames);
			}
		});

		return columnNames;
	}

	private static void extractColumnNamesFromSelectBody(SelectBody selectBody, Set<String> columnNames) {
		if (selectBody instanceof PlainSelect) {
			PlainSelect plainSelect = (PlainSelect) selectBody;
			extractColumnNamesFromPlainSelect(plainSelect, columnNames);
		} else if (selectBody instanceof SetOperationList) {
			SetOperationList setOperationList = (SetOperationList) selectBody;
			for (SelectBody selectBody1 : setOperationList.getSelects()) {
				extractColumnNamesFromSelectBody(selectBody1, columnNames);
			}
		}
	}

	private static void extractColumnNamesFromPlainSelect(PlainSelect plainSelect, Set<String> columnNames) {
		extractColumnNamesFromSelectItems(plainSelect.getSelectItems(), columnNames);
		extractColumnNamesFromExpression(plainSelect.getWhere(), columnNames);
		extractColumnNamesFromOrderByElements(plainSelect.getOrderByElements(), columnNames);
//		extractColumnNamesFromGroupByElements(plainSelect.getGroupByColumnReferences(), columnNames);
		extractColumnNamesFromJoins(plainSelect.getJoins(), columnNames);
	}

	private static void extractColumnNamesFromSelectItems(List<SelectItem> selectItems, Set<String> columnNames) {
		for (SelectItem selectItem : selectItems) {
			selectItem.accept(new SelectItemVisitor() {
				@Override
				public void visit(AllColumns allColumns) {
				}

				@Override
				public void visit(AllTableColumns allTableColumns) {
					columnNames.add(allTableColumns.getTable().getFullyQualifiedName() + ".*");
				}

				@Override
				public void visit(SelectExpressionItem selectExpressionItem) {
					Expression expression = selectExpressionItem.getExpression();
					extractColumnNamesFromExpression(expression, columnNames);
				}
			});
		}
	}

	private static void extractColumnNamesFromExpression(Expression expression, Set<String> columnNames) {
		if (expression != null) {
			expression.accept(new ExpressionVisitorAdapter() {
				@Override
				public void visit(Column column) {
					columnNames.add(column.getFullyQualifiedName());
				}

				@Override
				public void visit(SubSelect subSelect) {
					extractColumnNamesFromSelectBody(subSelect.getSelectBody(), columnNames);
				}

				@Override
				public void visit(Function function) {
					if (function.getParameters() != null) {
						List<Expression> expressions = function.getParameters().getExpressions();
						for (Expression expr : expressions) {
							extractColumnNamesFromExpression(expr, columnNames);
						}
					}
				}

				@Override
				public void visit(CaseExpression caseExpression) {
					extractColumnNamesFromExpression(caseExpression.getSwitchExpression(), columnNames);
					if (caseExpression.getWhenClauses() != null) {
						for (Expression whenClause : caseExpression.getWhenClauses()) {
							extractColumnNamesFromExpression(whenClause, columnNames);
						}
					}
					extractColumnNamesFromExpression(caseExpression.getElseExpression(), columnNames);
				}

				@Override
				protected void visitBinaryExpression(BinaryExpression binaryExpression) {
					extractColumnNamesFromExpression(binaryExpression.getLeftExpression(), columnNames);
					extractColumnNamesFromExpression(binaryExpression.getRightExpression(), columnNames);
					super.visitBinaryExpression(binaryExpression);
				}
			});
		}
	}

	private static void extractColumnNamesFromOrderByElements(List<OrderByElement> orderByElements, Set<String> columnNames) {
		if (orderByElements != null) {
			for (OrderByElement orderByElement : orderByElements) {
				extractColumnNamesFromExpression(orderByElement.getExpression(), columnNames);
			}
		}
	}

	private static void extractColumnNamesFromGroupByElements(List<Expression> groupByElements, Set<String> columnNames) {
		if (groupByElements != null) {
			for (Expression groupByElement : groupByElements) {
				extractColumnNamesFromExpression(groupByElement, columnNames);
			}
		}
	}

	private static void extractColumnNamesFromJoins(List<Join> joins, Set<String> columnNames) {
		if (joins != null) {
			for (Join join : joins) {
				extractColumnNamesFromExpression(join.getOnExpression(), columnNames);
				if (join.getRightItem() instanceof SubSelect) {
					SubSelect subSelect = (SubSelect) join.getRightItem();
					extractColumnNamesFromSelectBody(subSelect.getSelectBody(), columnNames);
				}
			}
		}
	}
}*/

		// Extracting columns with table name

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

		Set<String> columnNames = getColumnNamesFromQuery(sqlQuery);

		System.out.println("Extracting columns from query :");
		for (String columnName : columnNames) {
			System.out.println(columnName);
		}
	}

	public static Set<String> getColumnNamesFromQuery(String sqlQuery) throws Exception {
		Set<String> columnNames = new HashSet<>();
		Map<String, String> tableAliasMap = new HashMap<>();

		Statement statement = CCJSqlParserUtil.parse(sqlQuery);

		statement.accept(new StatementVisitorAdapter() {
			@Override
			public void visit(Select select) {
				SelectBody selectBody = select.getSelectBody();
				extractColumnNamesFromSelectBody(selectBody, tableAliasMap, columnNames);
			}
		});

		return columnNames;
	}

	private static void extractColumnNamesFromSelectBody(SelectBody selectBody, Map<String, String> tableAliasMap, Set<String> columnNames) {
		if (selectBody instanceof PlainSelect) {
			PlainSelect plainSelect = (PlainSelect) selectBody;
			extractColumnNamesFromPlainSelect(plainSelect, tableAliasMap, columnNames);
		} else if (selectBody instanceof SetOperationList) {
			SetOperationList setOperationList = (SetOperationList) selectBody;
			for (SelectBody selectBody1 : setOperationList.getSelects()) {
				extractColumnNamesFromSelectBody(selectBody1, tableAliasMap, columnNames);
			}
		}
	}

	private static void extractColumnNamesFromPlainSelect(PlainSelect plainSelect, Map<String, String> tableAliasMap, Set<String> columnNames) {
		// Extract table aliases from FROM and JOIN clauses
		extractTableAliases(plainSelect.getFromItem(), tableAliasMap);
		if (plainSelect.getJoins() != null) {
			for (Join join : plainSelect.getJoins()) {
				extractTableAliases(join.getRightItem(), tableAliasMap);
			}
		}

		extractColumnNamesFromSelectItems(plainSelect.getSelectItems(), tableAliasMap, columnNames);
		extractColumnNamesFromExpression(plainSelect.getWhere(), tableAliasMap, columnNames);
		extractColumnNamesFromOrderByElements(plainSelect.getOrderByElements(), tableAliasMap, columnNames);
		// extractColumnNamesFromGroupByElements(plainSelect.getGroupByColumnReferences(), tableAliasMap, columnNames);
		extractColumnNamesFromJoins(plainSelect.getJoins(), tableAliasMap, columnNames);
	}

	private static void extractTableAliases(FromItem fromItem, Map<String, String> tableAliasMap) {
		if (fromItem instanceof Table) {
			Table table = (Table) fromItem;
			tableAliasMap.put(table.getAlias() != null ? table.getAlias().getName() : table.getName(), table.getName());
		} else if (fromItem instanceof SubSelect) {
			SubSelect subSelect = (SubSelect) fromItem;
			extractColumnNamesFromSelectBody(subSelect.getSelectBody(), tableAliasMap, new HashSet<>());
		}
	}

	private static void extractColumnNamesFromSelectItems(List<SelectItem> selectItems, Map<String, String> tableAliasMap, Set<String> columnNames) {
		if (selectItems != null) {
			for (SelectItem selectItem : selectItems) {
				selectItem.accept(new SelectItemVisitor() {
					@Override
					public void visit(AllColumns allColumns) {
					}

					@Override
					public void visit(AllTableColumns allTableColumns) {
						String tableName = allTableColumns.getTable().getName();
						columnNames.add(tableName + ".*");
					}

					@Override
					public void visit(SelectExpressionItem selectExpressionItem) {
						Expression expression = selectExpressionItem.getExpression();
						extractColumnNamesFromExpression(expression, tableAliasMap, columnNames);
					}
				});
			}
		}
	}

	private static void extractColumnNamesFromExpression(Expression expression, Map<String, String> tableAliasMap, Set<String> columnNames) {
		if (expression != null) {
			expression.accept(new ExpressionVisitorAdapter() {
				@Override
				public void visit(Column column) {
					String tableName = column.getTable() != null ? column.getTable().getName() : null;
					String columnName = column.getColumnName();
					String fullTableName = tableAliasMap.getOrDefault(tableName, tableName);
					if (fullTableName != null && columnName != null) {
						columnNames.add(fullTableName + "." + columnName);
					}
				}

				@Override
				public void visit(SubSelect subSelect) {
					extractColumnNamesFromSelectBody(subSelect.getSelectBody(), tableAliasMap, columnNames);
				}

				@Override
				public void visit(Function function) {
					if (function.getParameters() != null) {
						List<Expression> expressions = function.getParameters().getExpressions();
						for (Expression expr : expressions) {
							extractColumnNamesFromExpression(expr, tableAliasMap, columnNames);
						}
					}
				}

				@Override
				public void visit(CaseExpression caseExpression) {
					extractColumnNamesFromExpression(caseExpression.getSwitchExpression(), tableAliasMap, columnNames);
					if (caseExpression.getWhenClauses() != null) {
						for (Expression whenClause : caseExpression.getWhenClauses()) {
							extractColumnNamesFromExpression(whenClause, tableAliasMap, columnNames);
						}
					}
					extractColumnNamesFromExpression(caseExpression.getElseExpression(), tableAliasMap, columnNames);
				}

				@Override
				protected void visitBinaryExpression(BinaryExpression binaryExpression) {
					extractColumnNamesFromExpression(binaryExpression.getLeftExpression(), tableAliasMap, columnNames);
					extractColumnNamesFromExpression(binaryExpression.getRightExpression(), tableAliasMap, columnNames);
					super.visitBinaryExpression(binaryExpression);
				}
			});
		}
	}

	private static void extractColumnNamesFromOrderByElements(List<OrderByElement> orderByElements, Map<String, String> tableAliasMap, Set<String> columnNames) {
		if (orderByElements != null) {
			for (OrderByElement orderByElement : orderByElements) {
				extractColumnNamesFromExpression(orderByElement.getExpression(), tableAliasMap, columnNames);
			}
		}
	}

	private static void extractColumnNamesFromGroupByElements(List<Expression> groupByElements, Map<String, String> tableAliasMap, Set<String> columnNames) {
		if (groupByElements != null) {
			for (Expression groupByElement : groupByElements) {
				extractColumnNamesFromExpression(groupByElement, tableAliasMap, columnNames);
			}
		}
	}

	private static void extractColumnNamesFromJoins(List<Join> joins, Map<String, String> tableAliasMap, Set<String> columnNames) {
		if (joins != null) {
			for (Join join : joins) {
				extractColumnNamesFromExpression(join.getOnExpression(), tableAliasMap, columnNames);
				if (join.getRightItem() instanceof SubSelect) {
					SubSelect subSelect = (SubSelect) join.getRightItem();
					extractColumnNamesFromSelectBody(subSelect.getSelectBody(), tableAliasMap, columnNames);
				}
			}
		}
	}
}