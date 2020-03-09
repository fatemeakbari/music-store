package com.mywebsite.musicstore.dao;

import com.mywebsite.musicstore.model.Product;

import java.util.List;

public interface ProductDao {

    void addProduct(Product product);

    Product getProductById(Long id);

    List<Product> getAllProducts();

    void deleteProductById(Long productId);

    void editProduct(Product product);
}
