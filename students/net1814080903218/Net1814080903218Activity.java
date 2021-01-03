package edu.hzuapps.androidlabs.net1814080903218;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903218Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903218);
        getWindow().setBackgroundDrawableResource(R.drawable.bg);
        final Net1814080903218Activity _this = this;
        Button button1 = findViewById(R.id.buttona1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(_this, InfoActivity.class);
                _this.startActivity(intent);
            }
        });
        Button button2 = findViewById(R.id.buttona2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(_this, ReasonActivity.class);
                _this.startActivity(intent);
            }
        });
        Button button3 = findViewById(R.id.buttona3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(_this, SportActivity.class);
                _this.startActivity(intent);
            }
        });

    }
}