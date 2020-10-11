package com.example.k00.labs2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903301Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903301);

        final Net1814080903301Activity thisActivity = this;

        Button button1 = (Button) findViewById(R.id.button_open1);//第一个button
        Button button2 = (Button) findViewById(R.id.button_open2);//第二个button
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, selectActivity.class);//实现第一个跳转
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, bookActivity.class);//实现第二个跳转
                startActivity(intent);
            }
        });
    }
}
