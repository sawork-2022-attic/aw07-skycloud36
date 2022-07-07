package com.micropos.orders.service;

import com.micropos.orders.model.Order;

import java.util.List;

public interface OrderService {
    public List<Order> orders();
    public Order getOrder(int id);
    public Order makeOrder(int cartId);
}
