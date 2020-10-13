package edu.hzuapps.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class Net1814080903229MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Activity thisActivity = this;
        Button btnOpen = (Button) findViewById(R.id.button);
        View view =findViewById(R.id.button);

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void  onClick(View view) {
                Intent intent = new Intent(thisActivity, Net1814080903229TravelActivity.class);
                thisActivity.startActivity(intent);

            }
        });


    }
}
