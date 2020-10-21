package edu.hzuapps.androidlabs.sec1814080911238;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InputActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_activity);

        final Activity thisActivity = this;
        Button btnOpen3 = (Button) findViewById(R.id.button3);
        btnOpen3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(InputActivity.this, "保存成功", Toast.LENGTH_LONG).show();
            }
        });
    }

}

