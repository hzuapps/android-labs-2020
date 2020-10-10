package edu.hzuapps.androids;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903139Activity extends AppCompatActivity {
    private Net1814080903139Activity myThis;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903139);
        myThis=this;
        Button  alarmButton = findViewById(R.id.AlarmButton),
                timerButton=findViewById(R.id.TimerButton),
                timeButton = findViewById(R.id.TimeButton),
                stopwatchButton=findViewById(R.id.StopWatchButton);
        timeButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent timeIntent=new Intent(myThis,TimeActivity.class);
                startActivity(timeIntent);
            }
        });
        alarmButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent alarmIntent=new Intent(myThis,AlarmActivity.class);
                startActivity(alarmIntent);
            }
        });
        timerButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent timerIntent=new Intent(myThis,TimerActivity.class);
                startActivity(timerIntent);
            }
        });
        stopwatchButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent stopwatchIntent=new Intent(myThis,StopWatchActivity.class);
                startActivity(stopwatchIntent);
            }
        });

    }
}
