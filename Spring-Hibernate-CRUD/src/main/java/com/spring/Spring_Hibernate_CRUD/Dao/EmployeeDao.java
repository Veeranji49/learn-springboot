package com.spring.Spring_Hibernate_CRUD.Dao;

import com.spring.Spring_Hibernate_CRUD.Entity.Employee;
import java.util.*;

public interface EmployeeDao {

	public void saveEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public void deleteEmployee(Employee employee);
	public Employee getone(int id);
	public List<Employee> getall();
	
}
