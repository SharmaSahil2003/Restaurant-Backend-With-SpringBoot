package com.order.restaurant.dao;

import org.springframework.data.repository.CrudRepository;

import com.order.restaurant.entities.Menu;

public interface MenuRepository extends CrudRepository<Menu,Integer>{
    public Menu findById(int id);
}
