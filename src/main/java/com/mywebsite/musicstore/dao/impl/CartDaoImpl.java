package com.mywebsite.musicstore.dao.impl;

import com.mywebsite.musicstore.dao.CartDao;
import com.mywebsite.musicstore.model.Cart;
import com.mywebsite.musicstore.model.CartItem;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class CartDaoImpl implements CartDao {

    private HashMap<Integer, Cart> carts;

    public CartDaoImpl()
    {
        carts = new HashMap<>();
    }

    public Cart create(Cart cart) throws IllegalAccessException {
        if(carts.containsKey(cart.getCartId())) {
            throw new IllegalAccessException("the cart id already exist!");
        }
        carts.put(cart.getCartId(),cart);
        return cart;
    }

    public Cart getCartById(String cartId)
    {
    System.out.println("size: "+carts.size());
    System.out.println(carts);
    System.out.println("cart: "+cartId);
    System.out.println(carts.get(cartId));
    System.out.println("-------------------------------------------------------");
        return carts.get(cartId);
    }

    public void deleteCartById(String cartId) throws IllegalAccessException {
        if(!carts.containsKey(cartId)) {
            throw new IllegalAccessException("the cart by id no exist!");
        }
        carts.remove(cartId);
    }

    public void editCart(Cart cart) throws IllegalAccessException {
        if(!carts.containsKey(cart.getCartId())) {
            throw new IllegalAccessException("the cart id not exist!");
        }
        carts.put(cart.getCartId(),cart);
    }
    public void addCartItem(CartItem cartItem, Integer cartId) throws IllegalAccessException {
        if(!carts.containsKey(cartId)) {
            throw new IllegalAccessException("the cart id not exist!");
        }
        Cart cart = carts.get(cartId);
        //cart.addCartItem(cartItem);
        carts.put(cartId,cart);
    }

}
