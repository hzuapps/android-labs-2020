package edu.hzuapps.androidlabs.sec1814080911111;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sec1814080911111Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button timer = (Button)findViewById(R.id.button4);
        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sec1814080911111Activity.this,TimerActivity.class);
                startActivity(intent);
            }
        });

        Button countDown = (Button)findViewById(R.id.button5);
        countDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sec1814080911111Activity.this,TimerActivity.class);
                startActivity(intent);
            }
        });
    }
}
