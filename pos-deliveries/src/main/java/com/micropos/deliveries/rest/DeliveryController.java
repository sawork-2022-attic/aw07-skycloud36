package com.micropos.deliveries.rest;

import com.micropos.deliveries.api.DeliveriesApi;
import com.micropos.deliveries.dto.DeliveryDto;
import com.micropos.deliveries.mapper.DeliveryMapper;
import com.micropos.deliveries.model.Delivery;
import com.micropos.deliveries.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class DeliveryController implements DeliveriesApi {
    @Autowired
    private DeliveryMapper deliveryMapper;

    @Autowired
    private DeliveryService deliveryService;

    @Override
    public ResponseEntity<List<DeliveryDto>> listDeliveries(){
        List<DeliveryDto> orders = new ArrayList<>(deliveryMapper.toDeliveriesDto(this.deliveryService.deliveries()));
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DeliveryDto> showDeliveryByOrderId(Integer orderId){
        Delivery delivery = deliveryService.getDelivery(orderId);
        return new ResponseEntity<>(deliveryMapper.toDeliveryDto(delivery),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DeliveryDto> confirmOrder(Integer orderId){
        Delivery delivery = deliveryService.makeDelivery(orderId);
        if(delivery == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(deliveryMapper.toDeliveryDto(delivery),HttpStatus.OK);
    }
}
