package com.mywebsite.musicstore.dao;

import com.mywebsite.musicstore.model.Product;

import java.util.List;

public class ProductDao {

    private List<Product> productList;

    public List<Product> getProductList() {

        Product product1 = new Product();
        product1.setProductName("Moo be Moo");
        product1.setProductCategory("Instrument");
        product1.setProductDescription("Not description");
        product1.setProductPrice(1200d);
        product1.setProductCondition("new");
        product1.setProductStatus("Active");
        product1.setProductManufacturer("Fender");
        product1.setUnitInStock(11);


        Product product2 = new Product();
        product2.setProductName("Servive");
        product2.setProductCategory("Rock");
        product2.setProductDescription("Not description");
        product2.setProductPrice(2500d);
        product2.setProductCondition("new");
        product2.setProductStatus("Active");
        product2.setProductManufacturer("EMI");
        product2.setUnitInStock(50);

        Product product3 = new Product();
        product1.setProductName("Holy dive");
        product1.setProductCategory("Metal");
        product1.setProductDescription("Not description");
        product1.setProductPrice(2000d);
        product1.setProductCondition("new");
        product1.setProductStatus("Active");
        product1.setProductManufacturer("Dao");
        product1.setUnitInStock(30);

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        return productList;
    }
}
