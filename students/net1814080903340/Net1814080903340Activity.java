package edu.hzuapps.net1814080903340activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Net1814080903340Activity extends AppCompatActivity {

        public void onClickEasy(View view) {
            Intent intent = new Intent(this, Easy.class);
            startActivity(intent);
        }
        public void onClickMiddle(View view) {
            Intent intent = new Intent(this,Middle.class);
            startActivity(intent);
        }

        public void onClickHigh(View view) {
            Intent intent = new Intent(this,High.class);
            startActivity(intent);
        }


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_net1814080903340);
        }
    }
