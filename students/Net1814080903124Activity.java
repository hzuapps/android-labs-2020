package edu.hzuapps.androidlabs.net1814080903124;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Net1814080903124Activity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Activity thisActivity = this;

        Button btnOpen = (Button) findViewById(R.id.button);
        Button btnOpen2 = (Button) findViewById(R.id.button2);
       // View view = findViewById(R.id.button);
       // View view2 = findViewById(R.id.button2);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, Net1814080903124ContentActivity.class);
                thisActivity.startActivity(intent);

            }
        });

       btnOpen2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent2 = new Intent(thisActivity, Net1814080903124GameActivity.class);
                thisActivity.startActivity(intent2);

            }
        });
    }

    }



