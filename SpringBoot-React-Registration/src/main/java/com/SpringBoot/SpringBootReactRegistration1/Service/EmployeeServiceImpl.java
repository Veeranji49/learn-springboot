package com.SpringBoot.SpringBootReactRegistration1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.SpringBootReactRegistration1.Entity.Employee;
import com.SpringBoot.SpringBootReactRegistration1.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public String addEmployee(Employee employee) {
		
		Employee emp=new Employee(
				employee.getId(),
				employee.getName(),
				employee.getSalary(),
				employee.getAddress(),
				employee.getCompany_name()
				);
		employeeRepository.save(emp);
				
		return "Employee successfully added";
	}

	@Override
	public void deleteEmployee(long id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		Employee emp=employeeRepository.findById(id).get();
		emp.setName(employee.getName());
		emp.setSalary(employee.getSalary());
		emp.setAddress(employee.getAddress());
		emp.setCompany_name(employee.getCompany_name());
		
		return employeeRepository.save(emp);
	}

	@Override
	public Employee getone(long id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public List<Employee> getall() {
		List<Employee> list=employeeRepository.findAll();
		return list;
	}

}
