package com.micropos.carts.model;

//import javax.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Table(name = "CARTS")
@Entity
public class Cart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_name")
    private String user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    private List<Item> cartItems = new ArrayList<>();


    public Cart() {}

    public void addItem(Item temp){
        temp.setCart(this);
        cartItems.add(temp);
    }

    public int getId(){return id;}
    public void setId(int id){this.id = id;}
    public String getUser(){return user;}
    public void setUser(String user){this.user = user;}
    public List<Item> getCartItems(){return this.cartItems;}
    public void setCartItems(List<Item> cartItems){this.cartItems = cartItems;}
}
