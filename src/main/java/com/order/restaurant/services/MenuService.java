package com.order.restaurant.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.order.restaurant.dao.MenuRepository;
import com.order.restaurant.entities.Menu;

@Component
public class MenuService {
    
    @Autowired
    private MenuRepository menuRepository;

    public List<Menu> getMenu(){
        List<Menu> list=(List<Menu>)this.menuRepository.findAll();
        return list;
    }

    public Menu getById(int id){
        Menu m=this.menuRepository.findById(id);
        return m;
    }
}
