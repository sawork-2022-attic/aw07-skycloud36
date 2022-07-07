package com.micropos.deliveries.service;

import com.micropos.deliveries.model.Delivery;
import com.micropos.deliveries.repository.DeliveryRepository;
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
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public List<Delivery> deliveries() {
        Iterable<Delivery> it = deliveryRepository.findAll();

        List<Delivery> deliveries = new ArrayList<>();
        it.forEach(e ->{
            e.setOrder(getOrder(e.getOrderId()));
            deliveries.add(e);
        });

        return deliveries;
    }

    @Override
    public Delivery getDelivery(int id) {
        if(deliveryRepository.findById(id).isPresent()){
            Delivery delivery = deliveryRepository.findById(id).get();
            delivery.setOrder(getOrder(id));
            return  delivery;
        }
        return null;
    }

    @Override
    public Delivery makeDelivery(int orderId) {
        Delivery delivery = new Delivery(orderId);
        delivery.setCompany("Company A");
        deliveryRepository.save(delivery);
        delivery.setOrder(getOrder(orderId));
        return delivery;
    }

    private Map<String, Object> getOrder(int orderId){
        HashMap<String, Object> result;

        String urlString = "http://pos-orders/api/orders/{orderId}";

        Map<String, Object> param = new HashMap<>();
        param.put("orderId", orderId);
        // 开始调用远程接口
        result = this.restTemplate
                .exchange(urlString, HttpMethod.GET, null, new ParameterizedTypeReference<HashMap<String, Object>>() {
                }, param).getBody();
        return result;
    }

}
