package edu.hzuapps.androidlabs.sec1814080911230;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import edu.hzuapps.androidlabs.sec1814080911230.R;
public class Sec1814080911230Activity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            final Activity thisActivity = this;
            Button btnOpen = (Button) findViewById(R.id.button1);
            View view = findViewById(R.id.button1);
            btnOpen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(thisActivity, StartGameActivity.class);
                    thisActivity.startActivity(intent);
                    //thisActivity.startActivityForResult(intent, 2016);
                }
            });

            Button btnOpen1 = (Button) findViewById(R.id.button2);
            View view1 = findViewById(R.id.button2);
            btnOpen1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view1) {
                    Intent intent = new Intent(thisActivity, RankActivity.class);
                    thisActivity.startActivity(intent);
                    //thisActivity.startActivityForResult(intent, 2016);
                }
            });

        }
    }
