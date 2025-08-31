package com.productapp.controller;

import com.productapp.entity.Order1;
import com.productapp.service.OrderService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin("*")
public class OrderController {
    private final OrderService service;

    public OrderController(OrderService service) { 
        this.service = service; 
    }

    // Get all orders from DB
    @GetMapping
    public List<Order1> getAllOrders() {
        return service.getAllOrders();
    }

    // Place new order and return saved order with product info
    @PostMapping
    public Order1 placeOrder(@RequestBody Order1 order) {
        return service.placeOrder(order); // returns saved order (with DB ID)
    }
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable int id) {
        service.deleteOrder(id);
    }
}
