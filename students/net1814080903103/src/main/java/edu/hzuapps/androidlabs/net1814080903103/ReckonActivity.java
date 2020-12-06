package edu.hzuapps.androidlabs.net1814080903103;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class ReckonActivity extends AppCompatActivity {

     private Chronometer timer;
     private Timer timer1;
     private TextView textView;
     private TimerTask timerTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reckon);
        textView = (TextView) findViewById(R.id.text);
        timer1 = new Timer();
        Button btnOpen2 =(Button)findViewById(R.id.return_btn );
        btnOpen2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent =new Intent(ReckonActivity.this,Net1814080903103Activity.class);
                ReckonActivity.this.startActivity(intent);
            }
        });
    }
    public void btnClick(View view) {
                 timer.setBase(SystemClock.elapsedRealtime());//计时器清零
                 int hour = (int) ((SystemClock.elapsedRealtime() - timer.getBase()) / 1000 / 60);
                 timer.setFormat("0"+String.valueOf(hour)+":%s");
                 timer.start();
             }

             public void stopClick(View view) {
                 timer.stop();
             }

             public void startClick(View view) {
                 timerTask = new TimerTask() {
             int cnt = 0;
             @Override
             public void run() {
                 runOnUiThread(new Runnable() {
                     @Override
                     public void run() {
                         textView.setText(getStringTime(cnt++));
                                       }
                 });
                               }
                 };
                 timer1.schedule(timerTask,0,1000);
             }

             private String getStringTime(int cnt) {
                 int hour = cnt/3600;
                 int min = cnt % 3600 / 60;
                 int second = cnt % 60;
                 return String.format(Locale.CHINA,"%02d:%02d:%02d",hour,min,second);
             }

             public void stopClick1(View view) {
                 if (!timerTask.cancel()){
                         timerTask.cancel();
                         timer1.cancel();
                     }
             }
 }

