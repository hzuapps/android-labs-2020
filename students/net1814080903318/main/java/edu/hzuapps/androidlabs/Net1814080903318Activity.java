package edu.hzuapps.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;


public class Net1814080903318Activity extends AppCompatActivity {

    private TextView Luping;
    private TextView MyVideo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903318);
        Luping = findViewById(R.id.button);
        MyVideo = findViewById(R.id.button2);
        Luping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Net1814080903318Activity.this,LupingActivity.class);
                startActivity(intent);
            }
        });


        MyVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Net1814080903318Activity.this,MyVideoActivity.class);
                startActivity(intent);
            }
        });
    }
}