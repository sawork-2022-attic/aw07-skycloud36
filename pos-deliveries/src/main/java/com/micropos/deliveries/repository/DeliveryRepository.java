package com.micropos.deliveries.repository;

import com.micropos.deliveries.model.Delivery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DeliveryRepository extends CrudRepository<Delivery, Integer> {
}
