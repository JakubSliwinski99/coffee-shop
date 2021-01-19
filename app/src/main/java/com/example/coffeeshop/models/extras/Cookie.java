package com.example.coffeeshop.models.extras;

import com.example.coffeeshop.models.Coffee;
import com.example.coffeeshop.models.Extra;

public class Cookie extends Extra {

    public Cookie(Coffee coffee) {
        super("Cookie", coffee);
    }

    public String getDescription() {
        return coffee.getDescription() + " + cookie";
    }

    public double cost() {
        return coffee.cost() + 2;
    }
}
