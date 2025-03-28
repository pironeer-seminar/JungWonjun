package com.example.pironeer.repository;

import com.example.pironeer.domain.Product;
import com.example.pironeer.service.OrderRequestItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}