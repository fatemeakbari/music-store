package com.mywebsite.musicstore.controller;

import com.mywebsite.musicstore.model.Cart;
import com.mywebsite.musicstore.model.CartItem;
import com.mywebsite.musicstore.model.Customer;
import com.mywebsite.musicstore.model.Product;
import com.mywebsite.musicstore.service.CartItemService;
import com.mywebsite.musicstore.service.CartService;
import com.mywebsite.musicstore.service.CustomerService;
import com.mywebsite.musicstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CartResources {

    @Autowired
    CartService cartService;

    @Autowired
    CustomerService customerService;

    @Autowired
    ProductService productService;

    @Autowired
    CartItemService cartItemService;

    @RequestMapping("/rest/cart/{cartId}")
    public
    @ResponseBody
    Cart getCart(@PathVariable int cartId)
    {
        return cartService.getCartById(cartId);
    }

    @RequestMapping(value = "/rest/cart/add/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable int productId, @AuthenticationPrincipal User activeUser)
    {
        Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
        List<CartItem> cartItems =  customer.getCart().getCartItems();
        Product product = productService.getProductById(productId);

        for(int i=0;i<cartItems.size();i++){
            CartItem cartItem = cartItems.get(i);
            if(cartItem.getProduct().getProductId() == product.getProductId()){
                cartItem.setQuantity(cartItem.getQuantity()+1);
                cartItem.setTotalPrice(cartItem.getTotalPrice()+product.getProductPrice());
                cartItemService.addCartItem(cartItem);
                return;
            }
        }

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(1);
        cartItem.setTotalPrice(product.getProductPrice());
        cartItem.setCart(customer.getCart());
        cartItemService.addCartItem(cartItem);

    }
    @RequestMapping(value = "/rest/cart/remove/{productId}",method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable int productId)
    {
        CartItem cartItem = cartItemService.getCartItemByProductId(productId);
        cartItemService.removeCartItem(cartItem);
    }

    @RequestMapping(value = "/{cartId}",method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeCart(@PathVariable int cartId)
    {
        Cart cart = cartService.getCartById(cartId);
        cartItemService.removeAllCartItem(cart);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "Illegal request")
    public void handleClientError(Exception e){}

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR,reason = "Internal server error")
    public void handleServerError(Exception e){}

}
