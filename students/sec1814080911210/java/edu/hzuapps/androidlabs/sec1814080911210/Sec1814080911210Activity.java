package edu.hzuapps.androidlabs.sec1814080911210;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class Sec1814080911210Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec1814080911210);

        final Activity thisActivity = this;

        Button btnOpen = (Button) findViewById(R.id.search);
        Button btnOpen2 = (Button) findViewById(R.id.add);

        View view = findViewById(R.id.search);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, LocationActivity.class);
                thisActivity.startActivity(intent);
            }
        });
        View view2 = findViewById(R.id.add);
        btnOpen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, AddinfoActivity.class);
                thisActivity.startActivity(intent);
            }
        });
    }
}
