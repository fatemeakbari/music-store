package com.mywebsite.musicstore.service.impl;

import com.mywebsite.musicstore.dao.ProductDao;
import com.mywebsite.musicstore.model.Product;
import com.mywebsite.musicstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    public List<Product> getProductList()
    {
        return productDao.getAllProducts();
    }
    public Product getProductById(int productId)
    {
        return productDao.getProductById(productId);
    }
    public void addProduct(Product product)
    {
        productDao.addProduct(product);
    }
    public void editProduct(Product product)
    {
        productDao.editProduct(product);
    }
    public void deleteProduct(Product product)
    {
        productDao.deleteProduct(product);
    }
}
