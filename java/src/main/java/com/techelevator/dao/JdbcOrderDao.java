package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    @Transactional
    public Order getOrderById(int id){
        String sql = "SELECT order_id, order_total, customer_id, order_status, order_type FROM orders WHERE order_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            if (results.next()) {
                return getOrder(results);
            }

        }catch(Exception e) {
            throw new DaoException(e.getMessage(), e);
        }
        return null;
    }

    public List<Order> getListOfOrdersInProcess(){
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT order_id, order_total, customer_id, order_status, order_type FROM orders WHERE order_status != 'Completed'::order_status_t AND order_status != 'Canceled'::order_status_t";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while(results.next()){
                orders.add(getOrder(results));
            }
            return orders;

        }catch(Exception e) {
            throw new DaoException(e.getMessage(), e);
        }
    }


    private Order getOrder(SqlRowSet results) {
        Order order = new Order();
        order.setId(results.getInt("order_id"));
        Customer customer = new Customer();
        Item item = new Item();
        Pizza pizza = new Pizza();
        List<Topping> toppings = new ArrayList<>();
        List<Item> items = new ArrayList<>();
        int itemId = 0;
        int uniqueItemId = 0;
        int customerId = 0;


            order.setTotal(results.getDouble("order_total"));
            order.setStatus(results.getString("order_status"));
            order.setType(results.getString("order_type"));
            customer.setId(results.getInt("customer_id"));
            customerId = results.getInt("customer_id");

            String sql2 = "SELECT unique_item_id, item_id FROM order_items WHERE order_id = ?";
            SqlRowSet results2 = jdbcTemplate.queryForRowSet(sql2, order.getId());
            while(results2.next()){
                itemId = results2.getInt("item_id");
                uniqueItemId = results2.getInt("unique_item_id");
                pizza.setId(results2.getInt("item_id"));

            }
            String sql3 = "SELECT pizza_name, pizza_size, crust_type, sauce_type FROM specialty_pizzas WHERE pizza_id = ?";
            SqlRowSet results3 = jdbcTemplate.queryForRowSet(sql3, itemId);
            if(results3.next()) {
                pizza.setName(results3.getString("pizza_name"));
                pizza.setSize("default " + results3.getString("pizza_size"));
                pizza.setCrust("default " + results3.getString("crust_type"));
                pizza.setSauce("default " + results3.getString("sauce_type"));
            }

            String sql4 = "SELECT item_option, t.topping_type FROM order_item_options INNER JOIN toppings AS t ON t.topping = item_option WHERE item_id = ?";
            SqlRowSet results4 = jdbcTemplate.queryForRowSet(sql4, uniqueItemId);
            while(results4.next()){
                Topping topping = new Topping();
                topping.setName(results4.getString("item_option"));
                topping.setType(results4.getString("topping_type"));
                toppings.add(topping);
            }
            String sql5 = "SELECT customer_name, customer_email, customer_street_address, customer_city, customer_state, customer_zip FROM customers WHERE customer_id = ?";
            SqlRowSet results5 = jdbcTemplate.queryForRowSet(sql5, customerId);
            if(results5.next()){
                customer.setName(results5.getString("customer_name"));
                customer.setEmail(results5.getString("customer_email"));
                customer.setAddress(results5.getString("customer_street_address"));
                customer.setCity(results5.getString("customer_city"));
                customer.setState(results5.getString("customer_state"));
                customer.setZip(results5.getString("customer_zip"));
            }
            pizza.setToppings(toppings);
            item.setPizza(pizza);
            items.add(item);
            order.setItems(items);
            order.setCustomer(customer);


        return order;
    }
}
