package com.mywebsite.musicstore.service.impl;

import com.mywebsite.musicstore.dao.CartItemDao;
import com.mywebsite.musicstore.model.Cart;
import com.mywebsite.musicstore.model.CartItem;
import com.mywebsite.musicstore.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceUmpl implements CartItemService {

    @Autowired
    CartItemDao cartItemDao;

    public void addCartItem(CartItem cartItem){
        cartItemDao.addCartItem(cartItem);
    }

    public void removeCartItem(CartItem cartItem){
        cartItemDao.removeCartItem(cartItem);
    }

    public void removeAllCartItem(Cart cart){
        cartItemDao.removeAllCartItem(cart);
    }
    public CartItem getCartItemByProductId(int productId){ return cartItemDao.getCartItemByProductId(productId);}
}
