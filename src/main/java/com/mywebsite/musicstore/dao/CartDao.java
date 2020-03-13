package com.mywebsite.musicstore.dao;

import com.mywebsite.musicstore.model.Cart;


public interface CartDao {

    Cart getCartById(int cartId);
    void editCart(Cart cart) ;

}
