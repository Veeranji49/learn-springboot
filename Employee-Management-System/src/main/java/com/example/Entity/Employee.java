package com.example.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	private double fees;
	private String location;
	private String wages;
	
	public Employee() {}

	public Employee(long id, String name, double fees, String location,String wages) {
		super();
		this.id = id;
		this.name = name;
		this.fees = fees;
		this.location = location;
		this.wages=wages;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getWages() {
		return wages;
	}

	public void setWages(String wages) {
		this.wages = wages;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", fees=" + fees + ", location=" + location + ", wages="
				+ wages + "]";
	}


	
}
