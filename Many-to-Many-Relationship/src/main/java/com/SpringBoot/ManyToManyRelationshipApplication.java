package com.SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.SpringBoot.Entity.Course;
import com.SpringBoot.Entity.Student;
import com.SpringBoot.Repository.StudentRepository;

@SpringBootApplication
public class ManyToManyRelationshipApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ManyToManyRelationshipApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public void run(String... args) throws Exception {

		Student std=new Student("anji",24,"peddakadabur"); // 1
		Student std2=new Student("veeru",24,"adoni"); // 2
		
		Course course1=new Course("Devops",25000);
		Course course2=new Course("Linux",20000);
		Course course3=new Course("AWS",23000);
		
		//add course reference student
		std.getCourses().add(course1);
		std.getCourses().add(course2);
		std.getCourses().add(course3);
		
		//add course reference student
		std2.getCourses().add(course1);
		std2.getCourses().add(course2);
		std2.getCourses().add(course3);
		
		
		//add student reference course
		course1.getStudents().add(std);
		course2.getStudents().add(std);
		course3.getStudents().add(std);
		
		//add student reference course
		course1.getStudents().add(std2);
		course2.getStudents().add(std2);
		course3.getStudents().add(std2);
		
		studentRepository.save(std);
		studentRepository.save(std2);
	}

}
