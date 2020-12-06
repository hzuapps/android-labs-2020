package edu.hzuapps.androidlabs.sec1814080911111;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import helper.FileHelper;

public class Sec1814080911111Activity extends AppCompatActivity {

    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button timer = (Button)findViewById(R.id.timer);
        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sec1814080911111Activity.this,TimerActivity.class);
                startActivity(intent);
            }
        });

        Button countDown = (Button)findViewById(R.id.countDown);
        countDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sec1814080911111Activity.this,CountdownActivity.class);
                startActivity(intent);
            }
        });

        mContext = getApplicationContext();
        FileHelper fHelper = new FileHelper(mContext);
        String fileName = "timer";
        String fileContent = "timer init";

        try {
            fHelper.save(fileName, fileContent);
            Toast.makeText(getApplicationContext(), "欢迎使用", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "欢迎使用", Toast.LENGTH_SHORT).show();
        }
    }
}
