package com.redis.service;

import com.redis.entity.Order;
import com.redis.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }
@Cacheable(value = "order")
    public List<Order> getAllList() {
        return orderRepository.findAll();
    }
    @Cacheable(value = "order", key = "#id")
    public Order getOrderById(int id) {
         return orderRepository.findById(id).orElseThrow(
                () -> new RuntimeException("order not found by id")
        );
    }
    // Deleted by is
    @Caching(evict = {@CacheEvict(value = "order",allEntries = true), @CacheEvict(value =
    "order",key = "#id")})
    public String getDeletedById(int id) {
        orderRepository.deleteById(id);
        return "order deleted SUCCESSFULLY";
    }
}
