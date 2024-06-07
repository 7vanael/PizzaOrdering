package com.techelevator.service;

import com.techelevator.dao.JdbcOrderDao;
import com.techelevator.dao.OrderDao;
import com.techelevator.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    OrderDao orderDao;

    public OrderService(OrderDao orderDao){
        this.orderDao = orderDao;
    }

    public int placeOrder(Order order){
        return orderDao.placeOrder(order);
    }

    public Order getOrderById(int id){
        return orderDao.getOrderById(id);
    }

    public List<Order> getListOfOrders(String status){
        if(status == null || status.equals("")) {
            return orderDao.getListOfOrdersInProcess();
        } else {
            return orderDao.getListOfOrdersByStatus(status);
        }
    }
}
