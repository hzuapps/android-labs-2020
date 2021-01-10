package edu.hzuapps.androidlabs.sec1814080911111;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;

public class CountdownActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText inputet;
    private Button get, startTime, stopTime;
    private TextView time;
    private int i = 0;
    private Timer timer = null;
    private TimerTask task = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown);
        initView();
    }

    private void initView() {
        inputet = findViewById(R.id.input);
        get = findViewById(R.id.get);
        startTime = findViewById(R.id.starttime);
        stopTime = findViewById(R.id.stoptime);
        time = findViewById(R.id.time);
        get.setOnClickListener(this);
        startTime.setOnClickListener(this);
        stopTime.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.get:
                time.setText(inputet.getText().toString());
                i = Integer.parseInt(inputet.getText().toString());
                break;
            case R.id.starttime:
                startTime();
                break;
            case R.id.stoptime:
                stopTime();
                break;
            default:
                break;
        }
    }

    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            time.setText(msg.arg1 + "");
            startTime();
        };
    };

    public void startTime() {
        timer = new Timer();
        task = new TimerTask() {

            @Override
            public void run() {
                if (i > 0) {   //加入判断不能小于0
                    i--;
                    Message message = mHandler.obtainMessage();
                    message.arg1 = i;
                    mHandler.sendMessage(message);
                }
            }
        };
        timer.schedule(task, 1000);
    }

    public void stopTime(){
        timer.cancel();
    }
}