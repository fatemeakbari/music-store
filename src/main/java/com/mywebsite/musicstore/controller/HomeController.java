package com.mywebsite.musicstore.controller;

import com.mywebsite.musicstore.dao.ProductDao;
import com.mywebsite.musicstore.model.Product;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller

public class HomeController {

    private ProductDao productDao = new ProductDao();
    @RequestMapping("/")
    public String home()
    {
        return "home";
    }

    @RequestMapping("/productList")
    public String getProducts(Model model)
    {
        List<Product> productList = productDao.getProductList();
        model.addAttribute("productList",productList);
        return "productList";

    }

}
