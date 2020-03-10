package com.mywebsite.musicstore.controller.admin;

import com.mywebsite.musicstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminHome {

    @Autowired
    ProductService productService;

    @RequestMapping
    public String adminPage()
    {
        return "admin";
    }

    @RequestMapping("/productInventory")
    public String productInventory(Model model)
    {
        model.addAttribute("products", productService.getProductList());
        return "productInventory";
    }


    @RequestMapping("/customerManagement")
    public String customerManagement()
    {
        return "customerManagement";
    }

}
