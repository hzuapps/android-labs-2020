package edu.hzuapps.androidlabs.net1814080903117;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903117Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Activity thisActivity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903117);
        Button btnOpen1 = findViewById(R.id.up_btn);
        btnOpen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,UploadActivity.class);
                thisActivity.startActivity(intent);
                thisActivity.finish();
            }
        });

        Button btnOpen2 = findViewById(R.id.down_btn);
        btnOpen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,DownloadActivity.class);
                thisActivity.startActivity(intent);
                thisActivity.finish();
            }
        });
    }
}