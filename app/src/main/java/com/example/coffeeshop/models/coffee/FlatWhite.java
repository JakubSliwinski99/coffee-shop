package com.example.coffeeshop.models.coffee;

import com.example.coffeeshop.models.Coffee;

public class FlatWhite extends Coffee {

    public FlatWhite() {
        super("Flat White");
    }

    @Override
    public double cost() {
        return 7;
    }
}