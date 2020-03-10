package com.mywebsite.musicstore.dao;

import com.mywebsite.musicstore.model.Customer;

import java.util.List;

public interface CustomerDao
{
    void addCustomer(Customer customer);
    Customer getCustomerById(int customerId);
    void editCustomer(Customer customer);
    void deleteCustomer(Customer customer);
    List<Customer> getAllCustomer();
}
