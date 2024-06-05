package com.techelevator.dao;

import com.techelevator.model.Pizza;
import com.techelevator.model.Topping;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class JdbcUserAccessDao implements UserAccessDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcUserAccessDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void updateTopping(String name, Topping topping) {
        String sql = "UPDATE toppings SET topping = ?, topping_tier = ?, topping_available = ?, topping_type = ?::topping_type_t, topping_description = ? WHERE topping = ?";

        try {
            jdbcTemplate.update(sql, topping.getName(), topping.getToppingTier(), topping.isAvailable(), topping.getType(), topping.getDescription(), name);

        }catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @Override
    public int addPizza(Pizza pizza) {
        String sql = "INSERT INTO specialty_pizzas (pizza_name, pizza_size, crust_type, sauce_type, pizza_available, pizza_description) VALUES (?, ?, ?, ?, ?, ?) RETURNING pizza_id";

        try {
            int id = jdbcTemplate.queryForObject(sql, Integer.class, pizza.getName(), pizza.getSize(), pizza.getCrust(), pizza.getSauce(), pizza.getAvailable(), pizza.getDescription());

            for(Topping topping : pizza.getToppings()){
                String sql2 = "INSERT INTO specialty_toppings (pizza_id, topping) VALUES (?, ?)";
                jdbcTemplate.update(sql2, id, topping.getName());
            }
            return id;
        }catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
