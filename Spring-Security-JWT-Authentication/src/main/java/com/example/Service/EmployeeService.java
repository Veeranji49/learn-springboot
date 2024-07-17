package com.example.Service;

import com.example.Entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {

    public Employee save(Employee employee);
    public Employee update(Employee employee,long id);
    public void deleteById(long id);
    public Employee findById(long id);
    public List<Employee> findAll();
   /* public Page<Employee> findAll(Pageable pageable);
    public List<String> findAllNames();
    public List<String> findAllLocation();
    public List<Double> findAllSalary();
    public List<String> findNameLocation();*/
}
