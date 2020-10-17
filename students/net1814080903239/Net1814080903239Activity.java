package edu.hzuapps.androidlabs.net1814080903239;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
public class Net1814080903239Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903239);

        final Net1814080903239Activity thisActivity = this;
        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, ShowhouseActivity.class);
                startActivity(intent);
            }
        });

    }
}

