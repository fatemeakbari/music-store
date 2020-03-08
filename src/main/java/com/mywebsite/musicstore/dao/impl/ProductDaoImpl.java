package com.mywebsite.musicstore.dao.impl;

import com.mywebsite.musicstore.dao.ProductDao;
import com.mywebsite.musicstore.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addProduct(Product product)
    {
        Session session = sessionFactory.getCurrentSession();
        session.save(product);
        session.flush();
    }

    public Product getProductById(Long id)
    {
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.get(Product.class,id);
        return product;
    }

    public List<Product> getAllProducts()
    {
        Session session = sessionFactory.getCurrentSession();
        List<Product> productList = session.createQuery("from Product").list();
        session.flush();
        return productList;
    }

    public void deleteProductById(Long productId)
    {
        Product product = new Product();
        product.setProductId(productId);
        Session session = sessionFactory.getCurrentSession();
        session.delete(product);
        session.flush();
    }

    public void editProduct(Product product)
    {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

}
