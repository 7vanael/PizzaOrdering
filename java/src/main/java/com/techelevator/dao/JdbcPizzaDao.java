package com.techelevator.dao;

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

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Pizza pizza = new Pizza();
            pizza.setId(results.getString("pizza_id"));
            pizza.setName(results.getString("pizza_name"));
            pizza.setSize(results.getString("pizza_size"));
            pizza.setCrust(results.getString("crust_type"));
            pizzaList.add(pizza);
        }
        return pizzaList;
    }

    @Override
    public List<Topping> listToppings() {

        List<Topping> toppingList = new ArrayList<>();
        String sql = "SELECT topping, topping_tier, topping_available FROM toppings";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Topping topping = new Topping();
            topping.setName(results.getString("topping"));
            topping.setToppingTier(results.getInt("topping_tier"));
            topping.setAvailable(results.getBoolean("topping_available"));
            toppingList.add(topping);
        }
        return toppingList;
    }
}
