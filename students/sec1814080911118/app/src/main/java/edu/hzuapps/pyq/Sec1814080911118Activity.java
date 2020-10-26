package edu.hzuapps.pyq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sec1814080911118Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Sec1814080911118Activity thisActivity = this;

        Button listBtn = (Button) findViewById(R.id.button_main);
        listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,LookPyqActivity.class);
                startActivity(intent);
            }
        });
    }
}