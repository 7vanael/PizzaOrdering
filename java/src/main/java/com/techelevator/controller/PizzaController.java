package com.techelevator.controller;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Pizza;
import com.techelevator.model.Topping;
import com.techelevator.service.PizzaService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.OK)
    public List<Pizza> listPizzas() {
        try {
            return pizzaService.listPizzas();
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping(path = "/toppings")
    @ResponseStatus(HttpStatus.OK)
    public List<Topping> listToppingsByType(@RequestParam(required = false) String type) {
        try {
            return pizzaService.listToppingsByType(type);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
