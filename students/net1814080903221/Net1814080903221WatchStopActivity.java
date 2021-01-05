package edu.hzuapps.androidlabs.net1814080903221;

import androidx.appcompat.app.AppCompatActivity;

import android.os.SystemClock;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

public class Net1814080903221WatchStopActivity extends AppCompatActivity {

    Chronometer chronometer;
    Button startBtn, pauseBtn, recordBtn, resetBtn;
    long stopTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903221_watch_stop);

        chronometer = (Chronometer)findViewById(R.id.chronometer);
        startBtn = (Button)findViewById(R.id.startBtn);
        pauseBtn = (Button)findViewById(R.id.pauseBtn);
        recordBtn = (Button)findViewById(R.id.recordBtn);
        resetBtn = (Button)findViewById(R.id.resetBtn);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime() + stopTime);
                chronometer.start();
                startBtn.setVisibility(View.GONE);
                pauseBtn.setVisibility(View.VISIBLE);
            }
        });

        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopTime = chronometer.getBase() - SystemClock.elapsedRealtime();
                chronometer.stop();
                startBtn.setVisibility(View.VISIBLE);
                pauseBtn.setVisibility(View.GONE);
            }
        });

        recordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopTime = chronometer.getBase() - SystemClock.elapsedRealtime();
                TextView  listView = (TextView) findViewById(R.id.text);
                String text = chronometer.getText().toString();
                listView.setText(text);
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                stopTime = 0;
                chronometer.stop();
                startBtn.setVisibility(View.VISIBLE);
                pauseBtn.setVisibility(View.GONE);
            }
        });
    }
}