package edu.hzuapps.androidlabs.net1814080903131;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903131Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Activity thisActivity = this;

        Button btnOpen = (Button) findViewById(R.id.button);
        btnOpen.setX(300f);
        btnOpen.setY(200f);
        View view = findViewById(R.id.button);

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, SearchActivity.class);
                thisActivity.startActivity(intent);
                //thisActivity.startActivityForResult(intent, 2016);
            }
        });
        Button btnOpen1 = (Button) findViewById(R.id.button2);
        btnOpen1.setX(300f);
        btnOpen1.setY(400f);
        View view1 = findViewById(R.id.button2);

        btnOpen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, TranslateActivity.class);
                thisActivity.startActivity(intent);
                //thisActivity.startActivityForResult(intent, 2016);
            }
        });
    }
}