package com.example.sec1814080911217;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sec1814080911217Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Activity thisActivity = this;

        Button earn = (Button) findViewById(R.id.button_earnintegralactivity);

        View earnview = findViewById(R.id.button_earnintegralactivity);

        earn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View earnview) {
                Intent intent = new Intent(thisActivity, EarnIntegralActivity.class);
                thisActivity.startActivity(intent);

            }
        });

        Button exchange = (Button) findViewById(R.id.button_exchangeintegralactivity);

        View exchangeview = findViewById(R.id.button_exchangeintegralactivity);

        exchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View exchangeview) {
                Intent intent = new Intent(thisActivity, ExchangeIntegralActivity.class);
                thisActivity.startActivity(intent);

            }
        });

    }
}