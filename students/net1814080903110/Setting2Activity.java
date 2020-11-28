package edu.hzuapps.androidlabs.Net1814080903110;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Setting2Activity extends AppCompatActivity implements View.OnClickListener {

    private String schedule;
    private Button editBtn,deleteBtn;
    private EditText scheduleInput;
    private TestCourseData mySQLiteOpenHelper;
    private SQLiteDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_2);

        // 首先获取到意图对象
        Intent intent = getIntent();
        // 获取到传递过来的姓名
        schedule = intent.getStringExtra("schedule");

        initView();
    }
    private void initView() {
        mySQLiteOpenHelper = new TestCourseData(this);
        myDatabase = mySQLiteOpenHelper.getWritableDatabase();

        editBtn = findViewById(R.id.editBtn);
        editBtn.setOnClickListener(this);
        deleteBtn = findViewById(R.id.deleteSchedule);
        deleteBtn.setOnClickListener(this);
        scheduleInput = findViewById(R.id.scheduleInput);
        scheduleInput.setText(schedule);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.deleteSchedule:
                deleteMySchedule();
                break;
            case R.id.editBtn:
                editSchedule();
                break;
        }
    }
    private void editSchedule() {
        ContentValues values = new ContentValues();
        values.put("scheduleDetail",scheduleInput.getText().toString());

        myDatabase.update("schedules",values,"scheduleDetail=?",new String[]{schedule});

        Intent intent = new Intent(Setting2Activity.this, SettingActivity.class);
        startActivity(intent);
    }

    private void deleteMySchedule() {
        myDatabase.delete("schedules","scheduleDetail=?",new String[]{schedule});

        Intent intent = new Intent(Setting2Activity.this, SettingActivity.class);
        startActivity(intent);
    }
}