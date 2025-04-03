package com.example.pironeer.service;

import com.example.pironeer.domain.Product;
import com.example.pironeer.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> findById(Long productId) {
        return productRepository.findById(productId);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Long createProduct(Product product) {
        productRepository.save(product);
        return product.id;
    }

    @Transactional
    public void decreaseStock(Long productId, int amount) {
        Product product = productRepository.findById(productId)
                .orElseThrow(()-> new IllegalArgumentException());
        product.removeAmount(amount);
    }
}
