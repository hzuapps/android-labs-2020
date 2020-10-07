package com.example.example2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903230SetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);

        Button btn_back = (Button)findViewById(R.id.button3);
        final Net1814080903230SetActivity thisActivity = this;
        btn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,Net1814080903230MainActivity.class);
                thisActivity.startActivity(intent);
            }
        });
    }
}