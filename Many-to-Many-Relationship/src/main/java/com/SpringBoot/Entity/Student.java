package com.SpringBoot.Entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String student_name;
	private int student_age;
	private String std_location;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "students_courses", 
			joinColumns = { @JoinColumn(name = "std_id") }, 
			inverseJoinColumns = {@JoinColumn(name = "course_id") })
	private Set<Course> courses = new HashSet<>();

	public Student() {
	}

	public Student(String student_name, int student_age, String std_location) {
		super();
		this.student_name = student_name;
		this.student_age = student_age;
		this.std_location = std_location;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public int getStudent_age() {
		return student_age;
	}

	public void setStudent_age(int student_age) {
		this.student_age = student_age;
	}

	public String getStd_location() {
		return std_location;
	}

	public void setStd_location(String std_location) {
		this.std_location = std_location;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

}
