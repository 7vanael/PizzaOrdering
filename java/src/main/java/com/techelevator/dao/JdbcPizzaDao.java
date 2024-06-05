package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Pizza;
import com.techelevator.model.Topping;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPizzaDao implements PizzaDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcPizzaDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Pizza> listPizzas() {

        List<Pizza> pizzaList = new ArrayList<>();
        String sql = "SELECT pizza_id, pizza_name, pizza_size, crust_type FROM specialty_pizzas";
    try {
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Pizza pizza = new Pizza();
            pizza.setId(results.getInt("pizza_id"));
            pizza.setName(results.getString("pizza_name"));
            pizza.setSize(results.getString("pizza_size"));
            pizza.setCrust(results.getString("crust_type"));
            pizza.setToppings(listToppingsByPizzaId(pizza.getId()));
            pizzaList.add(pizza);
        }
        return pizzaList;
    }catch(Exception e) {
        throw new DaoException(e.getMessage(), e);
    }
    }

    @Override
    public List<Topping> listToppingsByPizzaId(int id) {
        List<Topping> toppingList = new ArrayList<>();
        String sql = "SELECT t.topping, t.topping_tier, t.topping_available, t.topping_type, t.topping_description FROM toppings AS t JOIN specialty_toppings AS st ON t.topping = st.topping WHERE st.pizza_id = ?";
    try {
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        while (results.next()) {
            Topping topping = new Topping();
            topping.setName(results.getString("topping"));
            topping.setToppingTier(results.getInt("topping_tier"));
            topping.setAvailable(results.getBoolean("topping_available"));
            topping.setType(results.getString("topping_type"));
            topping.setDescription(results.getString("topping_description"));
            toppingList.add(topping);
        }
        return toppingList;
    }catch(Exception e) {
        throw new DaoException(e.getMessage(), e);
    }
    }

    @Override
    public List<Topping> listToppings() {

        List<Topping> toppingList = new ArrayList<>();
        String sql = "SELECT topping, topping_tier, topping_available, topping_type, topping_description FROM toppings";
    try {
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Topping topping = new Topping();
            topping.setName(results.getString("topping"));
            topping.setToppingTier(results.getInt("topping_tier"));
            topping.setAvailable(results.getBoolean("topping_available"));
            topping.setType(results.getString("topping_type"));
            topping.setDescription(results.getString("topping_description"));
            toppingList.add(topping);
        }
        return toppingList;
    }catch(Exception e){
        throw new DaoException(e.getMessage(), e);
    }
    }

    @Override
    public List<Topping> listToppingsByType(String type) {
        List<Topping> toppingList = new ArrayList<>();
        String sql = "SELECT topping, topping_tier, topping_available, topping_type, topping_description FROM toppings WHERE topping_type::text = ?";
    try {
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, type);
        while (results.next()) {
            Topping topping = new Topping();
            topping.setName(results.getString("topping"));
            topping.setToppingTier(results.getInt("topping_tier"));
            topping.setAvailable(results.getBoolean("topping_available"));
            topping.setType(results.getString("topping_type"));
            topping.setDescription(results.getString("topping_description"));
            toppingList.add(topping);
        }
        return toppingList;
    }catch(Exception e) {
        throw new DaoException(e.getMessage(), e);
    }
    }

    @Override
    public Topping getTopping(String name) {
        String sql = "SELECT topping, topping_tier, topping_available, topping_type, topping_description FROM toppings WHERE topping = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);
            if (results.next()) {
                Topping topping = new Topping();
                topping.setName(results.getString("topping"));
                topping.setToppingTier(results.getInt("topping_tier"));
                topping.setAvailable(results.getBoolean("topping_available"));
                topping.setType(results.getString("topping_type"));
                topping.setDescription(results.getString("topping_description"));
                return topping;
            }
        }catch(Exception e) {
            throw new DaoException(e.getMessage(), e);
        }
        return null;
    }
}
