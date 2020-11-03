package com.example.net1814080903206activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class shopping_car extends AppCompatActivity {
    ImageView goods1,goods2,goods3;
    TextView price1,price2,price3,final_price;
    CheckBox checkBox1,checkBox2,checkBox3;
    Button button_allchoose;
    Button price_check,check_now,clear_goods;
    boolean allcheck;
    int price;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shoping_car);
         goods1=(ImageView)findViewById(R.id.goods1);
         goods2=(ImageView)findViewById(R.id.goods2);
         goods3=(ImageView)findViewById(R.id.goods3);
         price1=(TextView)findViewById(R.id.price1);
         price2=(TextView)findViewById(R.id.price2);
         price3=(TextView)findViewById(R.id.price3);
         final_price=(TextView)findViewById(R.id.all_price);
         checkBox1=(CheckBox)findViewById(R.id.checkbox1);
        checkBox2=(CheckBox)findViewById(R.id.checkbox2);
        checkBox3=(CheckBox)findViewById(R.id.checkbox3);
        button_allchoose=(Button)findViewById(R.id.allchoose);
        check_now=(Button)findViewById(R.id.check_now);
        price_check=(Button)findViewById(R.id.price_check);
        clear_goods=(Button)findViewById(R.id.clear);
        if(checkBox1.isChecked()==true&&checkBox2.isChecked()==true&&checkBox3.isChecked()==true )
            allcheck=true;
        else
            allcheck=false;
        button_allchoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==button_allchoose)
                {
                if( allcheck==false)
                {
                    checkBox1.setChecked(true);
                    checkBox2.setChecked(true);
                    checkBox3.setChecked(true);
                    allcheck=true;
                }
                else
                {
                    checkBox1.setChecked(false);
                    checkBox2.setChecked(false);
                    checkBox3.setChecked(false);
                    allcheck=false;
                }
                }
            }
        });
        price_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                price=0;
                if(checkBox1.isChecked()==true)
                {
                    price=price+Integer.parseInt(price1.getText().toString());
                }
                if(checkBox2.isChecked()==true)
                {
                    price=price+Integer.parseInt(price2.getText().toString());
                }
                if(checkBox3.isChecked()==true)
                {
                    price=price+Integer.parseInt(price3.getText().toString());
                }
                final_price.setText(price+"元");
            }
        });
        check_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==check_now)
                {
                    goods goods=new goods();
                    Bitmap[] a=goods.show_goods();
                    String[] showprice=goods.show_price();
                    goods1.setImageBitmap(a[0]);
                    goods2.setImageBitmap(a[1]);
                    goods3.setImageBitmap(a[2]);
                    price1.setText(showprice[0]);
                    price2.setText(showprice[1]);
                    price3.setText(showprice[2]);
                }
            }
        });
        clear_goods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==clear_goods)
                {
                    
                }
            }
        });

    }
    }