package com.example.net1814080903206activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Search extends AppCompatActivity {
    ImageView imageView1,imageView2,imageView3,imageView4;
    TextView textView1,textView2,textView3,textView4;
    Button add_goods1,add_goods2,add_goods3,add_goods4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        final EditText editText=(EditText)findViewById(R.id.edit_text);
        final Button button=(Button)findViewById(R.id.button1);

        imageView1 = (ImageView) findViewById(R.id.photo1);
        imageView2 = (ImageView) findViewById(R.id.photo2);
        imageView3 = (ImageView) findViewById(R.id.photo3);
        imageView4 = (ImageView) findViewById(R.id.photo4);
        textView1=(TextView)findViewById(R.id.money1);
        textView2=(TextView)findViewById(R.id.money2);
        textView3=(TextView)findViewById(R.id.money3);
        textView4=(TextView)findViewById(R.id.money4);
        add_goods1=(Button)findViewById(R.id.add_goods1);
        add_goods2=(Button)findViewById(R.id.add_goods2);
        add_goods3=(Button)findViewById(R.id.add_goods3);
        add_goods4=(Button)findViewById(R.id.add_goods4);
        add_goods1.setText("添加至购物车");
        add_goods2.setText("添加至购物车");
        add_goods3.setText("添加至购物车");
        add_goods4.setText("添加至购物车");
        final Context context=getBaseContext();
        final String[] test={"衣服","鞋子","童装"};
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==button)
                {
                    String inputText=editText.getText().toString();


                    if(inputText.equals("鞋子"))
                    {

                        String[] iconname=context.getResources().getStringArray(R.array.shoes);
                        int[]  b=new int[iconname.length];
                        for(int i=0;i<4;i++)
                            b[i]=context.getResources().getIdentifier(iconname[i],"drawable",getPackageName());
                        imageView1.setImageResource(b[0]);
                        imageView2.setImageResource(b[1]);
                        imageView3.setImageResource(b[2]);
                        imageView4.setImageResource(b[3]);
                        textView1.setText("1299元");
                        textView2.setText("1099元");
                        textView3.setText("899元");
                        textView4.setText("699元");
                    }
                    else if(inputText.equals("衣服"))
                    {
                        String[] iconname=context.getResources().getStringArray(R.array.clothes);
                        int[]  b=new int[iconname.length];
                        for(int i=0;i<4;i++)
                            b[i]=context.getResources().getIdentifier(iconname[i],"drawable",getPackageName());
                        imageView1.setImageResource(b[0]);
                        imageView2.setImageResource(b[1]);
                        imageView3.setImageResource(b[2]);
                        imageView4.setImageResource(b[3]);
                        textView1.setText("1299元");
                        textView2.setText("1099元");
                        textView3.setText("899元");
                        textView4.setText("699元");
                    }
                    else if(inputText.equals("童装"))
                    {
                        String[] iconname=context.getResources().getStringArray(R.array.kids);
                        int[]  b=new int[iconname.length];
                        for(int i=0;i<4;i++)
                            b[i]=context.getResources().getIdentifier(iconname[i],"drawable",getPackageName());
                        imageView1.setImageResource(b[0]);
                        imageView2.setImageResource(b[1]);
                        imageView3.setImageResource(b[2]);
                        imageView4.setImageResource(b[3]);
                        textView1.setText("1299元");
                        textView2.setText("1099元");
                        textView3.setText("899元");
                        textView4.setText("699元");
                    }
                    else
                    {
                        button.setText(inputText);
                        String[] iconname=context.getResources().getStringArray(R.array.kids);
                        int[]  b=new int[iconname.length];
                        for(int i=0;i<4;i++)
                            b[i]=context.getResources().getIdentifier(iconname[i],"drawable",getPackageName());
                        imageView1.setImageResource(b[0]);
                        imageView2.setImageResource(b[1]);
                        imageView3.setImageResource(b[2]);
                        imageView4.setImageResource(b[3]);
                        textView1.setText("1299元");
                        textView2.setText("1099元");
                        textView3.setText("899元");
                        textView4.setText("699元");
                    }



                }
            }
        });
        add_goods1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Goods goods=new Goods();
                goods.get_goods(((BitmapDrawable)imageView1.getDrawable()).getBitmap(),textView1.getText().toString());
            }
        });
        add_goods2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Goods goods=new Goods();
                goods.get_goods(((BitmapDrawable)imageView2.getDrawable()).getBitmap(),textView2.getText().toString());
            }
        });
        add_goods3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Goods goods=new Goods();
                goods.get_goods(((BitmapDrawable)imageView3.getDrawable()).getBitmap(),textView3.getText().toString());
            }
        });
        add_goods4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Goods goods=new Goods();
                goods.get_goods(((BitmapDrawable)imageView4.getDrawable()).getBitmap(),textView4.getText().toString());
            }
        });

    }
}