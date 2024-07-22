package com.order.restaurant.dao;

import org.springframework.data.repository.CrudRepository;

import com.order.restaurant.entities.OrderItem;

public interface OrderItemRepository extends CrudRepository<OrderItem,Integer>{
    
}
