package com.example.coffeeshop.models.extras;

import com.example.coffeeshop.models.Coffee;
import com.example.coffeeshop.models.Extra;

public class SoyMilk extends Extra {

    public SoyMilk(Coffee coffee) {
        super("Soy Milk", coffee);
    }

    public String getDescription() {
        return coffee.getDescription() + " + soy milk";
    }

    public double cost() {
        return coffee.cost() + 1.5;
    }
}
