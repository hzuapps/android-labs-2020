package edu.hzuapps.androidlabs.sec1814080911106;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sec1814080911106Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Sec1814080911106Activity thisActivity = this;

        Button listBtn = (Button) findViewById(R.id.button_view);
        listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,PictureActivity.class);
                startActivity(intent);
            }
        });

        Button clockBtn = (Button) findViewById(R.id.button_edit);
        clockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,EditActivity.class);
                startActivity(intent);
            }
        });
    }
}