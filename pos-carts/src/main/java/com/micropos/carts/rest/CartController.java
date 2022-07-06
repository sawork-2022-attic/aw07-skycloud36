package com.micropos.carts.rest;

import com.micropos.carts.api.CartsApi;
import com.micropos.carts.dto.CartDto;
import com.micropos.carts.mapper.CartMapper;
import com.micropos.carts.model.Cart;
import com.micropos.carts.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class CartController implements CartsApi {
    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private CartService cartService;


    @Override
    public ResponseEntity<List<CartDto>> listCarts(){
        List<CartDto> products = new ArrayList<>(cartMapper.toCartsDto(this.cartService.carts()));
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CartDto> showCartById(Integer cartId){
        CartDto cart = cartMapper.toCartDto(this.cartService.getCart(cartId));
        if (cart == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Double> sumCost(Integer id){
        return new ResponseEntity<>(cartService.sumCost(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CartDto> addCart(String username){
        Cart cart = cartService.addCart(username);
        return new ResponseEntity<>(cartMapper.toCartDto(cart),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CartDto> addItem(Integer cartId, String productId){
        Cart cart = cartService.addItem(cartId, productId);
        if(cart == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cartMapper.toCartDto(cart),HttpStatus.OK);
    }
}
