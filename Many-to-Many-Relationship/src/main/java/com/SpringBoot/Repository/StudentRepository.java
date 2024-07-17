package com.SpringBoot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBoot.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

}
