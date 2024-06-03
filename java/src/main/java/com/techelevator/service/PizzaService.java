package com.techelevator.service;

import com.techelevator.dao.PizzaDao;
import com.techelevator.model.Pizza;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {

    PizzaDao pizzaDao;

    public PizzaService(PizzaDao pizzaDao){
        this.pizzaDao = pizzaDao;
    }

    public List<Pizza> listPizzas(){
        List <Pizza> pizzaList = pizzaDao.listPizzas();
        return pizzaList;
    }
}
