package com.example.Controller.DB.ManyToOne;

import com.example.Entity.DB.ManyToOne.Order;
import com.example.Service.DB.ManyToOne.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @PostMapping(value="/add-order")
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        Order o = orderService.createOrder(order);
        logger.info("MethodName : {}", "Order :{}", order);
        return new ResponseEntity<>(o, HttpStatus.CREATED);
    }

    @GetMapping(value="/getone-order/{id}")
    public ResponseEntity<Order> getOne(@PathVariable long id){
        Order order = orderService.getOrder(id);
        logger.info("MethodName : {}", "getOne", "id: {}",id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping(value="/getall-orders")
    public ResponseEntity<List<Order>> getallOrders(){
        List<Order> orders = orderService.getAllOrders();
        logger.info("MethodName : {}", "getallOrders", "orders: {}",orders);
        return new ResponseEntity<>(orders,HttpStatus.OK);
    }

    @DeleteMapping(value="/delete-order/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable long id) {
        orderService.deleteOrder(id);
        logger.info("MethodName : {}", "deleteOrder", "id: {}",id);
        return ResponseEntity.ok("order is deleted");
    }

    @PutMapping(value="/update-order/{id}")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order, @PathVariable long id) {
        Order order1 = orderService.updateOrder(order,id);
        logger.info("MethodName : {}", "updateOrder", "id: {}",id);
        return new ResponseEntity<>(order1, HttpStatus.OK);
    }
}
