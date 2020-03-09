package com.mywebsite.musicstore.controller;

import com.mywebsite.musicstore.dao.CartDao;
import com.mywebsite.musicstore.dao.ProductDao;
import com.mywebsite.musicstore.model.CartItem;
import com.mywebsite.musicstore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import com.mywebsite.musicstore.model.Cart;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/rest/cart")
public class CartController {

    @Autowired
    private CartDao cartDao;

    @Autowired
    private ProductDao productDao;


    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    public @ResponseBody
    Cart getCart(@PathVariable String cartId)
    {
        Cart cart = cartDao.getCartById(cartId);

    System.out.println("======================");
        return cart;
            }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable String cartId, @RequestBody Cart cart) throws IllegalAccessException {
        cart.setCartId(cartId);
        cartDao.editCart(cart);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String cartId) throws IllegalAccessException {

        cartDao.deleteCartById(cartId);
    }

    @RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable Long productId, HttpServletRequest request) throws IllegalAccessException {

        String cartId =  request.getSession(true).getId();
        Cart cart = cartDao.getCartById(cartId);
        Product product = productDao.getProductById(productId);
        if(cart == null)
        {
            cart = cartDao.create(new Cart(cartId));
        }
        if(product == null)
        {
            throw  new IllegalArgumentException("The product with this id not exist!");
        }
        cart.addCartItem(new CartItem(product));
        cartDao.editCart(cart);
    }

    @RequestMapping(value = "/remove/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable Long productId, HttpServletRequest request) throws IllegalAccessException {

        String cartId =  request.getSession(true).getId();
        Cart cart = cartDao.getCartById(cartId);
        Product product = productDao.getProductById(productId);
        if(cart == null)
        {
            cart = cartDao.create(new Cart(cartId));
        }
        if(product == null)
        {
            throw  new IllegalArgumentException("The product with this id not exist!");
        }
        cart.removeCartItem(new CartItem(product));
        cartDao.editCart(cart);
    }



}
