package com.mywebsite.musicstore.service;

import com.mywebsite.musicstore.model.Customer;

import java.util.List;

public interface CustomerService {

    void addCustomer(Customer customer);
    Customer getCustomerById(int customerId);
    Customer getCustomerByUsername(String username);
    void editCustomer(Customer customer);
    void deleteCustomerById(int customerId);
    List<Customer> getAllCustomer();
}
