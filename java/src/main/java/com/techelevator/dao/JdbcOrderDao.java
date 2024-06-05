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
        String sql = "INSERT INTO orders (order_total, order_type, delivery_address) VALUES (?,?::order_type_t,?) returning order_id";

        try {
            int orderNumber = jdbcTemplate.queryForObject(sql, Integer.class, order.getTotal(), order.getType(), order.getAddress());

            sql = "INSERT INTO order_items (order_id, item_id) VALUES (?,?) returning unique_item_id";
            for(Item item: order.getItems()){
                int itemId = jdbcTemplate.queryForObject(sql, Integer.class, orderNumber, item.getPizza().getId());
                for(Topping topping: item.getPizza().getToppings()) {
                    String sql2 = "INSERT INTO order_item_options (item_id, item_option) VALUES (?,?)";
                    jdbcTemplate.update(sql2, itemId, topping.getName());
                }
            }

            return orderNumber;

        } catch(Exception e) {
            throw new DaoException(e.getMessage(), e);
        }
    }
}
