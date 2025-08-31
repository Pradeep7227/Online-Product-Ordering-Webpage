package com.productapp.service;

import com.productapp.entity.Order1;
import com.productapp.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository repo;

    public OrderService(OrderRepository repo) {
        this.repo = repo;
    }

    public List<Order1> getAllOrders() {
        return repo.findAll();
    }

    public Order1 placeOrder(Order1 order) {
        return repo.save(order);
    }

    // ✅ New method for deleting an order by ID
    public void deleteOrder(int id) {
        repo.deleteById(id);
    }
}
