package com.techelevator.controller;

import com.techelevator.model.Order;
import com.techelevator.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
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

    @GetMapping(path = "/order")
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getListOfOrders(@RequestParam(required = false) String status){
        return orderService.getListOfOrders(status);
    }

    @PutMapping(path = "/order/{id}/status")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Order changeOrderStatus(@PathVariable int id, @RequestBody String status){
        return orderService.changeOrderStatus(id, status);
    }

}
