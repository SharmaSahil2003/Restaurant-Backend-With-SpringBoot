package com.order.restaurant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.order.restaurant.dao.OrderItemRepository;
import com.order.restaurant.entities.OrderItem;

@Component
public class OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderItem> getOrderItems(){
        List<OrderItem> list=(List<OrderItem>)this.orderItemRepository.findAll();
        return list;
    }

    public OrderItem addOrderItem(OrderItem item){
        OrderItem result=this.orderItemRepository.save(item);
        return result;
    }
}
