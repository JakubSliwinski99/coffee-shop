package com.example.coffeeshop.models;

public abstract class Extra extends Coffee{

    public Coffee coffee;

    public Extra(String description, Coffee coffee) {
        super(description);
        this.coffee = coffee;
    }

    public abstract String getDescription();

}
