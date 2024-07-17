package com.spring.Spring_Hibernate_CRUD.Dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.spring.Spring_Hibernate_CRUD.Entity.Employee;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional(readOnly=false)
	@Override
	public void saveEmployee(Employee employee) {
		hibernateTemplate.save(employee);
	}

	@Transactional(readOnly=false)
	@Override
	public void updateEmployee(Employee employee) {
		hibernateTemplate.update(employee);
	}

	@Transactional(readOnly=false)
	@Override
	public void deleteEmployee(Employee employee) {
		hibernateTemplate.delete(employee);
	}

	@Transactional(readOnly=false)
	@Override
	public Employee getone(int id) {
		Employee emp=hibernateTemplate.get(Employee.class, id);
		return emp;
	}

	@Transactional(readOnly=false)
	@Override
	public List<Employee> getall() {
		return hibernateTemplate.loadAll(Employee.class);
	}

}
