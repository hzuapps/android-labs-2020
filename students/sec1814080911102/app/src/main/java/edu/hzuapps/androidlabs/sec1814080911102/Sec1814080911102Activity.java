package edu.hzuapps.androidlabs.sec1814080911102;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Sec1814080911102Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Sec1814080911102Activity thisActivity = this;

        Button listBtn = (Button) findViewById(R.id.button_list);
        listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, ListActivity.class);
                startActivity(intent);
            }
        });

        Button clockBtn = (Button) findViewById(R.id.button_clock);
        clockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,ClockActivity.class);
                startActivity(intent);
            }
        });
    }
}