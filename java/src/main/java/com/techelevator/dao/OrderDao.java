package com.techelevator.dao;

import com.techelevator.model.Order;

import java.util.List;

public interface OrderDao {
    public int placeOrder(Order order);

    public Order getOrderById(int id);

    public List<Order> getListOfOrders();
}
