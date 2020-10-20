package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903224activity extends AppCompatActivity {

    private Button jump1;
    private Button jump2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jump1 = findViewById(R.id.recommend);
        jump1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1814080903224activity.this,RecommendActivity.class);
                startActivity(intent);
            }
        });
        jump2 = findViewById(R.id.care1);
        jump2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1814080903224activity.this,CareActivity.class);
                startActivity(intent);
            }
        });


        };

    }