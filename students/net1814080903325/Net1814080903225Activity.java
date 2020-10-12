package edu.hzuapp.androidlabs.net1814080903225;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Net1814080903325Activity extends AppCompatActivity {
    TextView t1;
    Button but1;
    Button but2;
    final MainActivity m = this;
    Time time;
    SimpleDateFormat df;   //显示格式
    boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = findViewById(R.id.t1);
        but1 = findViewById(R.id.but1);
        but2 = findViewById(R.id.but2);
        time = new Time();
        time.start();

    }

    public void send(View view) {
        Intent intent = new Intent(m, Main1814080903225Activity2.class);
        startActivity(intent);
//        flag = false;//结束当前线程

    }

    public void record(View view) {
        time.s = "Asia/Shanghai";
        df.setTimeZone(TimeZone.getTimeZone(time.s));
        but1.setEnabled(false);
        but2.setEnabled(true);
    }

    public void recordN(View view) {
        time.s = "America/New_York";
        df.setTimeZone(TimeZone.getTimeZone(time.s));
        but2.setEnabled(false);
        but1.setEnabled(true);
    }

    class Time extends Thread {
        String s = "";

        public Time() {
            df = new SimpleDateFormat("yyyy年MM月dd日\n HH:mm:ss");
        }

        public void run() {
            while (flag) {
                if (s.equals("Asia/Shanghai")) {
                    t1.post(new Runnable() {
                        @Override
                        public void run() {
                            t1.setText(but1.getText() + "\n" + df.format(new Date()));
                        }
                    });
                } else if (s.equals("America/New_York")) {
                    t1.post(new Runnable() {
                        @Override
                        public void run() {
                            t1.setText(but2.getText() + "\n" + df.format(new Date()));
                        }
                    });
                }

                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    // TODO 自动生成的 catch 块
                    e.printStackTrace();
                }
            }
        }
    }
}
