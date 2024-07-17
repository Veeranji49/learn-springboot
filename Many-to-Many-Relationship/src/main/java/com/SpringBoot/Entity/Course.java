package com.SpringBoot.Entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String course_name;
	private double course_fees;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "courses")
	private Set<Student> students = new HashSet<>();

	public Course() {
	}

	public Course(String course_name, double course_fees) {
		super();
		this.course_name = course_name;
		this.course_fees = course_fees;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public double getCourse_fees() {
		return course_fees;
	}

	public void setCourse_fees(double course_fees) {
		this.course_fees = course_fees;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

}
