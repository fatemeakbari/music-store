package com.mywebsite.musicstore.dao;

import com.mywebsite.musicstore.model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    private List<Product> productList;

    public List<Product> getProductList() {

        Product product1 = new Product();
        product1.setProductId(1L);
        product1.setProductName("Moo be Moo");
        product1.setProductCategory("Instrument");
        product1.setProductDescription("Not description");
        product1.setProductPrice(1200d);
        product1.setProductCondition("new");
        product1.setProductStatus("Active");
        product1.setProductManufacturer("Fender");
        product1.setUnitInStock(11);


        Product product2 = new Product();
        product2.setProductId(2L);
        product2.setProductName("Survival");
        product2.setProductCategory("Rock");
        product2.setProductDescription("Not description");
        product2.setProductPrice(2500d);
        product2.setProductCondition("new");
        product2.setProductStatus("Active");
        product2.setProductManufacturer("EMI");
        product2.setUnitInStock(50);

        Product product3 = new Product();
        product3.setProductId(3l);
        product3.setProductName("Holy diver");
        product3.setProductCategory("Metal");
        product3.setProductDescription("Not description");
        product3.setProductPrice(2000d);
        product3.setProductCondition("new");
        product3.setProductStatus("Active");
        product3.setProductManufacturer("Dio");
        product3.setUnitInStock(30);

        productList = new ArrayList<Product>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        return productList;
    }

    public Product getProductById(Long productId) throws IOException {
        for(Product product: getProductList())
        {
            if(product.getProductId().equals(productId))
                return product;
        }
        throw new IOException("Can not found");
    }
}
