package com.techelevator.dao;

import com.techelevator.model.Pizza;
import com.techelevator.model.Topping;

import java.util.List;

public interface PizzaDao {
    List<Pizza> listPizzas();

    List<Topping> listToppings();

    List<Topping> listToppingsByPizzaId(int id);

    List<Topping> listToppingsByType(String type);

    Topping getTopping(String name);

    Pizza getPizzaById(int id);

    double getPriceBySize(String size);
}
