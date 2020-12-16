package edu.hzuapps.androidlabs.net1814080903313;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903313Activity extends AppCompatActivity {
    private Button mBtA2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtA2 = findViewById(R.id.button);
        mBtA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1814080903313Activity.this,Activity2.class);
                startActivity(intent);
            }
        });
    }
}