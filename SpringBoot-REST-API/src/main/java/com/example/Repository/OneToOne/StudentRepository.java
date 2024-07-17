package com.example.Repository.OneToOne;

import com.example.Entity.DB.OneToOne.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Define a query to fetch only the student names
    @Query("SELECT name FROM Student")
    List<String> findByName();


    // Define a query to fetch only the student age
    @Query("SELECT age FROM Student")
    List<Integer> findbyAge();

}
