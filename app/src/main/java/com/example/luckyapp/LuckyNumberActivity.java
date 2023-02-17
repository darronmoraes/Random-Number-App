package com.example.luckyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
        int storeRandomNumber = generateRandomNumber();
        tv_luckyNumber.setText("" + storeRandomNumber);

        btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // call to shareData method
                shareData(name, storeRandomNumber);
            }
        });
    }

    public int generateRandomNumber() {
        Random random = new Random();   // Object of Random class
        int upperLimit = 1000;
        return random.nextInt(upperLimit);
    }

    // Share Data functionality
    public void shareData(String name, int randomNumber) {
        // Implicit Intents
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");  // Text type setting

        // Convert the int to string
        String number = String.valueOf(randomNumber);

        i.putExtra(Intent.EXTRA_SUBJECT, name + " got lucky today!");
        i.putExtra(Intent.EXTRA_TEXT, name + " Lucky number is " + number);

        startActivity(Intent.createChooser(i, "choose a platform"));
    }
}