package com.example.net1814080903206activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.Random;

public class shopping_car extends AppCompatActivity {
    ImageView goods1,goods2,goods3;
    TextView price1,price2,price3,final_price;
    CheckBox checkBox1,checkBox2,checkBox3;
    Button button_allchoose,todatabase,show_database;
    Button price_check,check_now,clear_goods;
    boolean allcheck;
    int price;

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
        todatabase=(Button)findViewById(R.id.to_database);
        todatabase.setText("确认存入");
        show_database=(Button)findViewById(R.id.show_database);
        show_database.setText("查询信息");
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
                    if(checkBox1.isChecked()==true)
                    {
                        goods1.setImageBitmap(null);
                        price1.setText(null);

                    }
                    if(checkBox2.isChecked()==true)
                    {
                        goods2.setImageBitmap(null);
                        price2.setText(null);

                    }
                    if(checkBox3.isChecked()==true)
                    {
                        goods3.setImageBitmap(null);
                        price3.setText(null);

                    }
                    goods goods=new goods();
                    goods.clear_goods();
                }
            }
        });
        final shopping_car thisactivity=this;
        todatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==todatabase)
                {
                    thisactivity.save_message();
                }
            }
        });
        show_database.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==show_database)
                {
                    thisactivity.showNextBook();
                }
            }
        });
    }
    private void save_message()
    {   goods goods=new goods();
        String id=goods.show_id();
        String password=goods.show_password();
        String goods1=price1.getText().toString();
        ContentValues GOOD = new ContentValues();
        GOOD.put(database.ID,id);
        GOOD.put(database.Password,password);
        GOOD.put(database.goods1,goods1);
        Uri uri = getContentResolver().insert(database.CONTENT_URI,GOOD);
        Toast.makeText(getBaseContext(),"保存成功! \n" + uri.toString(), Toast.LENGTH_LONG).show();
    }
    private void declearinfo(int i)//清除内容
    {

        goods1.setImageBitmap(null);
        price1.setText(null);
        goods2.setImageBitmap(null);
        price2.setText(null);
        goods3.setImageBitmap(null);
        price3.setText(null);

    }
    private void showNextBook() {
        //String URL = ContentProviderOfBooks.URL;
        Cursor c = getContentResolver() // 执行查询
                .query(database.CONTENT_URI, null, null, null, null);
        String showall="";
        // 随机取1条记录
        if(c.moveToFirst()){
        do {
            String name = "";
            String tags = "";
            String goods="";

            int count = 0;

                name = c.getString(c.getColumnIndex(database.ID));
                tags = c.getString(c.getColumnIndex(database.Password));
                goods=c.getString(c.getColumnIndex(database.goods1));
                showall=showall+name+tags+goods;
            } while (c.moveToNext());}
            // 显示在界面上
            final_price.setText(showall);
        }
    }





