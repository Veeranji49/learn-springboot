package com.example.Service.DB.OneToOne;

import com.example.Entity.DB.OneToOne.Student;
import com.example.Repository.OneToOne.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student, long id) {
        Student std=studentRepository.findById(id).get();
        std.setName(student.getName());
        std.setAge(student.getAge());
        std.setAddress(student.getAddress());
        return studentRepository.save(std);
    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student getStudent(long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<String> getStudentsByName() {
        return studentRepository.findByName();
    }

    @Override
    public List<Integer> getStudentByAge() {
        return studentRepository.findbyAge();
    }
}
