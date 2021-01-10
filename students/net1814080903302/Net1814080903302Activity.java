package edu.hzuapps.myapplication0;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903302Activity extends AppCompatActivity {
    String fileName;
    String filePath;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903302);
        final Net1814080903302Activity thisActivity = this;

        Button button1 = (Button) findViewById(R.id.startluyin);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, StartRecording.class);
                startActivity(intent);
            }
        });
        Button button2 = (Button) findViewById(R.id.luyinline);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, RecordingLine.class);
                startActivity(intent);
            }
        });
        Button button3 = (Button) findViewById(R.id.lab5);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, Lab5.class);
                startActivity(intent);
            }
        });
    }

}