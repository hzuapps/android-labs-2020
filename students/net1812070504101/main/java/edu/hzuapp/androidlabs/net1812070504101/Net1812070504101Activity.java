package edu.hzuapp.androidlabs.net1812070504101;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1812070504101Activity extends AppCompatActivity {


    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.btn);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
               Intent i =new Intent( Net1812070504101Activity.this, StatisticActivity.class);
               startActivity(i);
            }
       });
    }
}
