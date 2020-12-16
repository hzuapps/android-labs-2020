package com.example.pyq;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Lookpyq extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lookpyq);

        final Lookpyq thisActivity = this;

        Button listBtn = (Button) findViewById(R.id.button_send);
        listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,Sendpyq.class);
                startActivity(intent);
            }
        });
    }
}