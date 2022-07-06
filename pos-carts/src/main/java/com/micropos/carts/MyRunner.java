package com.micropos.carts;

import com.micropos.carts.model.Cart;
import com.micropos.carts.model.Item;
import com.micropos.carts.repository.CartRepository;
import com.micropos.carts.repository.ItemRepository;
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
    private CartRepository cartRepository;
    @Autowired
    private ItemRepository itemRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        logger.info("initializing users");

        Cart u1 = new Cart();
        u1.setUser("Tony");
        cartRepository.save(u1);
        Item item = new Item();
        item.setProductId("001");
        item.setQuantity(10);
        u1.addItem(item);
        item = new Item();
        item.setProductId("002");
        item.setQuantity(10);
        u1.addItem(item);

        Cart u2 = new Cart();
        u2.setUser("AiLy");
        cartRepository.save(u2);
        item = new Item();
        item.setProductId("003");
        item.setQuantity(10);
        u2.addItem(item);

        Cart u3 = new Cart();
        u3.setUser("Bob");
        cartRepository.save(u3);
    }
}
