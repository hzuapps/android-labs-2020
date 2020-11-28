package edu.hzuapps.androidlabs.Net1814080903110;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.baoyz.widget.PullRefreshLayout;


public class SettingActivity extends AppCompatActivity implements View.OnClickListener {

    private String schedule;
    private Button queryBtn1, deleteBtn1, addBtn, addBth1, checkAdd;
    private EditText scheduleInput1;
    private Context context;
    private EditText scheduleInput;
    private TestCourseData mySQLiteOpenHelper;
    private SQLiteDatabase myDatabase;
    private TextView mySchedule[] = new TextView[5];
    private PullRefreshLayout pullRefreshLayout;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_1);
        initView();
        queryByDate();

        PullRefreshLayout layout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        // listen refresh event
        layout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
                // start refresh
            }
        });
// refresh complete
        layout.setRefreshing(false);
    }


    private void refresh(){
    finish();
        Intent intent = new Intent(this, SettingActivity.class);
        startActivity(intent);
    }



            private void initView() {
        mySQLiteOpenHelper = new TestCourseData(this);
        myDatabase = mySQLiteOpenHelper.getWritableDatabase();

        context = this;
        addBth1 = findViewById(R.id.addSchedule);   //添加
        addBth1.setOnClickListener(this);

        checkAdd = findViewById(R.id.checkAdd);         //确认
        checkAdd.setOnClickListener(this);

        deleteBtn1 = findViewById(R.id.deleteSchedule);   //清空数据
        deleteBtn1.setOnClickListener(this);

        scheduleInput = findViewById(R.id.scheduleDetailInput);
        mySchedule[0] = findViewById(R.id.schedule11);
        mySchedule[1] = findViewById(R.id.schedule22);
        mySchedule[2] = findViewById(R.id.schedule33);
        mySchedule[3] = findViewById(R.id.schedule44);
        mySchedule[4] = findViewById(R.id.schedule55);
        for (TextView v : mySchedule) {
            v.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addSchedule:
                addMySchedule();
                break;
            case R.id.checkAdd:
                checkAddSchedule();
                break;
            case R.id.deleteSchedule:
                deleteMySchedule();
                break;
            case R.id.schedule11:case R.id.schedule22:case R.id.schedule33:case R.id.schedule44:case R.id.schedule55:
                editSchedule(v);
                break;


        }
    }


    private void queryByDate() {
        //columns为null 查询所有列


        Cursor cursor = myDatabase.query("schedules", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            int scheduleCount = 0;
            do {
                String aScheduleDetail = cursor.getString(cursor.getColumnIndex("scheduleDetail"));
                mySchedule[scheduleCount].setText("日程" + (scheduleCount + 1) + "：" + aScheduleDetail);
                mySchedule[scheduleCount].setVisibility(View.VISIBLE);
                scheduleCount++;
                //一定要有这句 不然TextView不够多要数组溢出了
                if (scheduleCount >= 5)
                    break;
            } while (cursor.moveToNext());
        }
        cursor.close();
    }

    private void querySchedule() {
        //columns为null 查询所有列


        Cursor cursor = myDatabase.query("schedules", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            int scheduleCount = 0;
            do {
                String aScheduleDetail = cursor.getString(cursor.getColumnIndex("scheduleDetail"));
                mySchedule[scheduleCount].setText(aScheduleDetail);
                mySchedule[scheduleCount].setVisibility(View.VISIBLE);
                scheduleCount++;
                //一定要有这句 不然TextView不够多要数组溢出了
                if (scheduleCount >= 5)
                    break;
            } while (cursor.moveToNext());
        }
        cursor.close();
    }





    private void checkAddSchedule() {
        ContentValues values = new ContentValues();
        //第一个参数是表中的列名
        values.put("scheduleDetail", scheduleInput.getText().toString());
        myDatabase.insert("schedules", null, values);
        scheduleInput.setVisibility(View.GONE);
        checkAdd.setVisibility(View.GONE);
        //添加完以后把scheduleInput中的内容清除
        scheduleInput.setText("");
        queryByDate();
    }

    private void addMySchedule() {
        scheduleInput.setVisibility(View.VISIBLE);
        checkAdd.setVisibility(View.VISIBLE);
    }

    private void deleteMySchedule() {

        myDatabase.delete("schedules", null, null);

    }

    private void editSchedule(View v) {
        Intent intent = new Intent(SettingActivity.this,Setting2Activity.class);
        String sch = ((TextView) v).getText().toString().split("：")[1];
        intent.putExtra("schedule",sch);
        startActivity(intent);
    }
    private void flush(View v) {
        finish();
        Intent intent = new Intent(this, SettingActivity.class);
        startActivity(intent);
    }

}
































