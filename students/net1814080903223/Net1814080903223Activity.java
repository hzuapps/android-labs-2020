package edu.hzuapps.androidlabs.net1814080903223;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903223Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903223);
        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent();
                it.setClass(Net1814080903223Activity.this, PlayActivity.class);
                Net1814080903223Activity.this.startActivity(it);
            }    });

        Button btn2= findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent();
                it.setClass( Net1814080903223Activity.this, ViewandmodifyActivity.class);
                Net1814080903223Activity.this.startActivity(it);
            }

        });
    }
}