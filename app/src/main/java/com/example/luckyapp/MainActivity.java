package com.example.luckyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et_inputName;
    Button btn_generate;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv_welcome);
        et_inputName = findViewById(R.id.et_nameInput);
        btn_generate = findViewById(R.id.btn_signIn);

        btn_generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // getting user name
                String name = et_inputName.getText().toString();
                // Explicit Intent
                Intent i = new Intent(getApplicationContext(), LuckyNumberActivity.class);
                // passing the name to second activity
                i.putExtra("name", name);
                startActivity(i);
            }
        });
    }
}