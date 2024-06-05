package com.techelevator.dao;

import com.techelevator.model.Pizza;
import com.techelevator.model.Topping;

public interface UserAccessDao {
    public void updateTopping(String name, Topping topping);

    public int addPizza(Pizza pizza);
}
