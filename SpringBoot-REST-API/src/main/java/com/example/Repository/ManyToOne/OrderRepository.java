package com.example.Repository.ManyToOne;

import com.example.Entity.DB.ManyToOne.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
