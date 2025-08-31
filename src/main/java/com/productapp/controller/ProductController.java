package com.productapp.controller;

import com.productapp.entity.Product;
import com.productapp.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin("*")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) { this.service = service; }

    @GetMapping
    public List<Product> getAllProducts() { return service.getAllProducts(); }

    @PostMapping
    public Product addProduct(@RequestBody Product product) { return service.addProduct(product); }
}
