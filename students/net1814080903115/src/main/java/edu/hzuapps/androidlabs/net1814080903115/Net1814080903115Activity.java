package edu.hzuapps.androidlabs.net1814080903115;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903115Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Activity thisActivity = this;

        Button btnBrowse = (Button) findViewById(R.id.button_browse);
        btnBrowse.setX(300f);
        btnBrowse.setY(200f);
        View view = findViewById(R.id.button_browse);

        btnBrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, BrowseActivity.class);
                thisActivity.startActivity(intent);
                //thisActivity.startActivityForResult(intent, 2016);
            }
        });
        Button btnPlay = (Button) findViewById(R.id.button_play);
        btnPlay.setX(300f);
        btnPlay.setY(400f);
        View view2 = findViewById(R.id.button_play);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, PlayActivity.class);
                thisActivity.startActivity(intent);
                //thisActivity.startActivityForResult(intent, 2016);
            }
        });
    }
}