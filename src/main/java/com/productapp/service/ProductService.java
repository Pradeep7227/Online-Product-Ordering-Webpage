package com.productapp.service;

import com.productapp.entity.Product;
import com.productapp.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repo;

    public ProductService(ProductRepository repo) { this.repo = repo; }

    public List<Product> getAllProducts() { return repo.findAll(); }
    public Product addProduct(Product p) { return repo.save(p); }
}
