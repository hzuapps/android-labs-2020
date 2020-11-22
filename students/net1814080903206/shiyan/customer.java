package com.example.net1814080903206activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class customer extends AppCompatActivity {
    Button button;
    EditText number;
    EditText register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charge);
        button=(Button)findViewById(R.id.denglu);
        number=(EditText)findViewById(R.id.number);
        register=(EditText)findViewById(R.id.register);
        button.setText("登录");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(v==button)
            {
                String id=number.getText().toString();
                String password=register.getText().toString();
                goods goods=new goods();
                goods.get_User_id(id);
                goods.get_User_passwordt(password);

            }
            }
        });
    }
}