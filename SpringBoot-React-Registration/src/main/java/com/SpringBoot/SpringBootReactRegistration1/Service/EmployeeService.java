package com.SpringBoot.SpringBootReactRegistration1.Service;

import java.util.List;

import com.SpringBoot.SpringBootReactRegistration1.Entity.Employee;

public interface EmployeeService {

	public String addEmployee(Employee employee);
	public void deleteEmployee(long id);
	public Employee updateEmployee(Employee employee,long id);
	public Employee getone(long id);
	public List<Employee> getall();
}
