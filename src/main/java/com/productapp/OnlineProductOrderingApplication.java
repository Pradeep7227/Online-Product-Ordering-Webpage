package com.productapp;

import com.productapp.entity.Product;
import com.productapp.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OnlineProductOrderingApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineProductOrderingApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(ProductRepository productRepository) {
        return args -> {
            if (productRepository.count() == 0) {
                productRepository.save(new Product("Laptop", 60000, 10));
                productRepository.save(new Product("Smartphone", 25000, 20));
                productRepository.save(new Product("Headphones", 3000, 50));
                productRepository.save(new Product("Keyboard", 1200, 40));
                productRepository.save(new Product("Mouse", 800, 60));
            }
        };
    }
}
