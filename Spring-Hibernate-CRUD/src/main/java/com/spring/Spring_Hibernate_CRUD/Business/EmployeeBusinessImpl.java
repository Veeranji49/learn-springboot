package com.spring.Spring_Hibernate_CRUD.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.spring.Spring_Hibernate_CRUD.Dao.EmployeeDao;
import com.spring.Spring_Hibernate_CRUD.Entity.Employee;

@Component
public class EmployeeBusinessImpl implements EmployeeBusiness {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Transactional(readOnly=false)
	@Override
	public void saveEmployee(Employee employee) {
		employeeDao.saveEmployee(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
	}

	@Override
	public void deleteEmployee(Employee employee) {
		employeeDao.deleteEmployee(employee);
	}

	@Override
	public Employee getone(int id) {
		return employeeDao.getone(id);
	}

	@Override
	public List<Employee> getall() {
		return employeeDao.getall();
	}

}
