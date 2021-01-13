package edu.hzuapps.androidlabs.Net1806081301122activity.androidLabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HelpActivity extends AppCompatActivity {
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HelpActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}