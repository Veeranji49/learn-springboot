package com.example.Service.DB.ManyToOne;

import com.example.Entity.DB.ManyToOne.Order;

import java.util.List;

public interface OrderService {

    public Order createOrder(Order order);
    public Order updateOrder(Order order,long id);
    public void deleteOrder(long id);
    public Order getOrder(long id);
    public List<Order> getAllOrders();
}
