package com.mywebsite.musicstore.controller.admin;

import com.mywebsite.musicstore.model.Product;
import com.mywebsite.musicstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminProduct {

    @Autowired
    private ProductService productService;
    @RequestMapping("/product/addProduct")
    public String addProduct(Model model)
    {
        Product product = new Product();
        product.setProductCategory("Instrument");
        product.setProductCondition("Active");
        product.setProductStatus("New");
        model.addAttribute("product",product);
        return "addProduct";
    }
    @RequestMapping(value = "/product/addProduct", method = RequestMethod.POST)
    public String addProductPost(@Valid @ModelAttribute Product product, BindingResult result)
    {
        if(result.hasErrors()){
            return "addProduct";
        }
        productService.addProduct(product);
        return "redirect:/admin/productInventory";
    }

    @RequestMapping("/product/editProduct/{productId}")
    public String editProduct(@PathVariable int productId, Model model)
    {
        model.addAttribute("product",productService.getProductById(productId));
        return "editProduct";
    }

    @RequestMapping(value = "/product/editProduct", method = RequestMethod.POST)
    public String editProductPost(@Valid @ModelAttribute Product product, BindingResult result)
    {
        if(result.hasErrors()){
            return "editproduct";
        }
        productService.editProduct(product);
        return "redirect:/admin/productInventory";
    }

    @RequestMapping("/product/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable int productId, Model model)
    {
        Product product = new Product();
        product.setProductId(productId);
        productService.deleteProduct(product );
        return "redirect:/admin/productInventory";
    }
}
