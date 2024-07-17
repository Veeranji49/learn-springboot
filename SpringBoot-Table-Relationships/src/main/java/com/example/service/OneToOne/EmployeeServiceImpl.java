package com.example.service.OneToOne;

import com.example.entity.OneToOne.Employee;
import com.example.repository.OneToOne.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        Employee emp = employeeRepository.findById(id).get();
        emp.setName(employee.getName());
        emp.setSalary(employee.getSalary());
        emp.setAddress(employee.getAddress());
        return employeeRepository.save(emp);
    }

    @Override
    public List<String> getallNames() {
        return employeeRepository.findAllNames();
    }
}