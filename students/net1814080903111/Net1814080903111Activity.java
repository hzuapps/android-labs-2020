
package edu.hzuapps.androidlabs.net1814080903111;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Net1814080903111Activity extends AppCompatActivity implements Runnable{
    private Handler handler;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.net_1814080903111_activity);

        textView=(TextView) findViewById(R.id.tv_time);
        handler = new Handler() {
            public void handleMessage(Message msg) {
                textView.setText("当前时间："+(String)msg.obj);
            }
        };
        Button btn = findViewById(R.id.btn_check);
        final Net1814080903111Activity th = this;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(th,Check_recordActivity.class);
                th.startActivity(intent);
            }
        });

        new Thread(this).start();
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            while(true){
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日   HH:mm:ss");
                String str=sdf.format(new Date());
                handler.sendMessage(handler.obtainMessage(100,str));
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}