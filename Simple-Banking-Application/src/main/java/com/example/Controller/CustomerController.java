package com.example.Controller;

import com.example.Entity.Account;
import com.example.Entity.Customer;
import com.example.Service.AccountService;
import com.example.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AccountService accountService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping("/customer")
    public void addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
        accountService.saveAccounts(new Account(customer.getId(), "Savings", "active", new Double(0)));
    }

    @GetMapping("/customer/id/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @DeleteMapping("/customer/id/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomerById(id);
        accountService.deleteAccountById(id);
    }

}