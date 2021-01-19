package com.example.coffeeshop.models.coffee;

import com.example.coffeeshop.models.Coffee;

public class Espresso extends Coffee {

    public Espresso() {
        super("Espresso");
    }

    @Override
    public double cost() {
        return 5;
    }
}
