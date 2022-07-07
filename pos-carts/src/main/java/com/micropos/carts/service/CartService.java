package com.micropos.carts.service;

import com.micropos.carts.model.Cart;

import java.util.List;

public interface CartService {
    public List<Cart> carts();
    public Cart getCart(int id);
    public double sumCost(int id);
    public Cart addCart(String username);
    public Cart addItem(int cartId, String productId);
    public Object makeOrder(int cartId);
}
