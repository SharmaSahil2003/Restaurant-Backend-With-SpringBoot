package com.order.restaurant.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orderitem")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int quantity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "food_id")
    private Menu menuItem;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    @JsonBackReference
    private Order order;

    public OrderItem() {
    }

    public OrderItem(int id, int quantity, Menu menuItem, Order order) {
        this.id = id;
        this.quantity = quantity;
        this.menuItem = menuItem;
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Menu getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(Menu menuItem) {
        this.menuItem = menuItem;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderItem [id=" + id + ", quantity=" + quantity + ", menuItem=" + menuItem +"]";
    }
}
