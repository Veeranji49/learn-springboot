package com.example.Repository;

import com.example.Entity.DB.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query("SELECT name,email from Employee")
    public List<String> findNameEmail();

    @Query("SELECT name,location FROM Employee ")
    public List<String> findNameLocation();

    @Query("SELECT salary FROM Employee")
    public List<Double> findSalary();

}
