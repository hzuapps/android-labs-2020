package edu.hzuapps.androidlabs.sec1814080911234;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class Sec1814080911234Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Activity thisActivity = this;
        Button button_create = (Button) findViewById(R.id.create);
        Button button_date = (Button) findViewById(R.id.date);
        Button button_festival = (Button) findViewById(R.id.festival);

        button_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity,CreateActivity.class);
                thisActivity.startActivity(intent);
            }
        });

        button_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity,DateActivity.class);
                thisActivity.startActivity(intent);
            }
        });

        button_festival.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity,FestivalActivity.class);
                thisActivity.startActivity(intent);
            }
        });
    }
}
