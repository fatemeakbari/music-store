package com.mywebsite.musicstore.dao;

import com.mywebsite.musicstore.model.Cart;
import com.mywebsite.musicstore.model.CartItem;

public interface CartItemDao {

    void addCartItem(CartItem cartItem);
    void removeCartItem(CartItem cartItem);
    void removeAllCartItem(Cart cart);
    CartItem getCartItemByProductId(int productId);
}
