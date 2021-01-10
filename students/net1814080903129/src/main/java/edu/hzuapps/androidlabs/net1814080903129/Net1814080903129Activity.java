package edu.hzuapps.androidlabs.net1814080903129;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903129Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Activity thisActivity = this;

        Button btnOpen = (Button) findViewById(R.id.button_operation);


        View view = findViewById(R.id.button_operation);

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, OperationActivity.class);
                thisActivity.startActivity(intent);
            }
        });

        Button btnOpen2 = (Button) findViewById(R.id.button_shift);


        View view2 = findViewById(R.id.button_shift);

        btnOpen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, ShiftActivity.class);
                thisActivity.startActivity(intent);
            }
        });
    }
}