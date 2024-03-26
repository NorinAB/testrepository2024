package ru.shop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shop.model.Order;
import ru.shop.service.OrderService;

import java.util.List;

@RestController("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getAllProducts() {
        return orderService.findAll();
    }
}
