package com.order.restaurant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.order.restaurant.dao.OrderRepository;
import com.order.restaurant.entities.Order;

@Component
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getOrder(){
        List<Order> list=(List<Order>)this.orderRepository.findAll();
        return list;
    }

    public List<Order> getOrdersofTable(int tableno){
        List<Order> list=(List<Order>)this.orderRepository.findByTablenoAndStatus(tableno, "Served");
        return list;
    }

    public Order addOrder(Order o){
        Order result=this.orderRepository.save(o);
        return result;
    }

    public Order getOrderById(int id){
        return this.orderRepository.findById(id);
    }
}
