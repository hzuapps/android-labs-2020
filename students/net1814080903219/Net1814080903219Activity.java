package edu.hzuapps.androidlabs.net1814080903219;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903219Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnScore1 = findViewById(R.id.button);
        btnScore1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Net1814080903219Activity.this, QueryScoreActivity.class);
                startActivity(intent);
            }
        });

        Button btnScore2 =   findViewById(R.id.button2);
        btnScore2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Net1814080903219Activity.this, PhysicalScoreActivity.class);
                startActivity(intent);
            }
        });



    }


}