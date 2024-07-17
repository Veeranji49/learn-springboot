package com.app.service;

import java.util.List;

import com.app.entity.Student;

public interface StudentService {

	public Student saveStudent(Student student);
	public Student updateStudent(Student student, long id);
	public void deleteStudent(long id);
	public Student getOneStudent(long id);
	public List<Student> getAll();
}
