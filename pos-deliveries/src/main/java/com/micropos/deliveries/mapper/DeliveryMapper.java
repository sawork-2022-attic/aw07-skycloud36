package com.micropos.deliveries.mapper;

import com.micropos.deliveries.dto.DeliveryDto;
import com.micropos.deliveries.model.Delivery;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper
public interface DeliveryMapper {
    Collection<DeliveryDto> toDeliveriesDto(Collection<Delivery> orders);

    Collection<Delivery> toDeliveries(Collection<DeliveryDto> cartDtos);

    DeliveryDto toDeliveryDto(Delivery order);

    Delivery toDelivery(DeliveryDto orderDto);

}
