package com.example.Repository.OneToOne;

import com.example.Entity.DB.OneToOne.StudentAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentAddressRepository extends JpaRepository<StudentAddress, Long> {

    @Query("SELECT street FROM StudentAddress ")
    List<String> findByStreet();

    @Query("SELECT city FROM  StudentAddress ")
    List<String> findByCity();

    @Query("SELECT state FROM StudentAddress ")
    List<String> findByState();

    @Query("SELECT street,city,state FROM StudentAddress ")
    List<String> findByStreetStateAndCity();
}
