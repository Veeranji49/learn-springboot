package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Student;
import com.app.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student updateStudent(Student student, long id) {
		Student std = studentRepository.findById(id).get();
		std.setName(student.getName());
		std.setFees(student.getFees());
		std.setIshealthy(student.isIshealthy());
		std.setLocation(student.getLocation());
		return studentRepository.save(std);
	}

	@Override
	public void deleteStudent(long id) {
		studentRepository.deleteById(id);
	}

	@Override
	public Student getOneStudent(long id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public List<Student> getAll() {
		return studentRepository.findAll();
	}

}
