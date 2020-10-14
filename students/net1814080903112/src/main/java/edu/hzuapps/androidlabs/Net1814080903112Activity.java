package edu.hzuapps.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903112Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903112);

        final AppCompatActivity thisActivity = this;

        final Button gameButton,rankButton;
        gameButton = (Button) findViewById(R.id.gameButton);
        rankButton =(Button) findViewById(R.id.rankButton);

        gameButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,GameActivity.class);
                thisActivity.startActivity(intent);
            }
        });

        rankButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,RankActivity.class);
                thisActivity.startActivity(intent);
            }
        });
    }
}