package com.example.pironeer.service;

import com.example.pironeer.domain.Order;
import com.example.pironeer.domain.Product;
import com.example.pironeer.domain.User;
import com.example.pironeer.repository.OrderRepository;
import com.example.pironeer.repository.ProductRepository;
import com.example.pironeer.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public Optional<Order> findById(Long orderId) {
        return orderRepository.findById(orderId);
    }

    public List<Order> getOrdersByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    @Transactional
    public Long createOrder(Long userId, OrderRequestItem item) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new IllegalStateException("User not found"));
        Product product = productRepository.findById(item.productId())
                .orElseThrow(()-> new IllegalStateException("Product not found"));
        if (product.getStockQuantity() < item.amount()) {
            throw new IllegalStateException("Lack of stock");
        }
        product.removeAmount(item.amount());
        Order order = new Order(user, product, "ORDERED", item.amount());
        orderRepository.save(order);
        return order.id;
    }

    @Transactional
    public void cancelOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(()-> new IllegalStateException("Order not found"));

        if (order.getStatus().equals("CANCELED")){
            throw new IllegalStateException("Already canceled");
        }
        order.setStatus("CANCELED");
        Product product = order.product;
        product.addAmount(order.amount);
    }
}
