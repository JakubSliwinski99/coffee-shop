package com.example.coffeeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.coffeeshop.models.Coffee;

public class ResultActivity extends AppCompatActivity {

    Button backBtn;
    TextView descView;
    TextView priceView;
    Coffee order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        order = (Coffee) intent.getSerializableExtra("order");

        String desc = order.getDescription();
        double price = order.cost();
        String priceStr = "" + price;

        descView = findViewById(R.id.descriptionView);
        priceView = findViewById(R.id.priceView);

        descView.setText(desc);
        priceView.setText(priceStr);

        backBtn = findViewById(R.id.buttonBack);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}