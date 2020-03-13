package com.mywebsite.musicstore.controller;

import com.mywebsite.musicstore.model.Customer;
import com.mywebsite.musicstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart/customer")
public class CartController {


    @Autowired
    CustomerService customerService;


    @RequestMapping
    public String getCart(@AuthenticationPrincipal User activeUser)
    {
        Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
        int cartId = customer.getCart().getCartId();

        return "redirect:/cart/customer/"+cartId;
    }

    @RequestMapping("/{cartId}")
    public String getCartRedirect(@PathVariable int cartId, Model model)
    {
        model.addAttribute("cartId",cartId);
        return "cart";
    }
}
