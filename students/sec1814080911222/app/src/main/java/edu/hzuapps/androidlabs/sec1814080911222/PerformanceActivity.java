package edu.hzuapps.androidlabs.sec1814080911222;


import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class PerformanceActivity extends AppCompatActivity {

    // 设置常量
    private final static String PATH = "/sdcard/fover";
    private final static String FILENAME = "/my_plan.db";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Activity thisActivity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_performance);
        Button btnOpen = (Button) findViewById(R.id.main_btn);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, sec1814080911222Activity.class);
                thisActivity.startActivity(intent);
                thisActivity.finish();
            }
        });


        Drawable drawable = getResources().getDrawable(R.drawable.performance);
        drawable.setBounds(0,0,200,200);
        TextView textview = (TextView) findViewById(R.id.textview_01);
        textview.setCompoundDrawables(null,drawable,null,null);

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    loadsdCard();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    protected void loadsdCard() throws IOException {


            // 判断SD卡是否存在
            if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {

                // 目录
                File path = new File(PATH);
                // 文件
                File f = new File(PATH + FILENAME);
                FileInputStream fi = new FileInputStream(f);

                byte[] bytes = new byte[1024];
                int len = 0;
                while ((len=fi.read(bytes))!=-1){
                    System.out.print(new String(bytes,0,len));
                }


            }

    }


}