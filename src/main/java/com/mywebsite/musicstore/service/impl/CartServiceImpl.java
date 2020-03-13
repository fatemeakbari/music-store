package com.mywebsite.musicstore.service.impl;


import com.mywebsite.musicstore.dao.CartDao;
import com.mywebsite.musicstore.model.Cart;
import com.mywebsite.musicstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartDao cartDao;

    public Cart getCartById(int cartId){
        return cartDao.getCartById(cartId);
    }
    public void editCart(Cart cart) {
        cartDao.editCart(cart);
    }
}
