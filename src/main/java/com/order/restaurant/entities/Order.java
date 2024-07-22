package com.order.restaurant.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordertab")
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;

    private int tableno;

    private String status;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<OrderItem> orderList=new ArrayList<>();

    public Order() {
    }

    public Order(int id, int tableno, String status, List<OrderItem> orderList) {
        this.id = id;
        this.tableno = tableno;
        this.status = status;
        this.orderList = orderList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTableno() {
        return tableno;
    }

    public void setTableno(int tableno) {
        this.tableno = tableno;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderItem> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderItem> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", tableno=" + tableno + ", status=" + status + ", orderList=" + orderList + "]";
    }

    
    
}
