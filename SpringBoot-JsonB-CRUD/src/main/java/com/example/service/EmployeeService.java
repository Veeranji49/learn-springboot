package com.example.service;

import com.example.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee saveEmployee(Employee employee);
    public Employee getEmployeeById(long id);
    public Employee updateEmployee(Employee employee,long id);
    public void deleteEmployee(long id);
    public List<Employee> getAllEmployees();
}
