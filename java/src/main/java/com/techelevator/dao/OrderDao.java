package com.techelevator.dao;

import com.techelevator.model.Order;

public interface OrderDao {
    public int placeOrder(Order order);

    public Order getOrderById(int id);
}
