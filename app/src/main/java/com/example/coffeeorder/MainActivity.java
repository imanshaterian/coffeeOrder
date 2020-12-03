package com.example.coffeeorder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //variables:
    int quantity = 1;
    int price = 5;
    String name = "";
    boolean chocolate = false;
    boolean whippedCream = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View v) {
        if (quantity < 10)
            quantity++;
        else
            Toast.makeText(getApplicationContext(), "SORRY NO MORE COFFEE FOR YOU :(", Toast.LENGTH_SHORT).show();
        displayQuantity(quantity);
    }

    public void decrement(View v) {
        if (quantity > 1)
            quantity--;

        else
            Toast.makeText(getApplicationContext(), "SORRY YOU CAN NOT HAVE LESS COFFEE.", Toast.LENGTH_SHORT).show();
        displayQuantity(quantity);
    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.whippedCream:
                if (checked) {
                    whippedCream = true;
                } else {
                    whippedCream = false;
                }
                break;

            case R.id.chocolate:
                if (checked) {
                    chocolate = true;
                } else {
                    chocolate = false;
                }
                break;
        }
    }

    public void addWhippedCream(View v) {
        quantity--;
        displayQuantity(quantity);
    }

    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantityNumber);
        quantityTextView.setText("" + numberOfCoffees);
    }

}