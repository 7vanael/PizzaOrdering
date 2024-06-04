package com.techelevator.controller;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Pizza;
import com.techelevator.model.Topping;
import com.techelevator.service.PizzaService;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.CrossOrigin;
=======
import org.springframework.http.HttpStatus;
>>>>>>> 5864968eb9cc7d7ee7083e338d8ef1a233b0ba70
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
        try {
            return pizzaService.listPizzas();
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping(path = "/toppings")
    public List<Topping> listToppingsByType(@RequestParam(required = false) String type) {
        try {
            return pizzaService.listToppingsByType(type);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
