package com.example.Controller.DB.OneToOne;

import com.example.Entity.DB.OneToOne.Student;
import com.example.Service.DB.OneToOne.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    //**   http://localhost:9999/springboot_restapi/api/v1/students/add-student
    @PostMapping(value="/add-student")
    public ResponseEntity<Student> addStudent(@RequestBody  Student student) {
        Student std = studentService.createStudent(student);
        logger.info("MethodName: {}", "addStudent" , "student: {}", student);
        return new ResponseEntity<>(std, HttpStatus.CREATED);
    }

    //**  http://localhost:9999/springboot_restapi/api/v1/students/update-student/3
    @PutMapping(value="/update-student/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody  Student student, @PathVariable long id) {
        Student std = studentService.updateStudent(student, id);
        logger.info("MethodName: {}", "updateStudent" , "student: {}", student , "id: {}",id);
        return new ResponseEntity<>(std, HttpStatus.OK);
    }

    //**   http://localhost:9999/springboot_restapi/api/v1/students/delete-student/3
    @DeleteMapping(value="/delete-student/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable long id) {
        studentService.deleteStudent(id);
        logger.info("MethodName: {}", "deleteStudent" , "id: {}", id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //**  http://localhost:9999/springboot_restapi/api/v1/students/get-student/2
    @GetMapping(value="/get-student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable long id) {
        Student std = studentService.getStudent(id);
        logger.info("MethodName: {}", "getStudent" , "id: {}", id);
        return new ResponseEntity<>(std, HttpStatus.OK);
    }

    //**  http://localhost:9999/springboot_restapi/api/v1/students/getall-students
    @GetMapping(value="/getall-students")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        logger.info("MethodName: {}", "getAllStudents" , "students: {}", students);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    ////   Retrieving specific Columns   ////

    //**    http://localhost:9999/springboot_restapi/api/v1/students/students-names
    @GetMapping(value="/students-names")
    public ResponseEntity<List<String>> getStudentNames(){
        List<String> students = studentService.getStudentsByName();
        logger.info("MethodName: {}", "getStudentNames" , "students: {}", students);
        return new ResponseEntity<>(students,HttpStatus.OK);
    }

    //***   http://localhost:9999/springboot_restapi/api/v1/students/students-age
    @GetMapping(value="/students-age")
    public ResponseEntity<List<Integer>> getStudentAge(){
        List<Integer> students = studentService.getStudentByAge();
        logger.info("MethodName: {}", "getStudentAge" , "students: {}", students);
        return new ResponseEntity<>(students,HttpStatus.OK);
    }

    //**  http://localhost:9999/springboot_restapi/api/v1/students/add-new-student
    @PutMapping(value="/add-new-student")
    public ResponseEntity<Student> addNewStudent(@RequestBody  Student student) {
        Student std = studentService.createStudent(student);
        logger.info("MethodName: {}", "addNewStudent" , "student: {}", student);
        return new ResponseEntity<>(std, HttpStatus.CREATED);
    }

}
