package com.example.Repository.ManyToMany;

import com.example.Entity.DB.ManyToMany.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    @Query("SELECT name,category FROM Doctor")
    List<String> findNameCategory();

    @Query("SELECT d FROM Doctor d WHERE d.patients IS EMPTY")
    List<Doctor> findDoctorsWithNoPatients();
}
