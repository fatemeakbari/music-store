package com.mywebsite.musicstore.dao.impl;

import com.mywebsite.musicstore.dao.CartItemDao;
import com.mywebsite.musicstore.model.Cart;
import com.mywebsite.musicstore.model.CartItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao {

    @Autowired
    SessionFactory sessionFactory;
    public void addCartItem(CartItem cartItem)
    {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cartItem);
        session.flush();
    }
    public void removeCartItem(CartItem cartItem)
    {
        Session session = sessionFactory.getCurrentSession();
        session.delete(cartItem);
        session.flush();
    }
    public void removeAllCartItem(Cart cart)
    {
        for(CartItem cartItem: cart.getCartItems()){
            this.removeCartItem(cartItem);
        }
    }

    public CartItem getCartItemByProductId(int productId){
        Session session = sessionFactory.getCurrentSession();
        String query = "From CartItem where productId="+productId;
        return (CartItem) session.createQuery(query).getSingleResult();
    }
}
