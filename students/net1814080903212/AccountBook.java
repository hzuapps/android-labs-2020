package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class accountBook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountbook);
        Button btnOpen = (Button) findViewById(R.id.button_back);
        final accountBook thisActivity = this;
        btnOpen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(thisActivity, Net1814080903212Activity.class);
                thisActivity.startActivity(intent);
            }
        });
    }
}