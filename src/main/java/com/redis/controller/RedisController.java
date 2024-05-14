package com.redis.controller;

import com.redis.dao.OrderDao;
import com.redis.entity.Order;
import com.redis.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RedisController {
//    private final OrderDao orderDao;
private final OrderService orderService;

    public RedisController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/save")
    public Order save(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }
    @GetMapping("/all")
    public List<Order> getAllOrder() {
        return orderService.getAllList();
    }
    @GetMapping("/{id}")
    public Order findById(@PathVariable("id") int id) {
        return orderService.getOrderById(id);
    }
    @DeleteMapping("/{id}")
    public String remove(@PathVariable int id) {
        orderService.getDeletedById(id);
        return "order is remove from db";
    }
}
