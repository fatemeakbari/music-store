package com.mywebsite.musicstore.service.impl;

import com.mywebsite.musicstore.dao.CustomerDao;
import com.mywebsite.musicstore.model.Customer;
import com.mywebsite.musicstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerDao customerDao;

    public void addCustomer(Customer customer){
        customerDao.addCustomer(customer);
    }

    public Customer getCustomerById(int customerId){
        return customerDao.getCustomerById(customerId);
    }
    public Customer getCustomerByUsername(String username){ return customerDao.getCustomerByUsername(username);}


    public void editCustomer(Customer customer){
        customerDao.editCustomer(customer);
    }

    public void deleteCustomerById(int customerId){
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        customerDao.deleteCustomer(customer);
    }

    public List<Customer> getAllCustomer(){
        return customerDao.getAllCustomer();
    }
}
