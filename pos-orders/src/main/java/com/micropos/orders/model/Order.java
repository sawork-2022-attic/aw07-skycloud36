package com.micropos.orders.model;

//import javax.persistence;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "ORDERS")
@Entity
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_name")
    private String user;

    @Column(name = "cartId")
    private int cartId;


    public Order() {}
    public int getId(){return id;}
    public void setId(int id){this.id = id;}
    public String getUser(){return user;}
    public void setUser(String user){this.user = user;}
    public int getCartId(){return this.cartId;}
    public void setCartId(int cartId){this.cartId = cartId;}
}
