package com.example.coffeeshop.models.coffee;

import com.example.coffeeshop.models.Coffee;

public class Latte extends Coffee {

    public Latte() {
        super("Latte");
    }

    @Override
    public double cost() {
        return 8;
    }
}
