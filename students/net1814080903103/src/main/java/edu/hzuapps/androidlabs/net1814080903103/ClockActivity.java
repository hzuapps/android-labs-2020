package edu.hzuapps.androidlabs.net1814080903103;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class ClockActivity extends AppCompatActivity {
    private Button clock_button=null;
    private AlarmManager alarmManager=null;
    Calendar cal=Calendar.getInstance();
    final int DIALOG_TIME = 0; //设置对话框id


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
        Button btnOpen =(Button)findViewById(R.id.return_button );
        btnOpen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent =new Intent(ClockActivity.this,Net1814080903103Activity.class);
                ClockActivity.this.startActivity(intent);
            }
        });
        alarmManager=(AlarmManager)getSystemService(Context.ALARM_SERVICE);
        clock_button=(Button)findViewById(R.id.clock_button);
        clock_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                showDialog(DIALOG_TIME);//显示时间选择对话框
            }
        });

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        Dialog dialog=null;
        switch (id) {
            case DIALOG_TIME:
                dialog=new TimePickerDialog(
                        this,
                        new TimePickerDialog.OnTimeSetListener(){
                            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                                Calendar c=Calendar.getInstance();//获取日期对象
                                c.setTimeInMillis(System.currentTimeMillis()); //设置Calendar对象
                                c.set(Calendar.HOUR, hourOfDay); //设置闹钟小时数
                                c.set(Calendar.MINUTE, minute); //设置闹钟的分钟数
                                c.set(Calendar.SECOND, 0); //设置闹钟的秒数
                                c.set(Calendar.MILLISECOND, 0); //设置闹钟的毫秒数
                                Intent intent = new Intent(ClockActivity.this, AlarmReceiver.class); //创建Intent对象
                                PendingIntent pi = PendingIntent.getBroadcast(ClockActivity.this, 0, intent, 0); //创建PendingIntent
//alarmManager.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pi); //设置闹钟
                                alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), pi); //设置闹钟，当前时间就唤醒
                                Toast.makeText(ClockActivity.this, "闹钟设置成功", Toast.LENGTH_LONG).show();//提示用户
                            }
                        },
                        cal.get(Calendar.HOUR_OF_DAY),
                        cal.get(Calendar.MINUTE),
                        false);

                break;
        }
        return dialog;
    }
}

