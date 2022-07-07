package com.micropos.deliveries;

import com.micropos.deliveries.repository.DeliveryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class MyRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
//        logger.info("initializing orders");
//
//        Delivery o1 = new Delivery();
//        o1.setOrderId(1);
//        deliveryRepository.save(o1);
//        Delivery o2 = new Delivery();
//        o2.setOrderId(2);
//        deliveryRepository.save(o2);
    }
}
