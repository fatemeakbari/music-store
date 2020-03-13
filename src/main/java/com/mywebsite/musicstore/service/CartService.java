package com.mywebsite.musicstore.service;

import com.mywebsite.musicstore.model.Cart;

public interface CartService {

    Cart getCartById(int cartId);
    void editCart(Cart cart) ;
}
