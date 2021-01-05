package edu.hzuapps.androidlabs.net1814080903202;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Net1814080903202Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903202);
        Button btn1 = (Button)findViewById(R.id.Moment);
        Button btn2 = (Button)findViewById(R.id.Comment);
        ImageButton btn3 = findViewById(R.id.Scan);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.Moment:
                intent = new Intent(this, Moment1814080903202Activity.class);
                break;
            case R.id.Comment:
                intent = new Intent(this, Comment1814080903202Activity.class);
                break;
            case R.id.Scan:
                intent = new Intent(this, Scan1814080903202Activity.class);
                break;
        }
        startActivity(intent);
    }
}