package com.example.pl.qzd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.aaa.net1714080903132.R;

import java.util.Calendar;

public class Net1714080903132Activity extends AppCompatActivity {
    ImageButton imageButton0;
    ImageButton imageButton1;
    ImageButton imageButton2;
    ImageButton imageButton3;
    ImageButton imageButton4;
    Button button1;
    TextView textView;
    int year;
    int month;
    int day;
    String title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        imageButton0 = findViewById(R.id.IB_0);
        imageButton1 = findViewById(R.id.IB_1);
        imageButton2 = findViewById(R.id.IB_2);
        imageButton3 = findViewById(R.id.IB_3);
        imageButton4 = findViewById(R.id.IB_4);




        button1 = findViewById(R.id.Bu_1);
        textView =findViewById(R.id.TV_1);

        year = Calendar.getInstance().get(Calendar.YEAR);
        month = Calendar.getInstance().get(Calendar.MONTH) + 1; // 0代表1月、11代表12月
        day = Calendar.getInstance().get(Calendar.DATE);
        title = new String(year+"."+month+"."+day);
        textView.setText(title);

        imageButton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Net1714080903132Activity.this, Ss.class);
                startActivity(intent);
            }
        });


        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Net1714080903132Activity.this, Tianjiajilu.class);
                startActivity(intent);
            }
        });

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Net1714080903132Activity.this, Rili.class);
                startActivity(intent);
            }
        });



        imageButton3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:{
                        imageButton3.setImageDrawable(getResources().getDrawable(R.drawable.luyin2));
                        break;
                    }
                    case MotionEvent.ACTION_UP:{
                        imageButton3.setImageDrawable(getResources().getDrawable(R.drawable.luyin));
                        Intent intent = new Intent(Net1714080903132Activity.this, 功能1Activity.class);
                        intent.putExtra("1", "60");
                        intent.putExtra("2", "今天出去吃饭花了60元");
                        startActivity(intent);
                        break;
                    }
                }
                return true;
            }
        });

        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Net1714080903132Activity.this, Zong.class);
                startActivity(intent);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Net1714080903132Activity.this, 功能1Activity.class);
                intent.putExtra("1", "50");
                intent.putExtra("2", "今天看电影50元");
                startActivity(intent);
            }
        });
    }
}
