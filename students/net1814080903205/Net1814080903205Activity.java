package edu.hzuapps.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Net1814080903205Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Net1814080903205Activity thisActivity = this;
        Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(thisActivity,MainActivity1.class);
                thisActivity.startActivity(intent);
            }
        });
        FloatingActionButton btn1 = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        btn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(thisActivity,MainActivity2.class);
                thisActivity.startActivity(intent);
            }
        });
    }
}