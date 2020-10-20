package edu.hzuapps.androidlabs.sec1814080911142;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class sec1814080911142Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final sec1814080911142Activity thisActivity= this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnOpen1 = (Button) findViewById(R.id.button);
        btnOpen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(String.valueOf(thisActivity.Register.class));
                thisActivity.startActivity(intent);
                thisActivity.finish();
            }
        });

        Button btnOpen2 = (Button) findViewById(R.id.button2);
        btnOpen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,Payment.class);
                thisActivity.startActivity(intent);
                thisActivity.finish();
            }
        });
    }
}