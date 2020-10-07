package edu.hzuapps.androidlabs.net1814080903103;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903103Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Net1814080903103Activity thisActivity =this;
        Button btnOpen =(Button)findViewById(R.id.button_clock);
        btnOpen.setX(200f);
        btnOpen.setY(200f);
        btnOpen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent =new Intent(thisActivity,ClockActivity.class);
                thisActivity.startActivity(intent);
            }
        });


        Button btnOpen2 =(Button)findViewById(R.id.button_reckon);
        btnOpen2.setX(600f);
        btnOpen2.setY(200f);
        btnOpen2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent =new Intent(thisActivity,ReckonActivity.class);
                thisActivity.startActivity(intent);
            }
        });
    }
}
