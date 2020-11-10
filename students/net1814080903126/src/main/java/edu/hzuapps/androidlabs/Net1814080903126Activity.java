package edu.hzuapps.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903126Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903126);

        final AppCompatActivity thisActivity = this;

        final Button newGameButton,continueButton,scoreButton;
        newGameButton = (Button) findViewById(R.id.newGameButton);
        continueButton = (Button) findViewById(R.id.continueGameButton);
        scoreButton = (Button) findViewById(R.id.scoreButton);

        newGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,GameActivity.class);
                thisActivity.startActivity(intent);
            }
        });

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,GameActivity.class);
                thisActivity.startActivity(intent);
            }
        });

        scoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, ScoreActivity.class);
                thisActivity.startActivity(intent);
            }
        });
    }
}