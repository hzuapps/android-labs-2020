package edu.hzuapps.androidlabs;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import edu.hzuapps.androidlabs.R;

public class Sec1814080911205Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec1814080911205);

        final Activity thisActivity = this;

        Button btnOpencity = (Button) findViewById(R.id.buttoncity);
        View viewcity = findViewById(R.id.buttoncity);

        Button btnOpentext = (Button) findViewById(R.id.buttontext);
        View viewtext = findViewById(R.id.buttontext);

        Button btnOpencheck = (Button) findViewById(R.id.buttoncheck);
        View viewcheck = findViewById(R.id.buttoncheck);

        btnOpencity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, AddCityActivity.class);
                thisActivity.startActivity(intent);
                //thisActivity.startActivityForResult(intent, 2016);
            }
        });

        btnOpentext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, AddTextActivity.class);
                thisActivity.startActivity(intent);
                //thisActivity.startActivityForResult(intent, 2016);
            }
        });

        btnOpencheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, CheckActivity.class);
                thisActivity.startActivity(intent);
                //thisActivity.startActivityForResult(intent, 2016);
            }
        });


    }
}