package com.techelevator.service;

import com.techelevator.dao.PizzaDao;
import com.techelevator.dao.UserAccessDao;
import com.techelevator.model.Pizza;
import com.techelevator.model.Topping;
import org.springframework.stereotype.Service;

@Service
public class UserAccessService {
    UserAccessDao userAccessDao;
    PizzaDao pizzaDao;

    public UserAccessService(UserAccessDao userAccessDao, PizzaDao pizzaDao) {
        this.userAccessDao = userAccessDao;
        this.pizzaDao = pizzaDao;
    }

    public Topping updateTopping (String name, Topping topping){
        userAccessDao.updateTopping(name, topping);
        return pizzaDao.getTopping(topping.getName());
    }
}
