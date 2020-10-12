package edu.hzuapp.androidlabs.net1814080903234;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903234Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903234);

        final Activity thisActivity = this;

        Button btnCon = (Button) findViewById(R.id.contact);

        btnCon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,ContactActivity.class);
                thisActivity.startActivity(intent);
            }
        });

        Button btnDyn = (Button) findViewById(R.id.dynamic);

        btnDyn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(thisActivity,DynamicActivity.class);
                thisActivity.startActivity(intent1);
            }
        });

    }




}
