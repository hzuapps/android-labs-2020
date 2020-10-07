package com.example.thefirst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Recommend extends AppCompatActivity {
    private Recommend mythis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mythis=this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);

        Button buy=findViewById(R.id.buttonBuy);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent buyIntent=new Intent(mythis,Buy.class);
                startActivity(buyIntent);
            }
        });

        Button seache=findViewById(R.id.buttonSeache);
        seache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchIntent=new Intent(mythis,Search.class);
                startActivity(searchIntent);
            }
        });
    }
}