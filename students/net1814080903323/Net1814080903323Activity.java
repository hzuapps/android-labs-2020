package edu.hzuapp.androidlabs.net1814080903323activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;


public class Net1814080903323Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903323);

        final Button botton1;
        botton1 = findViewById(R.id.button1);
        botton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botton1.setBackgroundColor(Color.rgb(255, 0, 0));
                Intent i = new Intent(Net1814080903323Activity.this, InvitationActivity.class);
                startActivity(i);
            }
        });
        final Button botton2;
        botton2 = findViewById(R.id.button2);
        botton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botton2.setBackgroundColor(Color.rgb(255, 0, 0));
                Intent i = new Intent(Net1814080903323Activity.this, TipsActivity.class);
                startActivity(i);
            }
        });



   /*    Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Net1814080903323Activity.this, InvitationActivity.class);
                startActivity(i);
            }
        });

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(Net1814080903323Activity.this, TipsActivity.class);
                startActivity(j);
            }
        });
*/

    }
}

