package com.productapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.productapp.entity.Order1;

public interface OrderRepository extends JpaRepository<Order1, Integer> { }
