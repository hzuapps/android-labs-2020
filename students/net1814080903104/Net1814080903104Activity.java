package edu.hzuapps;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Net1814080903104Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Net1814080903104Activity thisActivity = this;

        Button button = (Button) findViewById(R.id.button_open);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(thisActivity,GetReward.class);
                thisActivity.startActivity(intent);
            }
        });


        Button button1 = (Button) findViewById(R.id.button_search);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(thisActivity,SearchMess.class);
                thisActivity.startActivity(intent);
            }
        });
    }
}