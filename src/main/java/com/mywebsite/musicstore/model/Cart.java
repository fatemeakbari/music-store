package com.mywebsite.musicstore.model;

import java.util.HashMap;

public class Cart {

    private String cartId;
    private HashMap<Long,CartItem> cartItems;
    private double grandTotal;

    public Cart() {

        cartItems = new HashMap<>();
        grandTotal = 0;
    }

    public Cart(String cartId) {
        this();
        this.cartId = cartId;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public HashMap<Long, CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(HashMap<Long, CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public void addCartItem(CartItem cartItem)
    {
        Long productId = cartItem.getProduct().getProductId();
        if(cartItems.containsKey(productId))
        {
            CartItem existCartItem = cartItems.get(productId);
            existCartItem.setQuantity(existCartItem.getQuantity()+cartItem.getQuantity());
            cartItems.put(productId,existCartItem);
        }
        else
        {
            cartItems.put(productId, cartItem);
        }

        updateGrandTotal();
    }

    public void removeCartItem(CartItem cartItem)
    {
        Long productId = cartItem.getProduct().getProductId();
        if(cartItems.containsKey(productId))
        {
            cartItems.remove(productId);
        }
        updateGrandTotal();
    }

    public void updateGrandTotal()
    {
        grandTotal = 0;

        for(CartItem item: cartItems.values())
            grandTotal += item.getTotalPrice();
    }
}
