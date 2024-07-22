package com.order.restaurant.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.order.restaurant.entities.Menu;
import com.order.restaurant.entities.Order;
import com.order.restaurant.entities.OrderItem;
import com.order.restaurant.services.MenuService;
import com.order.restaurant.services.OrderService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class OrderController {
    
    @Autowired
    private MenuService menuService;

    @Autowired
    private OrderService orderService;

    @CrossOrigin(origins = "*")
    @GetMapping("/menu")
    public ResponseEntity<List<Menu>> getMenu() {
        List<Menu> list=this.menuService.getMenu();
        if(list.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/orders/{tableno}")
    public ResponseEntity<List<Order>> getOrder(@PathVariable int tableno){
        List<Order> list=this.orderService.getOrdersofTable(tableno);
        if(list.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/orders/{tableno}")
    public ResponseEntity<Order> addOrders(@RequestBody Order item,@PathVariable int tableno){
        System.out.println(item);
        List<OrderItem> list=item.getOrderList();
        if(list.size()<=0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        item.setTableno(tableno);
        item.setStatus("Ordered");
        for(OrderItem o:list){
            Menu m=this.menuService.getById(o.getMenuItem().getId());
            o.setMenuItem(m);
        }
        // System.out.println(item);
        this.orderService.addOrder(item);
        return ResponseEntity.of(Optional.of(item));
    }
    
}
