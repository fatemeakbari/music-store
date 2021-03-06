package com.mywebsite.musicstore.dao.impl;

import com.mywebsite.musicstore.dao.CartDao;
import com.mywebsite.musicstore.model.Cart;
import com.mywebsite.musicstore.model.CartItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Repository
@Transactional
public class CartDaoImpl implements CartDao {

    @Autowired
    SessionFactory sessionFactory;
    public Cart getCartById(int cartId)
    {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Cart.class, cartId);
    }
    public void editCart(Cart cart) {
        int cartId = cart.getCartId();
    }
}
