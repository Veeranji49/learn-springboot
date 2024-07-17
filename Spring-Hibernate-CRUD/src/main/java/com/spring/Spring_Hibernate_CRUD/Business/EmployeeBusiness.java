package com.spring.Spring_Hibernate_CRUD.Business;

import java.util.List;

import com.spring.Spring_Hibernate_CRUD.Entity.Employee;

public interface EmployeeBusiness {

	public void saveEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public void deleteEmployee(Employee employee);
	public Employee getone(int id);
	public List<Employee> getall();
}
