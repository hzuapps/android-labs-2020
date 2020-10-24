package edu.hzuapps.androidlabs.sec1814080911203;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sec1814080911203Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Activity thisActivity = this;
        Button button_inquire = (Button) findViewById(R.id.Inquire);
        View view_inquire = findViewById(R.id.Inquire);

        button_inquire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent =new Intent(thisActivity,InquireActivity.class);
            thisActivity.startActivity(intent);
            }
        });


        Button button_Transfer = (Button) findViewById(R.id.Transfer);
        View view_Transfer = findViewById(R.id.Transfer);

        button_Transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,TransferActivity.class);
                thisActivity .startActivity(intent);
            }
        });


        Button button_Financial = (Button) findViewById(R.id.Financical);
        View view_Financial = findViewById(R.id.Financical);

        button_Financial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,TransferActivity.class);
                thisActivity.startActivity(intent);
            }
        });
    }
}