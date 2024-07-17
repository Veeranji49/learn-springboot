package com.example.Service.DB;

import com.example.Entity.DB.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {

    public Employee saveEmployee(Employee employee);

    public Employee updateEmployee(Employee employee, long id);

    public void deleteEmployee(long id);

    public Employee getOneEmployee(long id);

    public List<Employee> getAllEmployees();

    public Page<Employee> findAll(Pageable pageable);

    public long getEmployeesCount();

    public List<String> findAllEmployeeNamesEmail();

    public List<String> findAllEmployeeNamesLocations();

    public List<Double> findAllEmployeeSalary();

}
