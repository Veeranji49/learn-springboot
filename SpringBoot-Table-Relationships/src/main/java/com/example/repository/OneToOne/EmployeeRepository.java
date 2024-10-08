package com.example.repository.OneToOne;

import com.example.entity.OneToOne.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT name FROM Employee ")
    List<String> findAllNames();
}