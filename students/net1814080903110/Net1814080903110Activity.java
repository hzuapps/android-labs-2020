package edu.hzuapps.androidlabs.Net1814080903110;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


public class Net1814080903110Activity extends AppCompatActivity {

    private TestCourseData mySQLiteOpenHelper;
    private String schedule;
    private SQLiteDatabase myDatabase;
    private Context context;
    private TextView mySchedule[] = new TextView[5];


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903110);

        //跳转按钮
        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1814080903110Activity.this, SettingActivity.class);
                startActivity(intent);
            }
        });
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1814080903110Activity.this, RemindActivity.class);
                startActivity(intent);
            }
        });
    }}



