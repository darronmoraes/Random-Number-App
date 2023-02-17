package com.example.luckyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class LuckyNumberActivity extends AppCompatActivity {

    TextView tv_welcome, tv_luckyNumber;
    Button btn_share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_number);

        tv_welcome = findViewById(R.id.tv_welcomeNumber);
        tv_luckyNumber = findViewById(R.id.tv_display_number);
        btn_share = findViewById(R.id.btn_share);

        // UserName
        Intent i = getIntent();
        String name = i.getStringExtra("name");

        // Random number
        tv_luckyNumber.setText("" + generateRandomNumber());
    }

    public int generateRandomNumber() {
        Random random = new Random();   // Object of Random class
        int upperLimit = 1000;
        return random.nextInt(upperLimit);
    }
}