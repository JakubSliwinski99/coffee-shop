package com.example.coffeeshop.models;

import java.io.Serializable;

public abstract class Coffee implements Serializable {

    private String description;

    public Coffee(Coffee coffee) {
        this.description = coffee.description;
    }

    public Coffee(String description) {
        super();
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public abstract double cost();

    @Override
    public String toString() {
        return "Coffee{" +
                "description='" + description + '\'' +
                '}';
    }

}
