package com.micropos.orders.rest;

import com.micropos.orders.api.OrdersApi;
import com.micropos.orders.dto.OrderDto;
import com.micropos.orders.mapper.OrderMapper;
import com.micropos.orders.model.Order;
import com.micropos.orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

;

@RestController
@RequestMapping("api")
public class OrderController implements OrdersApi {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderService orderService;

    @Override
    public ResponseEntity<List<OrderDto>> listOrders(){
        List<OrderDto> orders = new ArrayList<>(orderMapper.toOrdersDto(this.orderService.orders()));
        if (orders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OrderDto> showOrderById(Integer id){
        Order order = orderService.getOrder(id);
        if(order == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orderMapper.toOrderDto(order),HttpStatus.OK);
    }


}
