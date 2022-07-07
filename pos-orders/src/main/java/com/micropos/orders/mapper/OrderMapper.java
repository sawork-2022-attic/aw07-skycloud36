package com.micropos.orders.mapper;

import com.micropos.orders.dto.OrderDto;
import com.micropos.orders.model.Order;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper
public interface OrderMapper {
    Collection<OrderDto> toOrdersDto(Collection<Order> orders);

    Collection<Order> toOrders(Collection<OrderDto> cartDtos);

    OrderDto toOrderDto(Order order);

    Order toOrder(OrderDto orderDto);

}
