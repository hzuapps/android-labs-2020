package edu.hzuapps.androidlabs.sec1814080911224;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class sec1814080911224Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Activity thisActivity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sec_1814080911224_activity);
        Button btnOpen1 = (Button) findViewById(R.id.draw_btn);
        btnOpen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,DrawActivity.class);
                thisActivity.startActivity(intent);
                thisActivity.finish();
            }
        });

        Button btnOpen2 = (Button) findViewById(R.id.shuffle_btn);
        btnOpen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,ShuffleActivity.class);
                thisActivity.startActivity(intent);
                thisActivity.finish();
            }
        });
    }
}