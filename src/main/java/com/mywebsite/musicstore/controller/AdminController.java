package com.mywebsite.musicstore.controller;

import com.mywebsite.musicstore.dao.ProductDao;
import com.mywebsite.musicstore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class AdminController {


    @Autowired
    private ProductDao productDao;

    private Path path;

    @RequestMapping("/admin")
    public String adminPage()
    {
        return "admin";
    }

    @RequestMapping("/admin/productInventory/")
    public String productInventory( Model model)  {
        List<Product> productList = productDao.getAllProducts();
        model.addAttribute("productList",productList);
        return "productInventory";
    }

    @RequestMapping("/admin/productInventory/addProduct")
    public String addProduct( Model model)  {

        Product product = new Product();
        product.setProductCategory("instrument");
        product.setProductCondition("new");
        product.setProductStatus("active");

        model.addAttribute("product",product);


        return "addProduct";
    }

    @RequestMapping(value = "/admin/productInventory/addProduct", method = RequestMethod.POST)
    public String addProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result) throws IOException {

        if(result.hasErrors())
            return "addProduct";
        productDao.addProduct(product);

        MultipartFile productImage = product.getProductImage();
        String rootDirectory = "/home/fateme/project/javaEE/musicStore/src/main/webapp/resources/images/";

        if(productImage != null && !productImage.isEmpty())
        {
            try
            {
                productImage.transferTo(new File(rootDirectory+product.getProductId()+".png"));
            }
            catch (Exception e)
            {
                e.printStackTrace();
                throw new RuntimeException("saving image file failed", e);
            }
        }
        return "redirect:/admin/productInventory/";
    }

    @RequestMapping(value = "/admin/productInventory/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable Long productId)  {
        String rootDir = "/home/fateme/project/javaEE/musicStore/src/main/webapp/resources/images/";
        Path imgPath = Paths.get(rootDir + productId + ".png");
        if (Files.exists(imgPath))
        {
            try {
                Files.delete(imgPath);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }


        productDao.deleteProductById(productId);
        return "redirect:/admin/productInventory/";
    }

    @RequestMapping("/admin/productInventory/editProduct/{productId}")
    public String editProduct(@PathVariable Long productId, Model model)
    {
        Product product = productDao.getProductById(productId);
        model.addAttribute("product", product);
        return "editProduct";
    }

    @RequestMapping(value = "/admin/productInventory/editProduct", method = RequestMethod.POST)
    public String editProduct(@ModelAttribute Product product)
    {
        MultipartFile productImage = product.getProductImage();
        String rootDirectory = "/home/fateme/project/javaEE/musicStore/src/main/webapp/resources/images/";

        if(productImage != null && !productImage.isEmpty())
        {
            try
            {
                productImage.transferTo(new File(rootDirectory+product.getProductId()+".png"));
            }
            catch (Exception e)
            {
                e.printStackTrace();
                throw new RuntimeException("saving image file failed", e);
            }
        }

        productDao.editProduct(product);
        return "redirect:/admin/productInventory/";
    }
}
