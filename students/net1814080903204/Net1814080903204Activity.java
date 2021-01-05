package edu.hzuapps.androidlabs.net1814080903204;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

public class Net1814080903204Activity extends AppCompatActivity {
    Button button1;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.Button1);
        button2 = (Button) findViewById(R.id.Button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1814080903204Activity.this, Copy1Activity.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1814080903204Activity.this, Copy2Activity.class);
                startActivity(intent);
            }
        });
    }
}