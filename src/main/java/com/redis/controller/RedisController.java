package com.redis.controller;

import com.redis.dao.OrderDao;
import com.redis.entity.Order;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RedisController {
    private final OrderDao orderDao;

    public RedisController(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @PostMapping("/save")
    public Order save(@RequestBody Order order) {
        return orderDao.save(order);
    }
    @GetMapping("/all")
    public List<Object> getAllOrder() {
        return orderDao.findAll();
    }
    @GetMapping("/{id}")
    public Order findById(@PathVariable("id") int id) {
        return orderDao.findProductById(id);
    }
    @DeleteMapping("{id}")
    public String remove(@PathVariable int id) {
        orderDao.deletedById(id);
        return "order is remove from db";
    }
}
