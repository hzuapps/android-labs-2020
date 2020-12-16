package edu.hzuapps.androidlabs.Net1814080903128.cookcake;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PersonalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        final Activity thisActivity = this;

        Button button = (Button) findViewById(R.id.Pmain);

        View view = findViewById(R.id.Pmain);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, Net1814080903128Activity.class);
                thisActivity.startActivity(intent);
            }
        });
    }
}