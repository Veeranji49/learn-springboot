package com.SpringBoot.SpringBootReactRegistration1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.SpringBootReactRegistration1.Entity.Employee;
import com.SpringBoot.SpringBootReactRegistration1.Service.EmployeeService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/save")
	public String addEmployee(@RequestBody Employee employee)
	{
		String id=employeeService.addEmployee(employee);
		return "Employee added Successfully";
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable long id)
	{
		employeeService.deleteEmployee(id);
		return "Employee deleted";
	}
	
	@PutMapping("/update/{id}")
	public String update(@RequestBody Employee employee, @PathVariable long id)
	{
		employeeService.updateEmployee(employee, id);
		return "Updated Successfully";
	}
	
	@GetMapping("/get/{id}")
	public Employee getonee(@PathVariable long id)
	{
		Employee employee=employeeService.getone(id);
		return employee;
	}
	
	@GetMapping("/getall")
	public List<Employee> getalll()
	{
		List<Employee> list=employeeService.getall();
		return list;
	}
	
	
	
	
	
	
	
}
