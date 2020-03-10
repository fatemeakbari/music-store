package com.mywebsite.musicstore.dao;

import com.mywebsite.musicstore.model.Product;

import java.util.List;

public interface ProductDao {

    void addProduct(Product product);

    Product getProductById(int id);

    List<Product> getAllProducts();

    void deleteProduct(Product product);

    void editProduct(Product product);
}
