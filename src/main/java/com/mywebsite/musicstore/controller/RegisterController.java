package com.mywebsite.musicstore.controller;

import com.mywebsite.musicstore.model.BillingAddress;
import com.mywebsite.musicstore.model.Customer;
import com.mywebsite.musicstore.model.ShippingAddress;
import com.mywebsite.musicstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private CustomerService customerService;


    @RequestMapping("/register")
    public String registerCustomer(Model model)
    {
        Customer customer = new Customer();
        BillingAddress billingAddress = new BillingAddress();
        ShippingAddress shippingAddress = new ShippingAddress();
        customer.setBillingAddress(billingAddress);
        customer.setShippingAddress(shippingAddress);

        model.addAttribute("customer", customer);

        return "registerCustomer";
    }

  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public String registerCustomer( @ModelAttribute Customer customer) {
        customer.setEnabled(true);
    customerService.addCustomer(customer);
    return "registerCustomerSuccess";
    }
}
