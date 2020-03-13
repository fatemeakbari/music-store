package com.mywebsite.musicstore.dao.impl;

import com.mywebsite.musicstore.dao.CustomerDao;
import com.mywebsite.musicstore.model.Authorities;
import com.mywebsite.musicstore.model.Cart;
import com.mywebsite.musicstore.model.Customer;
import com.mywebsite.musicstore.model.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    SessionFactory sessionFactory;


    public void addCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        customer.getBillingAddress().setCustomer(customer);
        customer.getShippingAddress().setCustomer(customer);
         session.saveOrUpdate(customer);
        session.saveOrUpdate(customer.getBillingAddress());
        session.saveOrUpdate(customer.getShippingAddress());



        Users user = new Users();
        user.setUsername(customer.getUsername());
        user.setPassword(customer.getPassword());
        user.setEnabled(true);
        user.setCustomerId(customer.getCustomerId());
        session.saveOrUpdate(user);

        Authorities authority = new Authorities();
        authority.setUsername(customer.getUsername());
        authority.setAuthority("ROLE_USER");
        session.saveOrUpdate(authority);

        Cart cart = new Cart();
        cart.setCustomer(customer);
        customer.setCart(cart);
        session.saveOrUpdate(customer);
        session.saveOrUpdate(cart);




        session.flush();
    }

    public Customer getCustomerById(int customerId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class,customerId);
    }
    public Customer getCustomerByUsername(String username){
        Session session = sessionFactory.getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery();
        Root<Customer> root = query.from(Customer.class);
        query.select(root).where(builder.equal(root.get("username"), username));
        return (Customer) session.createQuery(query).getSingleResult();
    }

    public void editCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
        session.flush();
    }
    public void deleteCustomer(Customer customer){
        Session session = sessionFactory.getCurrentSession();
        session.delete(customer);
        session.flush();
    }

    public List<Customer> getAllCustomer() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select from Customer").list();
    }
}
