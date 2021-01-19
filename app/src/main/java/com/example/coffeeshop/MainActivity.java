package com.example.coffeeshop;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.coffeeshop.models.Coffee;
import com.example.coffeeshop.models.Extra;
import com.example.coffeeshop.models.extras.Sugar;
import com.example.coffeeshop.models.coffee.Latte;
import com.example.coffeeshop.utils.Utility;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button coffeeBtn;
    Button extrasBtn;
    Button orderBtn;
    TextView coffeeMenuView;
    TextView extrasMenuView;

    String coffeeKind;
    String[] listOfCoffeeKinds;
    String[] listOfExtras;
    ArrayList<String> extras;

    Coffee order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String menuCoffee = "- Latte (8.0)\n- Flat White (7.0)\n- Espresso (5.0)\n- Black (6.0)";
        coffeeMenuView = findViewById(R.id.menuCoffee);
        coffeeMenuView.setText(menuCoffee);

        String menuExtras = "- Sugar (0.5)\n- Soy Milk (1.5)\n- Cookie (2.0)";
        extrasMenuView = findViewById(R.id.menuExtras);
        extrasMenuView.setText(menuExtras);


        coffeeBtn = findViewById(R.id.buttonCoffee);
        listOfCoffeeKinds = getResources().getStringArray(R.array.coffee_kinds);

        coffeeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Choose Your Coffee");
                builder.setSingleChoiceItems(listOfCoffeeKinds, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        coffeeKind = listOfCoffeeKinds[which];
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        extrasBtn = findViewById(R.id.buttonExtras);
        listOfExtras = getResources().getStringArray(R.array.extras);
        boolean[] bools = new boolean[listOfExtras.length];
        extras = new ArrayList<>();

        extrasBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Choose Your Extras");
                builder.setMultiChoiceItems(listOfExtras, bools, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if(isChecked) {
                            if(! extras.contains(listOfExtras[which])) {
                                extras.add(listOfExtras[which]);
                            }
                        }
                    }
                });

                builder.setCancelable(false);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        orderBtn = findViewById(R.id.buttonOrder);

        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order = Utility.createChosenCoffee(coffeeKind); //Here I pick kind of coffee
                order = Utility.addExtras(listOfExtras, bools, order); //Here I add extras
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("order", order);
                startActivity(intent);
            }
        });
    }
}