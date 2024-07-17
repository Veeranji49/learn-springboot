package com.example.Service.DB.ManyToOne;

import com.example.Entity.DB.ManyToOne.Order;
import com.example.Repository.ManyToOne.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Order order, long id) {
        Order order1 = orderRepository.findById(id).get();
        order1.setName(order.getName());
        order1.setOrderDate(order.getOrderDate());
        order1.setTotal_amt(order.getTotal_amt());
        return orderRepository.save(order1);
    }

    @Override
    public void deleteOrder(long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order getOrder(long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
