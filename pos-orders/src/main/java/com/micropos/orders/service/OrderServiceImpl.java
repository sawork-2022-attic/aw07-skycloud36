package com.micropos.orders.service;

import com.micropos.orders.model.Order;
import com.micropos.orders.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private RestTemplate restTemplate;


    @Override
    public List<Order> orders() {
        Iterable<Order> it = orderRepository.findAll();

        List<Order> orders = new ArrayList<Order>();
        it.forEach(e -> orders.add(e));

        return orders;
    }

    public Order getOrder(int id){
        return null;
    }

}
