package com.productapp.controller;

import com.productapp.entity.Order1;
import com.productapp.entity.Product;
import com.productapp.service.OrderService;
import com.productapp.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin("*")
public class OrderController {
    private final OrderService service;
    private final ProductRepository productRepo;

    public OrderController(OrderService service, ProductRepository productRepo) {
        this.service = service;
        this.productRepo = productRepo;
    }

    // ✅ Get all orders
    @GetMapping
    public List<Order1> getAllOrders() {
        return service.getAllOrders();
    }

    // ✅ Place order with productId mapping
    @PostMapping
    public Order1 placeOrder(@RequestBody Map<String, Object> body) {
        String customerName = (String) body.get("customerName");
        int productId = (int) body.get("productId");
        int quantity = (int) body.get("quantity");

        // Fetch product from DB using productId
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // Create new order with mapped product
        Order1 order = new Order1(customerName, product, quantity);
        return service.placeOrder(order);
    }

    // ✅ Delete order
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable int id) {
        service.deleteOrder(id);
    }
}
