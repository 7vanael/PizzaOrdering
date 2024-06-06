package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Item;
import com.techelevator.model.Order;
import com.techelevator.model.Topping;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class JdbcOrderDao implements OrderDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcOrderDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public int placeOrder(Order order) {

        String sql = "INSERT INTO customers (customer_name, customer_email, customer_street_address, customer_city, customer_state, customer_zip) VALUES (?,?,?,?,?,?) returning customer_id";
        try {
            int customerId = jdbcTemplate.queryForObject(sql, Integer.class, order.getCustomer().getName(), order.getCustomer().getEmail(), order.getCustomer().getAddress(), order.getCustomer().getCity(), order.getCustomer().getState(), order.getCustomer().getZip());
            String sql2 = "INSERT INTO orders (order_total, customer_id, order_type) VALUES (?,?,?::order_type_t) returning order_id";
            int orderNumber = jdbcTemplate.queryForObject(sql2, Integer.class, order.getTotal(), customerId, order.getType());
            sql = "INSERT INTO order_items (order_id, item_id) VALUES (?,?) returning unique_item_id";
            for(Item item: order.getItems()){
                int itemId = jdbcTemplate.queryForObject(sql, Integer.class, orderNumber, item.getPizza().getId());
                for(Topping topping: item.getPizza().getToppings()) {
                    String sql3 = "INSERT INTO order_item_options (item_id, item_option) VALUES (?,?)";
                    jdbcTemplate.update(sql3, itemId, topping.getName());
                }
            }

            return orderNumber;

        } catch(Exception e) {
            throw new DaoException(e.getMessage(), e);
        }
    }
}
