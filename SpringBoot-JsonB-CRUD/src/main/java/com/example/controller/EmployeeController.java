package com.example.controller;

import com.example.entity.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value="/save-employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping(value="/update-employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee ,@PathVariable long id) {
        Employee emp = employeeService.updateEmployee(employee, id);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @DeleteMapping(value="/delete-employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long id) {
        employeeService.deleteEmployee(id);
        String msg = "Employee with id " + id + " deleted successfully";
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }

    @GetMapping(value="/getone-employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable long id) {
        Employee emp = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @GetMapping(value="/getall-employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}

/*
        ####   POST   ####
    {
    "name": "John Doe",
    "location": "New York",
    "email": "john.doe@example.com",
    "attributes": "{\"department\": \"IT\", \"position\": \"Developer\"}"
    }


// ***    Retrieving position,department only


    SELECT
        attributes->>'position' AS position,
        attributes->>'department' AS department
    FROM
        employees;



 //###  Retrieving all details with positon,department

     SELECT
        id,
        name,
        location,
        email,
        attributes->>'position' AS position,
        attributes->>'department' AS department,
		attributes->>'age' AS age,
		attributes->>'salary' AS salary
    FROM
        employees;


//##   updating one employee detail using id

    UPDATE employees
        SET attributes = jsonb_set(attributes, '{position}', '"Senior Developer"')
        WHERE id = 1;

 */