package com.micropos.orders;

import com.micropos.orders.model.Order;
import com.micropos.orders.repository.OrderRepository;
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
    private OrderRepository orderRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        logger.info("initializing orders");

        Order o1 = new Order();
        o1.setCartId(1);
        orderRepository.save(o1);
        Order o2 = new Order();
        o2.setCartId(2);
        orderRepository.save(o2);
    }
}
