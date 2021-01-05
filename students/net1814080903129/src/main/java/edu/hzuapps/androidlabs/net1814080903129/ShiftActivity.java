package edu.hzuapps.androidlabs.net1814080903129;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShiftActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shift);

        final Activity thisActivity = this;

        Button btnOpen = (Button) findViewById(R.id.button_back2);
        btnOpen.setX(300f);
        btnOpen.setY(200f);

        View view = findViewById(R.id.button_back2);

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, Net1814080903129Activity.class);
                thisActivity.startActivity(intent);
                //thisActivity.startActivityForResult(intent, 2016);
            }
        });
    }
}