package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Sec1814080911129Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Sec1814080911129Activity thisActivity =this;
        Button btnOpen =(Button)findViewById(R.id.taxB);
        btnOpen.setX(200f);
        btnOpen.setY(200f);
        btnOpen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent =new Intent(thisActivity,TaxcountActivity.class);
                thisActivity.startActivity(intent);
            }
        });


        Button btnOpen2 =(Button)findViewById(R.id.tranB);
        btnOpen2.setX(600f);
        btnOpen2.setY(200f);
        btnOpen2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent =new Intent(thisActivity,TranActivity.class);
                thisActivity.startActivity(intent);
            }
        });

    }
}