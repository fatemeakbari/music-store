package com.mywebsite.musicstore.controller;

import com.mywebsite.musicstore.model.*;
import com.mywebsite.musicstore.service.CartService;
import com.mywebsite.musicstore.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerOrderController {

    @Autowired
    CustomerOrderService customerOrderService;

    @Autowired
    CartService cartService;

    @RequestMapping("/order/{cartId}")
    public String createOrder(@PathVariable int cartId)
    {
        CustomerOrder customerOrder = new CustomerOrder();
        Cart cart = cartService.getCartById(cartId);
        Customer customer = cart.getCustomer();

        customerOrder.setCustomer(customer);
        customerOrder.setCart(cart);
        customerOrder.setBillingAddress(customer.getBillingAddress());
        customerOrder.setShippingAddress(customer.getShippingAddress());

        customerOrderService.addCustomerOrder(customerOrder);

        return "redirect:checkout?cartId="+cartId;
    }
}
