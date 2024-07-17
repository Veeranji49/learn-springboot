package com.example.Service;

import com.example.Entity.Customer;
import com.example.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomerById(long id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer != null) {
            customerRepository.deleteById(id);
        } else {
            throw new RuntimeException("Customer ID is invalid");
        }
    }

    @Override
    public Customer getCustomerById(long id) {
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer ID is invalid"));

    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
