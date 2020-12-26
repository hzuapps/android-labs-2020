package edu.hzuapps.androidlabs.net1814080903127;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Date;

public class RemindAdd extends AppCompatActivity {
    private Bundle bundle;
    private int id;
    private TextView title,text,time,date;
    private Context c;
    private AlarmManager alarmManager;
    private Calendar calendar;
    int mHour;
    int mMinute;
    int year,month,day;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remind_add);
        title=findViewById(R.id.texttitle);
        text=findViewById(R.id.text);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);
        c=RemindAdd.this;
        alarmManager= (AlarmManager) c.getSystemService(Context.ALARM_SERVICE);
        calendar=Calendar.getInstance();

        time.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calendar.setTimeInMillis(System.currentTimeMillis());
                mHour = calendar.get(Calendar.HOUR_OF_DAY);
                mMinute = calendar.get(Calendar.MINUTE);

                new TimePickerDialog(RemindAdd.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            public void onTimeSet(TimePicker view,
                                                  int hourOfDay, int minute) {
                                calendar.setTimeInMillis(System.currentTimeMillis());

                                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                                calendar.set(Calendar.MINUTE, minute);
                                calendar.set(Calendar.SECOND, 0);
                                calendar.set(Calendar.MILLISECOND, 0);
                                String s1=String.format("%d时%d分",hourOfDay,minute);
                                time.setText(s1);
                            }
                        }, mHour, mMinute, true).show();
            }
        });

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar.setTime(new Date());
                year=calendar.get(Calendar.YEAR);
                month=calendar.get(Calendar.MONTH);
                day=calendar.get(Calendar.DAY_OF_MONTH);
                new DatePickerDialog(RemindAdd.this, new DatePickerDialog.OnDateSetListener(){
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        calendar.set(Calendar.YEAR,year);
                        calendar.set(Calendar.MONTH, month);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        String s2=String.format("%d年%d月%d日",year,month+1,dayOfMonth);
                        date.setText(s2);
                    }
                },year,month,day).show();
            }
        });

        Button set=findViewById(R.id.RemindAdd);
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            int year=calendar.get(Calendar.YEAR);
            int month=calendar.get(Calendar.MONTH);
            int day=calendar.get(Calendar.DAY_OF_MONTH);
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);
            String time = "开始时间："+year+"-"+month+"-"+day+" "+hour+":"+minute;

                RemindDBHelper remindDBHelper=new RemindDBHelper(RemindAdd.this);
                SQLiteDatabase sqLiteDatabase=remindDBHelper.getReadableDatabase();
                remindDBHelper.adddata(sqLiteDatabase,title.getText().toString(),text.getText().toString(),time);
                id=remindDBHelper.queryre(sqLiteDatabase);
                Intent intent = new Intent(RemindAdd.this,Receiver.class);
                intent.putExtra("_id", id);
                intent.putExtra("title", title.getText().toString());
                intent.putExtra("content", text.getText().toString());
                intent.setClass(c, Receiver.class);
                PendingIntent pi = PendingIntent.getBroadcast(c, id, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);
                Intent i =new Intent(RemindAdd.this,RemindActivity.class);
                startActivity(i);
            }
        });
    }
}