package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903212Activity extends AppCompatActivity {

    @Override  
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903212);
        Button btnOpen = (Button) findViewById(R.id.button_open);
            final Net1814080903212Activity thisActivity = this;
        btnOpen.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Intent intent = new Intent(thisActivity, accountBook.class);
                    thisActivity.startActivity(intent);
                }
        });
        Button accountingBtnOpen = (Button) findViewById(R.id.button_accounting);
        accountingBtnOpen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(thisActivity, accounting.class);
                thisActivity.startActivity(intent);
            }
        });
    }




}