package com.example.Repository.ManyToOne;

import com.example.Entity.DB.ManyToOne.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
