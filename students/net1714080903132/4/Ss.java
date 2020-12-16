package com.example.pl.qzd;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.aaa.net1714080903132.R;

public class Ss extends AppCompatActivity{
    ImageButton imageButton0;
    MyEditText myEditText;
    Button button;
    ImageView view;
    String text;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ss);
        getSupportActionBar().hide();

        imageButton0 = findViewById(R.id.IB_0);
        myEditText = findViewById(R.id.myET);
        button = findViewById(R.id.BT);
        view = findViewById(R.id.V);

        imageButton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        myEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                 text = myEditText.getText().toString();
                 if(text.equals("洗衣机")) {
                    button.setText("洗衣机                 8.10");
                    button.setBackgroundColor(Color.WHITE);
                    view.setVisibility(View.VISIBLE);
                 }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ss.this, Chaxun.class);
                startActivity(intent);
            }
        });


    }
}
