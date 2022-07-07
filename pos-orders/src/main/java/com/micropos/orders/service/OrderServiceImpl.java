package com.micropos.orders.service;

import com.micropos.orders.model.Order;
import com.micropos.orders.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private RestTemplate restTemplate;


    @Override
    public List<Order> orders() {
        Iterable<Order> it = orderRepository.findAll();

        List<Order> orders = new ArrayList<>();
        it.forEach(e ->{
            String urlString = "http://pos-carts/api/carts/{cartId}";

            HashMap<String, Object> result = new HashMap<String, Object>();
            Map<String, Object> param = new HashMap<>();
            param.put("cartId", e.getCartId());
            // 开始调用远程接口
            result = this.restTemplate
                    .exchange(urlString, HttpMethod.GET, null, new ParameterizedTypeReference<HashMap<String, Object>>() {
                    }, param).getBody();
            e.setCart(result);
            orders.add(e);
        });

        return orders;
    }

    public Order getOrder(int id){
        if(orderRepository.findById(id).isPresent()){
            Order target = orderRepository.findById(id).get();
            HashMap<String, Object> result;

            String urlString = "http://pos-carts/api/carts/{cartId}";

            Map<String, Object> param = new HashMap<>();
            param.put("cartId", target.getCartId());
            // 开始调用远程接口
            result = this.restTemplate
                    .exchange(urlString, HttpMethod.GET, null, new ParameterizedTypeReference<HashMap<String, Object>>() {
                    }, param).getBody();
            target.setCart(result);
            return target;
        }else{
            return null;
        }
    }

}
