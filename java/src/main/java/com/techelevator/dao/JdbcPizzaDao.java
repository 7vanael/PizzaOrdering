package com.techelevator.dao;

import com.techelevator.model.Pizza;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcPizzaDao implements PizzaDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcPizzaDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Pizza> listPizzas() {
        return null;
    }
}
