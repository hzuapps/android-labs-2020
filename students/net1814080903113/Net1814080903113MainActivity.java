package edu.hzuapps.androidlabs.net1814080903113;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class Net1814080903113MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.net1814080903113main);

        final Activity thisActivity = this;

        Button btnOpen = (Button) findViewById(R.id.buttonopen);

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, Net1814080903113PhotoIntroActivity.class);
                thisActivity.startActivity(intent);
                //thisActivity.startActivityForResult(intent, 2016);

        Button btnshow = (Button) findViewById(R.id.buttonshow);

        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, Net1814080903113PhotoShowActivity.class);
                thisActivity.startActivity(intent);
            }
        });
            }
        });
    }
}
