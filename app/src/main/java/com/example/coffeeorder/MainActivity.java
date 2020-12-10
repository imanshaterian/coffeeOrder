package com.example.coffeeorder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int quantity = 1;
    int price = 5;
    String name = "";
    String whippedCram = "NO";
    String chocolate = "NO";

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
            Toast.makeText(getApplicationContext(), "SORRY YOU CAN'T HAVE LESS :(", Toast.LENGTH_SHORT).show();
        displayQuantity(quantity);
    }

    public void displayQuantity(int quantity) {
        TextView quantitydisplay = findViewById(R.id.quantityTextView);
        String quantityNumber = "" + quantity;
        quantitydisplay.setText(quantityNumber);
    }

    public void CheckboxOnClick(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.whippedCreamCheckBox:
                if (checked) {
                    price += 2;
                    whippedCram = "YES";
                } else {
                    price -= 2;
                    whippedCram = "NO";
                }
                break;

            case R.id.chocolateCheckBox:
                if (checked) {
                    price += 1;
                    chocolate = "YES";
                } else {
                    price -=1;
                    chocolate = "NO";
                }
                break;
        }
    }


    public void getName() {
        EditText getNameId = findViewById(R.id.nameEditText);
        name = getNameId.getText().toString();
    }

    public void displaySummary() {
        TextView summaryId = findViewById(R.id.summaryTextView);
        String summary = "Name : " + name +
                "\nQuantity : " + quantity +
                "\nWhipped Cream :" + whippedCram +
                "\nChocolate :" + chocolate +
                "\nTotal : $" + quantity * price;
        summaryId.setText(summary);
    }

    public void submitOrder(View v) {
        getName();
        displaySummary();

    }

}