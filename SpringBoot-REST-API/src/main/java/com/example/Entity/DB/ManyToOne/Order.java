package com.example.Entity.DB.ManyToOne;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Date orderDate;
    private double total_amt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="customer_id",referencedColumnName = "id")
    private Customer customer;

    public Order(){

    }

    public Order(Customer customer, long id, String name, Date orderDate, double total_amt) {
        this.customer = customer;
        this.id = id;
        this.name = name;
        this.orderDate = orderDate;
        this.total_amt = total_amt;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotal_amt() {
        return total_amt;
    }

    public void setTotal_amt(double total_amt) {
        this.total_amt = total_amt;
    }
}
