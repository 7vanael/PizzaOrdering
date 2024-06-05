package com.techelevator.dao;

import com.techelevator.model.Topping;

public interface UserAccessDao {
    public void updateTopping(String name, Topping topping);
}
