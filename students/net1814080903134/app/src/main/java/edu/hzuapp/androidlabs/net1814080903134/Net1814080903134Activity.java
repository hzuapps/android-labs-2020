package edu.hzuapp.androidlabs.net1814080903134;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.net1814080903134.R;

public class Net1814080903134Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Activity thisActivity = this;

        Button btnPer = findViewById(R.id.personal);

        btnPer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, PersonalCenterActivity.class);
                thisActivity.startActivity(intent);
                //thisActivity.startActivityForResult(intent, 2016);
            }
        });
        Button btnRela = findViewById(R.id.release);

        btnRela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent1 = new Intent(thisActivity, ReleaseIdleActivity.class);
                thisActivity.startActivity(intent1);
                //thisActivity.startActivityForResult(intent, 2016);
            }
        });
    }
}