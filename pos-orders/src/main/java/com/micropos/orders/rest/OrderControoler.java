package com.micropos.orders.rest;

import com.micropos.orders.api.OrdersApi;
import com.micropos.orders.mapper.OrderMapper;
import com.micropos.orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

;

@RestController
@RequestMapping("api")
public class OrderControoler implements OrdersApi {
    @Autowired
    private OrderMapper orders;

    @Autowired
    private OrderService orderService;


}
