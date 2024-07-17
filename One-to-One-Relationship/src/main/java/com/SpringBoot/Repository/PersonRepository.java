package com.SpringBoot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBoot.Entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {

}
