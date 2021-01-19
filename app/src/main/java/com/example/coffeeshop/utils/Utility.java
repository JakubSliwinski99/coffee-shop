package com.example.coffeeshop.utils;

import com.example.coffeeshop.models.Coffee;
import com.example.coffeeshop.models.Extra;
import com.example.coffeeshop.models.coffee.Black;
import com.example.coffeeshop.models.coffee.Espresso;
import com.example.coffeeshop.models.coffee.FlatWhite;
import com.example.coffeeshop.models.coffee.Latte;
import com.example.coffeeshop.models.extras.Cookie;
import com.example.coffeeshop.models.extras.EmptyExtra;
import com.example.coffeeshop.models.extras.SoyMilk;
import com.example.coffeeshop.models.extras.Sugar;

import java.util.ArrayList;
import java.util.Arrays;

public class Utility {

    public static Coffee createChosenCoffee(String name) {
        if (name.equals("Latte")) {
            Coffee latte = new Latte();
            return latte;
        } else if (name.equals("Espresso")) {
            Coffee espresso = new Espresso();
            return espresso;
        } else if (name.equals("Flat White")) {
            Coffee fWhite = new FlatWhite();
            return fWhite;
        } else if (name.equals("Black")){
            Coffee black = new Black();
            return black;
        } else {
            return null;
        }
    }

    public static Extra addSugar(Coffee coffee) {
        Extra result = null;
        result = new Sugar(coffee);
        return result;
    }

    public static Extra addSoyMilk(Coffee coffee) {
        Extra result = null;
        result = new SoyMilk(coffee);
        return result;
    }

    public static Extra addCookie(Coffee coffee) {
        Extra result = null;
        result = new Cookie(coffee);
        return result;
    }

    public static ArrayList<String> getSelectedExtras(String[] extras, boolean[] bools) {
        ArrayList<String> result = new ArrayList<String>();
        for(int i = 0; i < extras.length; i++) {
            if(bools[i] == true) {
                result.add(extras[i]);
            }
        }
        return result;
    }

    public static Extra addExtras(String[] extrasList, boolean[] bools, Coffee coffee) {
        Extra result = new EmptyExtra(coffee);
        ArrayList<String> extras = getSelectedExtras(extrasList, bools);
        if (extras.contains("Sugar")) {
            result = addSugar(result);
        }
        if (extras.contains("Soy Milk")) {
            result = addSoyMilk(result);
        }
        if (extras.contains("Cookie")) {
            result = addCookie(result);
        }
        return result;
    }
}
