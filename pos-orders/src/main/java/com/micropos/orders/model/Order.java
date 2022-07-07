package com.micropos.orders.model;

//import javax.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;

@Table(name = "ORDERS")
@Entity
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "cartId")
    private int cartId;

    @Transient
    private Map cart;


    public Order() {}
    public int getId(){return id;}
    public void setId(int id){this.id = id;}
    public int getCartId(){return this.cartId;}
    public void setCartId(int cartId){this.cartId = cartId;}
    @Transient
    public Map getCart(){return this.cart;}
    public void setCart(Map cart){this.cart = cart;}
}
