package edu.hzuapps.androidlabs.net1814080903218;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Net1814080903218Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903218);
        Button button1 = findViewById(R.id.button1);
        final Net1814080903218Activity _this = this;
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(_this, AskForLeave1814080903218Activity.class);
                _this.startActivity(intent);
            }
        });
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(_this, ReasonActivity.class);
                _this.startActivity(intent);
            }
        });
    }
}