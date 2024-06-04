package com.techelevator.controller;

import com.techelevator.model.Pizza;
import com.techelevator.model.Topping;
import com.techelevator.service.PizzaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class PizzaController {

    PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService){
        this.pizzaService = pizzaService;
    }
    @GetMapping(path = "/pizzas")
    public List<Pizza> listPizzas() {
        return pizzaService.listPizzas();
    }

    @GetMapping(path = "/toppings")
    public List<Topping> listToppingsByType(@RequestParam(required = false) String type) {
        return pizzaService.listToppingsByType(type);
    }
}
