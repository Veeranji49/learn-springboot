package com.example.Service;

import com.example.Entity.Employee;
import com.example.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Employee employee, long id) {
        Employee emp = employeeRepository.findById(id).get();
        emp.setName(employee.getName());
        emp.setSalary(employee.getSalary());
        emp.setLocation(employee.getLocation());
        return employeeRepository.save(emp);
    }

    @Override
    public void deleteById(long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findById(long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

/*    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public List<String> findAllNames() {
        return employeeRepository.findAllNames();
    }

    @Override
    public List<String> findAllLocation() {
        return employeeRepository.findAllLocations();
    }

    @Override
    public List<Double> findAllSalary() {
        return employeeRepository.findAllSalaries();
    }

    public List<String> findNameLocation(){
        return employeeRepository.findNameLocation();
    }*/
}
