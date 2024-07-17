package com.app.entity;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
@ApiObject
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiObjectField(name = "student id", description = "Auto generated id")
	private long id;
	
	@ApiObjectField(name = "student name", description= "students name")
	private String name;
	
	@ApiObjectField(name = "student fees", description = "student fees")
	private double fees;
	
	@ApiObjectField(name = "student health", description = "student is healthy or not")
	private boolean ishealthy;
	
	@ApiObjectField(name = "student location", description = "student address")
	private String location;
	
	public Student() {
		
	}

	public Student(long id, String name, double fees, boolean ishealthy, String location) {
		super();
		this.id = id;
		this.name = name;
		this.fees = fees;
		this.ishealthy = ishealthy;
		this.location = location;
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

	public boolean isIshealthy() {
		return ishealthy;
	}

	public void setIshealthy(boolean ishealthy) {
		this.ishealthy = ishealthy;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", fees=" + fees + ", ishealthy=" + ishealthy + ", location="
				+ location + "]";
	}
	
	
}
