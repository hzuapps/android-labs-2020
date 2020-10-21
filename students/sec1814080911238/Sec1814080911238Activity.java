package edu.hzuapps.androidlabs.sec1814080911238;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Sec1814080911238Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sec_1814080911238_activity);

        final Activity thisActivity = this;

        Button btnOpen = (Button) findViewById(R.id.button1);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity,RememberActivity.class);
                thisActivity.startActivity(intent);
            }
        });


        Button btnOpen2 = (Button) findViewById(R.id.button2);
        btnOpen2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity,InputActivity.class);
                thisActivity.startActivity(intent);
            }
        });
    }
}
