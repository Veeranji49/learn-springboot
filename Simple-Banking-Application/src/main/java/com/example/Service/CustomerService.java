package com.example.Service;

import com.example.Entity.Customer;

import java.util.List;

public interface CustomerService {

    public void addCustomer(Customer customer);

    public void deleteCustomerById(long id);

    public Customer getCustomerById(long id);

    public List<Customer> getAllCustomers();
}
