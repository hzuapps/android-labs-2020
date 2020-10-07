package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       Intent it = new Intent();
                                       it.setClass(MainActivity.this, SkipActivity.class);
                                       MainActivity.this.startActivity(it);
                                   }    });

            Button btn1= findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent it=new Intent();
                    it.setClass( MainActivity.this, SkipActivity1.class);
                    MainActivity.this.startActivity(it);
                }

        });
    }
}