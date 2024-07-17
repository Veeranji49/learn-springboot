package com.spring.Spring_Hibernate_CRUD.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

	@Id
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="salary")
	private int salary;
	
	@Column(name="location")
	private String location;
	
	@Column(name="contact")
	private int contact;
	
	@Column(name="age ")
	private int age;
	
	//PDC
	public Employee() {}

	//PPC
	public Employee(int id, String name, int salary, String location, int contact, int age) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.location = location;
		this.contact = contact;
		this.age = age;
	}

	//PSM & PGM
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", location=" + location + ", contact="
				+ contact + ", age=" + age + "]";
	}
	
	
}
