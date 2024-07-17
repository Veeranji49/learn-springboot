package com.app.controller;

import java.util.List;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiVisibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Student;
import com.app.service.StudentService;

@Api(name = "Student Controller", description = "This is a student controller for demonstration purposes",group="Student Management",visibility = ApiVisibility.PUBLIC)
@RestController
@RequestMapping(value="/api/v1/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@ApiMethod(description = "Get sample message")
	@GetMapping(value="/msg")
	public ResponseEntity<String> msg(){
		String msg = "Welcome to Spring-Boot-JsonDoc";
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	@ApiMethod(description = "To post the student details")
	@PostMapping(value="/save")
	public ResponseEntity<Student> save(@RequestBody Student student){
		Student std = studentService.saveStudent(student);
		return new ResponseEntity<>(std,HttpStatus.CREATED);
	}
	
	@ApiMethod(description = "To update the student details",path= {"id"})
	@PutMapping(value="/update/{id}")
	public ResponseEntity<Student> update(@RequestBody Student student, @PathVariable @ApiPathParam(description = "input student id to update", name="id") long id){
		Student std = studentService.updateStudent(student, id);
		return new ResponseEntity<>(std,HttpStatus.OK);
	}
	
	@ApiMethod(description = "To delete the student details", path = {"id"})
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable @ApiPathParam(description = "input student id to delete",name="id") long id){
		studentService.deleteStudent(id);
		return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
	}
	
	@ApiMethod(description = "To get the one student detail",path= {"id"})
	@GetMapping(value="/getone/{id}")
	public ResponseEntity<Student> getOne(@PathVariable @ApiPathParam(description="input student id to get",name="id") long id){
		Student std = studentService.getOneStudent(id);
		return new ResponseEntity<>(std,HttpStatus.OK);
	}
	@ApiMethod(description = "To get all the student details")
	@GetMapping(value="/getall")
	public ResponseEntity<List<Student>> getall(){
		List<Student> student = studentService.getAll();
		return new ResponseEntity<>(student,HttpStatus.OK);
		
	}
}

/*
 	
 	http://localhost:8080/jsondoc-ui.html
 	http://localhost:8080/jsondoc
 	
 */
