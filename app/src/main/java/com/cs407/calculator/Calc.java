package com.cs407.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Calc extends AppCompatActivity {
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        textView=(TextView) findViewById(R.id.textView);
        Intent intent = getIntent();
        double result = intent.getDoubleExtra("result", 0.0); // Use "result" as the key

        textView.setText("Result: " + result);
    }
}