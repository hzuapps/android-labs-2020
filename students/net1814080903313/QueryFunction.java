package edu.hzuapps.androidlabs.net1814080903313;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class QueryFunction extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        final TextView textView1 = findViewById(R.id.tet_1);
        final TextView textView2 = findViewById(R.id.tet_2);
        final TextView textView3 = findViewById(R.id.tet_3);
        final TextView textView4 = findViewById(R.id.tet_4);

        final Button button1 = findViewById(R.id.button1);
        final Button button2 = findViewById(R.id.button2);
        final Button button3 = findViewById(R.id.button3);
        final Button button4 = findViewById(R.id.button4);

        final LinearLayout linearLayout1 = findViewById(R.id.line1);
        final LinearLayout linearLayout2 = findViewById(R.id.line2);
        final LinearLayout linearLayout3 = findViewById(R.id.line3);
        final LinearLayout linearLayout4 = findViewById(R.id.line4);

        //设置按钮点击事件
        final Button[] buttons = new Button[]{button1, button2, button3, button4};
        Button.OnClickListener onClickListener = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button1:
                        //初始化按钮颜色
                        initButtonColor(buttons);
                        button1.setBackgroundColor(Color.parseColor("#13BA09"));
                        hideView(linearLayout2);
                        hideView(linearLayout3);
                        hideView(linearLayout4);
                        linearLayout1.setVisibility(View.VISIBLE);
                        setTextViewScroll(textView1);
                        break;
                    case R.id.button2:
                        initButtonColor(buttons);
                        button2.setBackgroundColor(Color.parseColor("#0D8EFF"));
                        hideView(linearLayout1);
                        hideView(linearLayout3);
                        hideView(linearLayout4);
                        linearLayout2.setVisibility(View.VISIBLE);
                        setTextViewScroll(textView2);
                        break;
                    case R.id.button3:
                        initButtonColor(buttons);
                        button3.setBackgroundColor(Color.parseColor("#F13232"));
                        hideView(linearLayout2);
                        hideView(linearLayout1);
                        hideView(linearLayout4);
                        linearLayout3.setVisibility(View.VISIBLE);
                        setTextViewScroll(textView3);
                        break;
                    case R.id.button4:
                        initButtonColor(buttons);
                        button4.setBackgroundColor(Color.parseColor("#7B8587"));
                        hideView(linearLayout2);
                        hideView(linearLayout3);
                        hideView(linearLayout1);
                        linearLayout4.setVisibility(View.VISIBLE);
                        setTextViewScroll(textView4);
                        break;
                }

            }
        };
        button1.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);

        String t1 = textView1.getText().toString();
        System.out.println(t1);
        System.out.println(getFilesDir());
        File t1_file = new File(getFilesDir(),"t1File.txt");
        FileOutputStream fos;
        try {
            fos = openFileOutput("t1File.txt", Context.MODE_PRIVATE);
            fos.write(t1.getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    //文本滚动条方法
    public void setTextViewScroll(TextView textView) {
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
    }

    //隐藏未选中的视图
    protected void hideView(LinearLayout linearLayout) {
        linearLayout.setVisibility(View.GONE);
    }

    //初始化按钮颜色
    private void initButtonColor(Button[] buttons) {
        for (Button button : buttons) {
            button.setBackgroundColor(Color.parseColor("#D6D7D7"));
        }
    }
}
