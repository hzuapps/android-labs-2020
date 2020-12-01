package com.example.miracalfarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.*;



public class Net1814080903101Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton btu=(ImageButton)findViewById(R.id.starting);
        final Net1814080903101Activity thisActivity=this;
        btu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Net1814080903101Activity.this, FarmActivity.class);
                startActivity(intent);
            }
        });
    }


}