package com.SpringBoot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBoot.Entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

}
