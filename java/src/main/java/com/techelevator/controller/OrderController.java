package com.techelevator.controller;

import com.techelevator.model.Order;
import com.techelevator.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(path = "/order")
    public int placeOrder(@RequestBody Order order){
        return orderService.placeOrder(order);
    }
}
