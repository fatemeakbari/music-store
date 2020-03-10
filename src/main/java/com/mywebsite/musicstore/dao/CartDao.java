package com.mywebsite.musicstore.dao;

import com.mywebsite.musicstore.model.Cart;
import com.mywebsite.musicstore.model.CartItem;


public interface CartDao {


    Cart create(Cart cart) throws IllegalAccessException;
    Cart getCartById(String cartId);
    void deleteCartById(String cartId) throws IllegalAccessException;
    void editCart(Cart cart) throws IllegalAccessException;
    void addCartItem(CartItem cartItem, Integer cartId) throws IllegalAccessException;
}
