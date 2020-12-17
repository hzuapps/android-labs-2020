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


public class PlanActivity extends AppCompatActivity {

    // 设置常量
    private final static String PATH = "/sdcard/fover";
    private final static String FILENAME = "/my_plan.db";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Activity thisActivity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        Button btnOpen1 = (Button) findViewById(R.id.main_btn);
        btnOpen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, sec1814080911222Activity.class);
                thisActivity.startActivity(intent);
                thisActivity.finish();
            }
        });

        Drawable drawable = getResources().getDrawable(R.drawable.plan);
        drawable.setBounds(0,0,200,200);
        TextView textview = (TextView) findViewById(R.id.textview_01);
        textview.setCompoundDrawables(null,drawable,null,null);

        btnOpen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sdCard();
            }
        });

    }

    protected void sdCard() {

        try {
            // 判断SD卡是否存在
            if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {

            // 目录
                File path = new File(PATH);
            // 文件
                File f = new File(PATH + FILENAME);
                if (path.exists() && f.exists()) {
                    Toast.makeText(PlanActivity.this, "文件已经存在，不要再点了 。",
                            Toast.LENGTH_SHORT).show();

                } else {
            // 如果目录文件不存在就创建目录
                if (!path.exists()) {
                        path.mkdirs();
                }
            // 如果文件不存在就创建文件
                    if (!f.exists()) {

                        f.createNewFile();
                    }
                }
            // 异常捕捉
            }
        } catch (Exception e) {
            Log.d("Fover", "OH no write SDcard faild");
        }

    }

}

