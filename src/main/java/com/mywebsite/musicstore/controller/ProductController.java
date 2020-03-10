package com.mywebsite.musicstore.controller;


import com.mywebsite.musicstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;


    @GetMapping("/productList")
    public String getProductList(Model model)
    {
        model.addAttribute("productList",productService.getProductList());
        return "productList";
    }
    @GetMapping("/viewProduct/{productId}")
    public String getProductList(@PathVariable int productId, Model model)
    {
        model.addAttribute("product",productService.getProductById(productId));
        return "viewProduct";
    }
}
