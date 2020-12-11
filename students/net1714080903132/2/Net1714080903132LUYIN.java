package com.example.pl.qzd;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.aaa.net1714080903132.R;

public class Net1714080903132LUYIN extends AppCompatActivity{
    EditText editText;
    EditText editText1;
    ImageButton imageButton;
    String money;
    String xx;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.luyin);
        getSupportActionBar().hide();


        editText = findViewById(R.id.ET_1);
        editText1 = findViewById(R.id.ET_2);
        imageButton = findViewById(R.id.IB_5);
        Intent intent = getIntent();
        money = intent.getStringExtra("1");
        xx = intent.getStringExtra("2");

        editText.setText(money);
        editText1.setText(xx);


        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
