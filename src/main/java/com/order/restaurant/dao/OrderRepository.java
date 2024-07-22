package com.order.restaurant.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.order.restaurant.entities.Order;

public interface OrderRepository extends CrudRepository<Order,Integer>{
    public Order findById(int id);
    public List<Order> findByTablenoAndStatus(int tableno,String status);
}
