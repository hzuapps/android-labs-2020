package edu.hzuapps.androidlabs.net1814080903236;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class RecordActivity extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        Button button = findViewById(R.id.button2);
        final RecordActivity thisActivity = this;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, RemindActivity.class);
                RecordActivity.this.startActivity(intent);
            }
        });
    }
}
