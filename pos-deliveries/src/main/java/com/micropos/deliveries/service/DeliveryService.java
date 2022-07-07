package com.micropos.deliveries.service;

import com.micropos.deliveries.model.Delivery;

import java.util.List;

public interface DeliveryService {
    public List<Delivery> deliveries();
    public Delivery getDelivery(int id);
    public Delivery makeDelivery(int orderId);
}
