package edu.hzuapps.androidlabs.net1814080903115;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        Button btnBack = (Button) findViewById(R.id.button_back);
//        btnBack.setX(300f);
//        btnBack.setY(200f);
        View view = findViewById(R.id.button_back);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlayActivity.this, Net1814080903115Activity.class);
                PlayActivity.this.startActivity(intent);
                //thisActivity.startActivityForResult(intent, 2016);
            }
        });
    }
}