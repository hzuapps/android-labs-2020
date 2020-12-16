package com.example.pl.qzd;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aaa.net1714080903132.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Rili extends AppCompatActivity{
    private int days[][] = new int[6][7];
    private int num[] = new int[2];
    private int top = 0;
    private GridView gridView;

    private DataAdapt dataAdapt;

    private TextView textView;
    private int year;
    private int month;
    private String title;
    private ImageButton imageButton;
    private boolean iscx = false;

    ImageButton imageButton1;
    ImageButton imageButton2;
    ImageButton imageButton3;
    ImageButton imageButton4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rili);
        getSupportActionBar().hide();

        gridView = findViewById(R.id.GV_1);
        textView = findViewById(R.id.TV_1);
        imageButton = findViewById(R.id.IB_1);
        imageButton1 = findViewById(R.id.IB_qian);
        imageButton2 = findViewById(R.id.IB_hou);
        imageButton3 = findViewById(R.id.IB_ss);
        imageButton4 = findViewById(R.id.IB_zxtjt);

        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Rili.this, Month.class);
                startActivity(intent);
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Rili.this, Month1.class);
                startActivity(intent);
                iscx = false;
                imageButton.setImageDrawable(getResources().getDrawable(R.drawable.fh));
                gridView.setAdapter(dataAdapt);
                top = 0;
               // finish();
            }
        });

        year = Calendar.getInstance().get(Calendar.YEAR);
        month = Calendar.getInstance().get(Calendar.MONTH) + 1;

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                month -= 1;
                title = year+"."+month;
                textView.setText(title);
                days = getDayOfMonthFormat(year, month);
                DataAdapt1 dataAdapt1 = new DataAdapt1(Rili.this, days, year, month);
                gridView.setAdapter(dataAdapt1);
            }
        });

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                month += 1;
                title = year+"."+month;
                textView.setText(title);
                days = getDayOfMonthFormat(year, month);
                dataAdapt = new DataAdapt(Rili.this, days, year, month);
                gridView.setAdapter(dataAdapt);
            }
        });
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iscx = true;
                imageButton.setImageDrawable(getResources().getDrawable(R.drawable.wc));
                DataAdapt1 dataAdapt1 = new DataAdapt1(Rili.this, days, year, month);
                gridView.setAdapter(dataAdapt1);
            }
        });

        title = year+"."+month;
        textView.setText(title);

        days = getDayOfMonthFormat(year, month);
        dataAdapt = new DataAdapt(this, days, year, month);
        gridView.setAdapter(dataAdapt);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(iscx == true){
                    if(top == 1){
                        num[top++] = i;
                        DataAdapt2 dataAdapt2 = new DataAdapt2(Rili.this, days, year, month,num[0],num[1]);
                        gridView.setAdapter(dataAdapt2);
                    }else{
                        num[top++] = i;
                    }
                    TextView t = view.findViewById(R.id.T_adapt);
                    t.setBackgroundResource(R.drawable.bj4);
                    t.setTextColor(Color.rgb(255,255,255));
                }else{
                    Intent intent = new Intent(Rili.this, Days.class);
                    intent.putExtra("y", year);
                    intent.putExtra("m", month);
                    int day = (int)adapterView.getAdapter().getItem(i);
                    intent.putExtra("d",day);
                    startActivity(intent);
                }
            }
        });
    }






    public static int[][] getDayOfMonthFormat(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);//设置时间为每月的第一天
        //设置日历格式数组,6行7列
        int days[][] = new int[6][7];
        //设置该月的第一天是周几
        int daysOfFirstWeek = calendar.get(Calendar.DAY_OF_WEEK);
        //设置本月有多少天
        int daysOfMonth = getDaysOfMonth(year, month);

        int dayNum = 1;


        //将日期格式填充数组
        for (int i = 0; i < days.length; i++) {
            for (int j = 0; j < days[i].length; j++) {
                if(i == 0 && j< daysOfFirstWeek-1){
                    days[i][j] = 0;
                }else if(dayNum <= daysOfMonth){
                    days[i][j] = dayNum++;
                }else{
                    days[i][j] = 0;
                }
            }
        }
        return days;
    }


    public static int getCurrentDayOfWeek() {
        return Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
    }


    public static int getDaysOfMonth(int year, int month) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2:
                if (isLeap(year)) {
                    return 29;
                } else {
                    return 28;
                }
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
        }
        return -1;
    }
    public static boolean isLeap(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;
        }
        return false;
    }
}
