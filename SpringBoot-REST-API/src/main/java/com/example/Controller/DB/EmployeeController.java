package com.example.Controller.DB;

import com.example.Entity.DB.Employee;
import com.example.Service.DB.EmployeeService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiVisibility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/api/v1/employee")
@Api(name="Employee Controller", description = "To checking details of Employee", group="Employee Management system", visibility = ApiVisibility.PUBLIC)
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // for Logging
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @ApiMethod(description = "To get Employee message")
    @GetMapping(value="/msg")
    //@ApiOperation("Get a greeting message")
    public ResponseEntity<String> msg(){
        String response = "Welcome to Spring Boot REST API";
        logger.debug("response: {}", response);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping(value="/save")
    @ApiMethod(description = "To create the Employee details")
    //@ApiOperation("To posting the employee details")
    public ResponseEntity<Employee> savee(@Valid @RequestBody Employee employee) {
        Employee emp = employeeService.saveEmployee(employee);
        logger.debug("methodName: {}","savee","employee: {}", employee);
        return new ResponseEntity<>(emp, HttpStatus.CREATED);
    }

    @PutMapping(value="/update/{id}")
    @ApiMethod(description = "To update the employee details", path = {"id"})
    //@ApiOperation("To updating the employee details")
    public ResponseEntity<String> updatee(@Valid @RequestBody Employee employee, @PathVariable @ApiPathParam(name="id",description = "to get employee id to update") long id)
    {
        employeeService.updateEmployee(employee,id);
        String response = "Updated Successfully";
        logger.debug("methodName:{}","updatee", "response: {}", response, "employee: {}", employee, "id: {}",id);
        return  ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    @ApiMethod(description = "To delete the Employee details",path = {"id"})
    //@ApiOperation("To deleting the employee details")
    public ResponseEntity<String> deletee(@PathVariable @ApiPathParam(name="id",description = "To get employee id to deletee") long id)
    {
       employeeService.deleteEmployee(id);
       String msg = "Deleted Successfully";
       logger.info( "Response :{}", msg , "methodName: {}", "deletee");
       return  ResponseEntity.ok(msg);
    }

    @GetMapping(value="/getone/{id}")
    @ApiMethod(description = "To get one employee details",path = {"id"})
    //@ApiOperation("getting the one employee details")
    public ResponseEntity<Employee> getOne(@PathVariable @ApiPathParam(name="id",description = "To get employee id to get one details") long id)
    {
        Employee emp = employeeService.getOneEmployee(id);
        logger.info("methodName: {}", "getOne", "id: {}", id);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @GetMapping(value="/getall")
    @ApiMethod(description = "To get all employee details")
    //@ApiOperation("Getting all the employee details")
    public ResponseEntity<List<Employee>> getall()
    {
        List<Employee> list = employeeService.getAllEmployees();
        logger.info("methodName: {}", "getall");
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value="/pages")
    @ApiMethod(description = "To get pages resources")
    //@ApiOperation("Getting pageable resources")
    public ResponseEntity<Page<Employee>> getPages(Pageable pageable) {
        Page<Employee> pages = employeeService.findAll(pageable);
        logger.info("methodName: {}", "getPages", "pageable: {}", pageable);
        return ResponseEntity.ok().body(pages);
    }

    @GetMapping(value="/count")
    @ApiMethod(description = "To counting how many employees")
    //@ApiOperation("getting employees count")
    public ResponseEntity<Long> count() {
        long count = employeeService.getEmployeesCount();
        logger.info("methodName: {}", "count");
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    //// Retrieving specific details of Employee table  ////

    @GetMapping(value="/employee-name-location")
    @ApiMethod(description = "To get employee name and location")
    public ResponseEntity<List<String>> findNameLocation(){
        List<String> employee = employeeService.findAllEmployeeNamesLocations();
        logger.info("methodName: {}", "findNameLocation");
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @GetMapping(value="/employee-name-email")
    @ApiMethod(description = "To get employee name and email")
    public ResponseEntity<List<String>> findEmployeeNameEmail(){
        List<String> employee = employeeService.findAllEmployeeNamesEmail();
        logger.info("methodName: {}", "findEmployeeNameEmail");
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @GetMapping(value="/employee-salary")
    @ApiMethod(description = "To get employee salary only")
    public ResponseEntity<List<Double>> findEmployeeSalary(){
        List<Double> employee = employeeService.findAllEmployeeSalary();
        logger.info("methodName: {}", "findEmployeeSalary");
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }
}

/*
    http://localhost:9999/jsondoc-ui.html
    http://localhost:9999/jsondoc
 */