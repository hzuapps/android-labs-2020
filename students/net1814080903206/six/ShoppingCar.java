package com.example.net1814080903206activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ShoppingCar extends AppCompatActivity{
    ImageView goods1,goods2,goods3,goods4,goods5;
    TextView price1,price2,price3,price4,price5,final_price,goods_name1,goods_name2,goods_name3,goods_name4,goods_name5;
    CheckBox checkBox1,checkBox2,checkBox3,checkBox4,checkBox5;
    Button button_allchoose,todatabase,show_database;
    Button price_check,check_now,clear_goods;
    EditText Showtest;
    boolean allcheck;
    int price;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shoping_car);

        Showtest=(EditText)findViewById(R.id.showtest);
         goods1=(ImageView)findViewById(R.id.goods1);
         goods2=(ImageView)findViewById(R.id.goods2);
         goods3=(ImageView)findViewById(R.id.goods3);
        goods4=(ImageView)findViewById(R.id.goods4);
        goods5=(ImageView)findViewById(R.id.goods5);
         price1=(TextView)findViewById(R.id.price1);
         price2=(TextView)findViewById(R.id.price2);
         price3=(TextView)findViewById(R.id.price3);
        price4=(TextView)findViewById(R.id.price4);
        price5=(TextView)findViewById(R.id.price5);
        goods_name1=(TextView)findViewById(R.id.goods_name1);
        goods_name2=(TextView)findViewById(R.id.goods_name2);
        goods_name3=(TextView)findViewById(R.id.goods_name3);
        goods_name4=(TextView)findViewById(R.id.goods_name4);
        goods_name5=(TextView)findViewById(R.id.goods_name5);
        final_price=(TextView)findViewById(R.id.all_price);
         checkBox1=(CheckBox)findViewById(R.id.checkbox1);
        checkBox2=(CheckBox)findViewById(R.id.checkbox2);
        checkBox3=(CheckBox)findViewById(R.id.checkbox3);
        checkBox4=(CheckBox)findViewById(R.id.checkbox4);
        checkBox5=(CheckBox)findViewById(R.id.checkbox5);
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
                    checkBox4.setChecked(true);
                    checkBox5.setChecked(true);
                    allcheck=true;
                }
                else
                {
                    checkBox1.setChecked(false);
                    checkBox2.setChecked(false);
                    checkBox3.setChecked(false);
                    checkBox4.setChecked(false);
                    checkBox5.setChecked(false);
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
                if(checkBox4.isChecked()==true)
                {
                    price=price+Integer.parseInt(price4.getText().toString());
                }
                if(checkBox5.isChecked()==true)
                {
                    price=price+Integer.parseInt(price5.getText().toString());
                }
                final_price.setText(price+"元");
            }
        });
        check_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==check_now)
                {
                    Goods goods=new Goods();
                    Bitmap[] a=goods.show_goods();
                    String[] showprice=goods.show_price();
                    String[] goodname=goods.Goods_name();
                    if(a!=null){
                    goods1.setImageBitmap(a[0]);
                    goods2.setImageBitmap(a[1]);
                    goods3.setImageBitmap(a[2]);
                    goods4.setImageBitmap(a[3]);
                    goods5.setImageBitmap(a[4]);
                    price1.setText(showprice[0]);
                    price2.setText(showprice[1]);
                    price3.setText(showprice[2]);
                    price4.setText(showprice[3]);
                    price5.setText(showprice[4]);
                    goods_name1.setText(goodname[0]);
                        goods_name2.setText(goodname[1]);
                        goods_name3.setText(goodname[2]);
                        goods_name4.setText(goodname[3]);
                        goods_name5.setText(goodname[4]);
                        Toast.makeText(getBaseContext(), "finish! \n" , Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(getBaseContext(), "finish! \n" , Toast.LENGTH_LONG).show();
                    }
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
                        goods_name1.setText(null);

                    }
                    if(checkBox2.isChecked()==true)
                    {
                        goods2.setImageBitmap(null);
                        price2.setText(null);
                        goods_name2.setText(null);
                    }
                    if(checkBox3.isChecked()==true)
                    {
                        goods3.setImageBitmap(null);
                        price3.setText(null);
                        goods_name3.setText(null);
                    }
                    if(checkBox4.isChecked()==true)
                    {
                        goods4.setImageBitmap(null);
                        price4.setText(null);
                        goods_name4.setText(null);
                    }
                    if(checkBox5.isChecked()==true)
                    {
                        goods5.setImageBitmap(null);
                        price5.setText(null);
                        goods_name5.setText(null);
                    }
                    Goods goods=new Goods();
                    goods.clear_goods();

                }

            }
        });
        final ShoppingCar thisactivity=this;
        todatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==todatabase) {

                    String id=Showtest.getText().toString();
                    if(id!=null)
                    thisactivity.save_message(id);
                    
                }
            }
        });
        show_database.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==show_database)
                {
                    Intent intent=new Intent(ShoppingCar.this,MyChoose.class);
                    ShoppingCar.this.startActivity(intent);
                }
            }
        });
    }
    private void save_message(String id)
    {

            String thisid=id;
            String goods1=price1.getText().toString();
            ContentValues GOOD = new ContentValues();
           GOOD.put(Database.ID, thisid);
            GOOD.put(Database.goods1, goods1);
        Toast.makeText(getBaseContext(), "123 \n" , Toast.LENGTH_LONG).show();
             Uri uri = getContentResolver().insert(Database.CONTENT_URI, GOOD);
            Toast.makeText(getBaseContext(), "保存成功! \n" , Toast.LENGTH_LONG).show();
    }

    private String showNextBook() {
        //String URL = ContentProviderOfBooks.URL;
        Cursor c = getContentResolver() // 执行查询
                .query(Database.CONTENT_URI, null, null, null, null);
        String showall="";
        // 随机取1条记录
        if(c.moveToFirst()){
        do {
            String name ;

            String goods;

            int count = 0;

                name = c.getString(c.getColumnIndex(Database.ID));
                //tags = c.getString(c.getColumnIndex(Database.Password));
                goods=c.getString(c.getColumnIndex(Database.goods1));
                showall=showall+name+goods;
            } while (c.moveToNext());}
            // 显示在界面上
            return  showall;
        }
        private void dele()
        {
           int i=getContentResolver().delete(Database.CONTENT_URI,null,null);
            Toast.makeText(getBaseContext(), "okk! \n" , Toast.LENGTH_LONG).show();
        }

    }





