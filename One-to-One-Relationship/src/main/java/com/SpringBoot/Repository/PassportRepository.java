package com.SpringBoot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBoot.Entity.Passport;

@Repository
public interface PassportRepository extends JpaRepository<Passport,Long> {

}
