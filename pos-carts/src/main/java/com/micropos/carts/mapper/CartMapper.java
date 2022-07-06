package com.micropos.carts.mapper;


import com.micropos.carts.dto.CartDto;
import com.micropos.carts.dto.ItemDto;
import com.micropos.carts.model.Cart;
import com.micropos.carts.model.Item;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Mapper
public interface CartMapper {
    Collection<CartDto> toCartsDto(Collection<Cart> carts);

    Collection<Cart> toCarts(Collection<CartDto> cartDtos);

    Cart toCart(CartDto productDto);

    default CartDto toCartDto(Cart cart){
        return new CartDto().id(cart.getId())
                .cartItems((List<ItemDto>) toItemsDto(cart.getCartItems()))
                .user(cart.getUser());
    }

    default ItemDto toItemDto(Item item){
        return new ItemDto()
                .id(item.getId())
                .productId(item.getProductId())
                .quantity(item.getQuantity());
    }

    default Collection<ItemDto> toItemsDto(Collection<Item> items){
        List<ItemDto> itemDtos = new ArrayList<>();
        for (Item item: items
             ) {
            itemDtos.add(toItemDto(item));
        }
        return itemDtos;
    }

}
