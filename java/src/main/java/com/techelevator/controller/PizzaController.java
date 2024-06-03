package com.techelevator.controller;

import com.techelevator.model.Pizza;
import com.techelevator.service.PizzaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PizzaController {

    PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService){
        this.pizzaService = pizzaService;
    }
    @GetMapping(path = "/pizzas")
    public List<Pizza> listPizzas() {
        return pizzaService.listPizzas();
    }
}
