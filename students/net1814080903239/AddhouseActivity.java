package edu.hzuapps.androidlabs.androidpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.Button;
import android.content.Intent;
import android.view.View;
public class AddhouseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addhouse);

        final AddhouseActivity thisActivity = this;
        Button button1= (Button) findViewById(R.id.add_house_button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, Net1814080903239Activity.class);
                startActivity(intent);

            }
        });
    }
}
