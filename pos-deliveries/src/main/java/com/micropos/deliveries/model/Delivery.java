package com.micropos.deliveries.model;

//import javax.persistence;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "ORDERS")
@Entity
public class Delivery implements Serializable {

    @Id
    @Column(name = "id")
    private int orderId;

    @Column(name = "company")
    private String company;

    @Transient
    private Object order;


    public Delivery() {}
    public Delivery(int orderId){
        this.orderId = orderId;
    }

    public int getOrderId(){return this.orderId;}
    public void setOrderId(int orderId){this.orderId = orderId;}
    public String getCompany(){return this.company;}
    public void setCompany(String company){this.company = company;}
    @Transient
    public Object getOrder(){return this.order;}
    public void setOrder(Object order){this.order = order;}
}
