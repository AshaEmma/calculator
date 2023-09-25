package com.cs407.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText number1;
    EditText number2;
    Button add;
    Button sub;
    Button mult;
    Button div;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mult = findViewById(R.id.mult);
        div = findViewById(R.id.div);
        textView = findViewById(R.id.textView);

        // Set click listeners for operation buttons
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate("+");
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate("-");
            }
        });

        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate("*");
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate("/");
            }
        });
    }

    void calculate(String op) {
        double num1 = Double.parseDouble(number1.getText().toString());
        double num2 = Double.parseDouble(number2.getText().toString());
        double answ = 0.0;

        switch (op) {
            case "+":
                answ = num1 + num2;
                break;
            case "-":
                answ = num1 - num2;
                break;
            case "*":
                answ = num1 * num2;
                break;
            case "/":
                answ = num1 / num2;
                break;
        }

        // Create an intent to start the new activity (Calc) and pass the result
        Intent intent = new Intent(this, Calc.class);
        intent.putExtra("result", answ); // Use "result" as the key
        startActivity(intent);
    }
}
