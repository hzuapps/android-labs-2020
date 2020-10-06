package edu.hzuapps.androidlabs.net1814080903202;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903202Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903202);
        Button btn1 = (Button)findViewById(R.id.button1);
        Button btn2 = (Button)findViewById(R.id.button2);
        Button btn3 = (Button)findViewById(R.id.button3);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final Net1814080903202Activity thisActivity = this;
        Intent intent,intent1;
        switch (v.getId()){
            case R.id.button1:
                intent = new Intent(thisActivity, Moment1814080903202Activity.class);
                thisActivity.startActivity(intent);
                intent1 = new Intent(Intent.ACTION_CALL);
                break;
            case R.id.button2:
                intent = new Intent(thisActivity, Comment1814080903202Activity.class);
                thisActivity.startActivity(intent);
                intent1 = new Intent(Intent.ACTION_CALL);
                break;
            case R.id.button3:
                intent = new Intent(thisActivity, Scan1814080903202Activity.class);
                thisActivity.startActivity(intent);
                intent1 = new Intent(Intent.ACTION_CALL);
                break;
        }
    }
}