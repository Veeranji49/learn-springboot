package com.example.Service.DB.OneToOne;

import com.example.Entity.DB.OneToOne.Student;

import java.util.List;

public interface StudentService {

    public Student createStudent(Student student);
    public Student updateStudent(Student student,long id);
    public void deleteStudent(long id);
    public Student getStudent(long id);
    public List<Student> getAllStudents();
    public List<String> getStudentsByName();
    public List<Integer> getStudentByAge();
}
