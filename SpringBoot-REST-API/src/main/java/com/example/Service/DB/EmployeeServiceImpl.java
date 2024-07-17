package com.example.Service.DB;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.Entity.DB.Employee;
import com.example.Exception.ResourceNotFoundException;
import com.example.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        Employee emp=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee id is not found:"+id));
        emp.setName(employee.getName());
        emp.setSalary(employee.getSalary());
        emp.setAge(employee.getAge());
        emp.setEmail(employee.getEmail());
        emp.setLocation(employee.getLocation());
        emp.setIs_healthy(employee.getIs_healthy());
        return employeeRepository.save(emp);
    }

    @Override
    public void deleteEmployee(long id) {
    	try {
    		employeeRepository.deleteById(id);
    	}
    	catch(Exception ex)
    	{
    		throw new ResourceNotFoundException("Employee Id is not found:"+id);
    	}
    }

    @Override
    public Employee getOneEmployee(long id) {
        return employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee id is not found:"+id));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public long getEmployeesCount() {
        return employeeRepository.count();
    }

    @Override
    public List<String> findAllEmployeeNamesEmail() {
        return employeeRepository.findNameEmail();
    }

    @Override
    public List<String> findAllEmployeeNamesLocations() {
        return employeeRepository.findNameLocation();
    }

    @Override
    public List<Double> findAllEmployeeSalary() {
        return employeeRepository.findSalary();
    }

}
