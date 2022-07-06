package com.micropos.products;

import com.micropos.products.model.Product;
import com.micropos.products.repository.ProductRepository;
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
    private ProductRepository productRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        logger.info("initializing users");
        Product p1 = new Product("001", "Product1", 50, null);
        Product p2 = new Product("002", "Product2", 52, null);
        Product p3 = new Product("003", "Product3", 55.5, null);
        Product p4 = new Product("004", "Product4", 100.9, null);
        productRepository.addProduct(p1);
        productRepository.addProduct(p2);
        productRepository.addProduct(p3);
        productRepository.addProduct(p4);
    }
}
