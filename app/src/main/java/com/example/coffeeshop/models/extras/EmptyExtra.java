package com.example.coffeeshop.models.extras;

import com.example.coffeeshop.models.Coffee;
import com.example.coffeeshop.models.Extra;

public class EmptyExtra  extends Extra {

    public EmptyExtra(Coffee coffee) {
        super("Empty", coffee);
    }

    public String getDescription() {
        return coffee.getDescription();
    }

    public double cost() {
        return coffee.cost();
    }
}
