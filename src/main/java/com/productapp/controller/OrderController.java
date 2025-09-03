package com.productapp.controller;

import com.productapp.entity.Order1;
import com.productapp.entity.Product;
import com.productapp.service.OrderService;
import com.productapp.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // ✅ Place order (fixes Product mapping)
    @PostMapping
    public Order1 placeOrder(@RequestBody Order1 order) {
        // Get productId from incoming order (frontend sends only { "productId": X })
        if (order.getProduct() == null || order.getProduct().getId() == 0) {
            throw new RuntimeException("Product ID is required in request");
        }

        int productId = order.getProduct().getId();

        // Fetch product from DB
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));

        // Attach actual product object
        order.setProduct(product);

        return service.placeOrder(order);
    }

    // ✅ Delete order
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable int id) {
        service.deleteOrder(id);
    }
}
