package com.mywebsite.musicstore.service;

import com.mywebsite.musicstore.model.Cart;
import com.mywebsite.musicstore.model.CartItem;

public interface CartItemService {
    void addCartItem(CartItem cartItem);
    void removeCartItem(CartItem cartItem);
    void removeAllCartItem(Cart cart);
    CartItem getCartItemByProductId(int productId);
}
