package com.techelevator.model;

public class Topping {
    String name;
    int toppingTier;
    boolean available;

    String type;

    String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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
