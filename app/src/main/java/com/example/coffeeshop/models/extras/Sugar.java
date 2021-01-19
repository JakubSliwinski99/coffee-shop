package com.example.coffeeshop.models.extras;

import com.example.coffeeshop.models.Coffee;
import com.example.coffeeshop.models.Extra;

public class Sugar extends Extra {

    public Sugar(Coffee coffee) {
        super("Sugar", coffee);
    }

    public String getDescription() {
        return coffee.getDescription() + " + sugar";
    }

    public double cost() {
        return coffee.cost() + 0.5;
    }
}
