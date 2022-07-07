package com.micropos.carts.service;

import com.micropos.carts.model.Cart;
import com.micropos.carts.model.Item;
import com.micropos.carts.repository.CartRepository;
import com.micropos.carts.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Cart> carts() {
        Iterable<Cart> it = cartRepository.findAll();

        List<Cart> carts = new ArrayList<Cart>();
        it.forEach(e -> carts.add(e));

        return carts;
    }

    @Override
    public Cart getCart(int id) {
        return cartRepository.findById(id).get();
    }

    @Override
    public double sumCost(int id){
        double sum = 0;
        HashMap<String, Object> result = new HashMap<String, Object>();

        String urlString = "http://pos-products/api/products/{productId}";

        Map<String, Object> param = new HashMap<>();
        for(Item item: cartRepository.findById(id).get().getCartItems()){
            param.put("productId", item.getProductId());
            // 开始调用远程接口
            result = this.restTemplate
                    .exchange(urlString, HttpMethod.GET, null, new ParameterizedTypeReference<HashMap<String, Object>>() {
                    }, param).getBody();
            sum += (double)result.get("price")*item.getQuantity();
        }
        return sum;
    }

    @Override
    public Cart addCart(String username){
        Cart cart = new Cart();
        cart.setUser(username);
        return cart;
    }

    @Override
    public Cart addItem(int cartId, String productId){
        if(cartRepository.findById(cartId).isPresent()){
            Cart cart = cartRepository.findById(cartId).get();
            for(Item item:cart.getCartItems()){
                if(item.getProductId().equals(productId)){
                    item.setQuantity(item.getQuantity()+1);
                    return cart;
                }
            }
            Item item = new Item();
            item.setProductId(productId);
            cart.addItem(item);
            return cart;
        }
        return null;
    }
}
