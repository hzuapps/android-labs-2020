package edu.hzuapps.androidlabs.sec1814080911111;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import helper.FileHelper;
import java.util.Date;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Handler;
import android.widget.Toast;

import java.text.SimpleDateFormat;

public class TimerActivity extends AppCompatActivity {
    private TimerHandler timerHandler;
    private FileHelper fileHelper;
    Button star_timer, stop_timer;
    public Timer timer;

    public MyTimerTask task;
    public long init_timer;// 初始毫秒数；
    public long c_nTime;// 当前秒表时间统计的毫秒数：

    public TextView mtimeshow = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        // 获取程序所需控件
        mtimeshow = (TextView) findViewById(R.id.time_show);
        star_timer = (Button) findViewById(R.id.startTime);
        stop_timer = (Button) findViewById(R.id.stopTime);
        // 实例化Handler类；
        timerHandler = new TimerHandler(TimerActivity.this);
        // 定义单击事件（开启计时器）
        star_timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // 实例化计时器任务类
                task = new MyTimerTask(TimerActivity.this);

                // 实例化计时器类;
                timer = new Timer(true);
                // 安排在指定的时间执行指定的任务。
                timer.schedule(task, 0, 10);
            }
        });


        // 定义单击事件，关闭计时器：
        stop_timer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // 终止此计时器，丢弃所有当前已安排的任务。

                timer.cancel();
            }
        });


        }

    private class MyTimerTask extends TimerTask {
        private TimerActivity me;

        public MyTimerTask(TimerActivity p) {
            // 初始化计时器的时候调用，定义最开始的计时器时间;
            long datetime = System.currentTimeMillis();
            init_timer = datetime;
            me = p;
        }

        // 所被调用执行的任务;
        public void run() {

            // 获取当前时间，算出当前所过的的毫秒数，赋值给全部变量c_nTime;
            long current_timer = System.currentTimeMillis();
            c_nTime = current_timer - init_timer;
			/*使用handler的sendEmptyMessage(0)方法，
			发送一个message对象给Handler接收该并处理*/
            me.timerHandler.sendEmptyMessage(0);
        }
    }

    // 定义一个handler更新UI
    public class TimerHandler extends Handler {
        private TimerActivity me;
        public String time;
        public TimerHandler(TimerActivity m) {
            me = m;
        }

        @Override
        public void handleMessage(Message msg) {

            // 使用SimpleDateFormat格式化毫秒算出对应的小时，分，秒，毫秒并用TextView显示出来：
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("H：mm ：s : S");

            String updateCurrentTime = simpleDateFormat.format(new Date(
                    me.c_nTime));

            time  = updateCurrentTime;
            me.mtimeshow.setText("当前秒表：" + updateCurrentTime);


        }
    }

}

