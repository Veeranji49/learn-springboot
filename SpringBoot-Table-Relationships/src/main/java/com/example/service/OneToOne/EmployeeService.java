package com.example.service.OneToOne;

import com.example.entity.OneToOne.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee saveEmployee(Employee employee);

    public Employee getEmployeeById(long id);

    public List<Employee> getAllEmployees();

    public void deleteEmployee(long id);

    public Employee updateEmployee(Employee employee, long id);

    public List<String> getallNames();
}