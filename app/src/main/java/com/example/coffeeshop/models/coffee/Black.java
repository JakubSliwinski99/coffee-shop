package com.example.coffeeshop.models.coffee;

import com.example.coffeeshop.models.Coffee;

public class Black extends Coffee {

    public Black() {
        super("Black coffee");
    }

    @Override
    public double cost() {
        return 6;
    }
}