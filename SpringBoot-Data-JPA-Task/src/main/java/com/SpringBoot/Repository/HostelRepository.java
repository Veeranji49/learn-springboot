package com.SpringBoot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBoot.Entity.Hostel;

@Repository
public interface HostelRepository  extends JpaRepository<Hostel, Long>{

}
