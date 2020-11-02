package edu.hzuapps.androidlabs.sec1814080911217;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class Sec1814080911217Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final Activity thisActivity = this;

        Button Earn = (Button) findViewById(R.id.button_earn_activity);

        View view1 = findViewById(R.id.button_earn_activity);

        Earn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent = new Intent(thisActivity, EarnIntegralActivity.class);
                thisActivity.startActivity(intent);
                //thisActivity.startActivityForResult(intent, 2016);
            }
        });

        Button btnOpen = (Button) findViewById(R.id.button_exchange_activity);

        View view2 = findViewById(R.id.button_exchange_activity);

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                Intent intent = new Intent(thisActivity, ExchangeIntegralActivity.class);
                thisActivity.startActivity(intent);
                //thisActivity.startActivityForResult(intent, 2016);
            }
        });
    }
}