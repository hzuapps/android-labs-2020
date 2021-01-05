package edu.hzuapps.androidlabs.net1814080903221;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Net1814080903221CountDownActivity extends AppCompatActivity implements OnClickListener {

    protected static final int MSG_WHAT = 0;
    private Button btn_go;
    private Button btn_get;
    private Button btn_stop;
    private static EditText et_time;
    private static TextView tv_time;

    private Timer timer;
    private static int time;

    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            tv_time.setText(time + "");
            switch (msg.what) {
                case MSG_WHAT:
                    if (time > 0) {
                        time--;
                    } else {
                        Toast.makeText(Net1814080903221CountDownActivity.this, "倒计时结束", Toast.LENGTH_SHORT).show();
                        if (timer != null) {
                            timer.cancel();
                            timer = null;
                        }
                    }
                    break;

                default:
                    break;
            }
        }

        ;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903221_count_down);
        btn_go = (Button) findViewById(R.id.btn_go);
        btn_get = (Button) findViewById(R.id.btn_get);
        btn_stop = (Button) findViewById(R.id.btn_stop);
        et_time = (EditText) findViewById(R.id.et_timer);
        tv_time = (TextView) findViewById(R.id.tv_time);
        btn_go.setOnClickListener(this);
        btn_get.setOnClickListener(this);
        btn_stop.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_get:
                if (et_time.getText().toString().trim() != null && !(et_time.getText().toString().trim().equals(""))) {
                    try {
                        time = Integer.parseInt(et_time.getText().toString());
                        tv_time.setText(et_time.getText().toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        Toast.makeText(Net1814080903221CountDownActivity.this, "时间格式不正确", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                break;
            case R.id.btn_go:
                if (timer == null) {
                    timer = new Timer();
                    timer.schedule(new TimerTask() {

                        @Override
                        public void run() {
                            mHandler.sendEmptyMessage(MSG_WHAT);

                        }
                    }, 0, 1000);
                } else {
                    Toast.makeText(Net1814080903221CountDownActivity.this, "请勿多次点击", Toast.LENGTH_SHORT).show();
                    return;
                }

                break;
            case R.id.btn_stop:
                if (timer != null) {
                    timer.cancel();
                    timer = null;
                }
                break;
            default:
                break;
        }
    }
}