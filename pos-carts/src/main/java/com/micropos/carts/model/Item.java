package com.micropos.carts.model;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "Items")
@Entity
public class Item implements Serializable {
    @Id
    @GeneratedValue()
    @Column(name = "id")
    private int id;

    @Column(name = "productId")
    private String productId;


    @Column(name = "quantity")
    private int quantity;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH})
    private Cart cart;

    public Item(){
        this.id = 0;
        this.productId = "productId";
        this.quantity = 0;
    }

    public int getId(){return id;}
    public void setId(int id){this.id = id;}
    public String getProductId(){return productId;}
    public void setProductId(String productId){this.productId = productId;}
    public int getQuantity(){return this.quantity;}
    public void setQuantity(int quantity) {this.quantity = quantity;}
    public Cart getCart(){return this.cart;}
    public void setCart(Cart cart){this.cart = cart;}
}
