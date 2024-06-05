package com.techelevator.dao;

import com.techelevator.model.Order;

public interface OrderDao {
    public int placeOrder(Order order);
}
