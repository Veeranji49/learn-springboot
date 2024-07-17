package com.example.Repository;

import com.example.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

  /*  @Query("SELECT name FROM Employee")
    List<String> findAllNames();

    @Query("SELECT salary FROM Employee")
    List<Double> findAllSalaries();

    @Query("SELECT location FROM Employee")
    List<String> findAllLocations();

    @Query("SELECT name,location FROM Employee")
    List<String> findNameLocation();*/

}
