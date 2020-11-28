package com.example.coffeeorder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //variables:
    int quantity = 0;
//    String name = "";
//    boolean chocolate = false;
//    boolean whippedCream = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View v) {
        quantity++;
        displayQuantity(quantity);
    }

    public void decrement(View v) {
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    public void displayQuantity(int number) {
        TextView displayInteger = findViewById(R.id.quantityNumber);
        displayInteger.setText(number);
    }

}