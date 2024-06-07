package com.techelevator.dao;

import com.techelevator.model.Crust;
import com.techelevator.model.Pizza;
import com.techelevator.model.Size;
import com.techelevator.model.Topping;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional
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

    @Override
    @Transactional
    public void editPizza(int id, Pizza pizza) {
        String sql = "UPDATE specialty_pizzas SET pizza_name = ?, pizza_size = ?, crust_type = ?, sauce_type = ?, pizza_available = ?, pizza_description = ? WHERE pizza_id = ?";

        try {
            jdbcTemplate.update(sql, pizza.getName(), pizza.getSize(), pizza.getCrust(), pizza.getSauce(), pizza.getAvailable(), pizza.getDescription(), id);
            String sql2 = "DELETE FROM specialty_toppings WHERE pizza_id = ?";
            jdbcTemplate.update(sql2, id);
            for(Topping topping : pizza.getToppings()) {
                String sql3 = "INSERT INTO specialty_toppings (pizza_id, topping) VALUES (?,?)";
                jdbcTemplate.update(sql3, id, topping.getName());
            }

        }catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @Override
    public void addPizzaOption(Topping topping) {
        String sql = "INSERT INTO toppings (topping, topping_tier, topping_available, topping_type, topping_description) VALUES (?, ?, ?, ?::topping_type_t, ?)";
        try{
            jdbcTemplate.update(sql, topping.getName(), topping.getToppingTier(), topping.isAvailable(), topping.getType(), topping.getDescription());

        }catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    public void addCrust(Crust crust){
        String sql = "INSERT INTO crusts (crust_type, type_price_modifier, crust_description) VALUES (?,?,?)";
        try {
            jdbcTemplate.update(sql, crust.getTopping().getName(), crust.getPriceModifier(), crust.getTopping().getDescription());
        }catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    public void addSize(Size size) {
        String sql = "INSERT INTO pizza_sizes (pizza_size, pizza_base_price) VALUES (?,?)";
        try {
            jdbcTemplate.update(sql, size.getTopping().getName(), size.getPrice());
        }catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
