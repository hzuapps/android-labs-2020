package edu.hzuapps.androidlabs.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.hzuapps.androidlabs.R;

public class Net1814080903122Activity extends AppCompatActivity {


    Net1814080903122Activity thisActivity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903122);
        Button button = (Button) findViewById(R.id.sureButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, MainActivity.class);
                thisActivity.startActivity(intent);
            }
        });

    }
}
