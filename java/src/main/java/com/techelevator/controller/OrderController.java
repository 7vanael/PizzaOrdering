package com.techelevator.controller;

import com.techelevator.model.Order;
import com.techelevator.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(path = "/order")
    @ResponseStatus(HttpStatus.CREATED)
    public int placeOrder(@RequestBody Order order){
        return orderService.placeOrder(order);
    }

    @GetMapping(path = "/order/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Order getOrderById(@PathVariable int id){
        return orderService.getOrderById(id);
    }
}
