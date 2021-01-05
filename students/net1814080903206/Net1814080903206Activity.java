package com.example.net1814080903206activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903206Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=findViewById(R.id.Adidas);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Net1814080903206Activity.this, AdidasActivity.class);
                Net1814080903206Activity.this.startActivity(intent);
            }
        });
        Button button2=findViewById(R.id.Nike);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(Net1814080903206Activity.this, NIKEActivity.class);
                Net1814080903206Activity.this.startActivity(intent2);
            }
        });
        Button button3=findViewById(R.id.Lining);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(Net1814080903206Activity.this, LININGActivity.class);
                Net1814080903206Activity.this.startActivity(intent3);
            }
        });
    }
}