package com.techelevator.model;

public class Topping {
    String name;
    int toppingTier;
    boolean available;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getToppingTier() {
        return toppingTier;
    }

    public void setToppingTier(int toppingTier) {
        this.toppingTier = toppingTier;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}