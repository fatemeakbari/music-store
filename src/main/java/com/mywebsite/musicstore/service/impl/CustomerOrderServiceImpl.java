package com.mywebsite.musicstore.service.impl;

import com.mywebsite.musicstore.dao.CustomerOrderDao;
import com.mywebsite.musicstore.model.Cart;
import com.mywebsite.musicstore.model.CartItem;
import com.mywebsite.musicstore.model.CustomerOrder;
import com.mywebsite.musicstore.service.CartService;
import com.mywebsite.musicstore.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    CustomerOrderDao customerOrderDao;

    @Autowired
    CartService cartService;


    public void addCustomerOrder(CustomerOrder customerOrder)
    {
        customerOrderDao.addCustomerOrder(customerOrder);
    }
    public double getCustomerOrderGrandTotal(int cartId)
    {
        Cart cart = cartService.getCartById(cartId);
        List<CartItem> cartItems = cart.getCartItems();

        double grandTotal = 0;
        for(CartItem cartItem: cartItems){
            grandTotal += cartItem.getTotalPrice();
        }

        return grandTotal;
    }
}
