package com.example.Controller;

import com.example.Entity.Employee;
import com.example.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/msg")
    public ResponseEntity<String> msg() {
        String msg = "Welcome to Spring Authentication and Authorization";
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    //@PreAuthorize("hasAuthority('ROLE_USER')")
    @PostMapping(value = "/save-employee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        Employee emp = employeeService.save(employee);
        return new ResponseEntity<>(emp, HttpStatus.CREATED);
    }

    //@PreAuthorize("hasAuthority('ROLE_USER')")
    @PutMapping(value = "/update-employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable long id) {
        Employee emp = employeeService.update(employee, id);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    //@PreAuthorize("hasAuthority('ROLE_USER')")
    @DeleteMapping(value = "/delete-employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long id) {
        employeeService.deleteById(id);
        String msg = "Deleted Successfully";
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    //@PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping(value = "/getone/{id}")
    public ResponseEntity<Employee> getoneEmployee(@PathVariable long id) {
        Employee emp = employeeService.findById(id);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/getall")
    public ResponseEntity<List<Employee>> getall() {
        List<Employee> list = employeeService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
