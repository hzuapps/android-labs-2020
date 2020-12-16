package edu.hzuapp.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903214Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonToGame = (Button)findViewById(R.id.toGame);
        buttonToGame.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Intent intent = new Intent();
                                                intent.setClass(Net1814080903214Activity.this, GameActivity.class);
                                                startActivity(intent);
                                            }
                                        }
        );


        Button buttonToHistoryScore = (Button)findViewById(R.id.toHistoryScore);
        buttonToHistoryScore.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        Intent intent = new Intent();
                                                        intent.setClass(Net1814080903214Activity.this, HistoryScoreActivity.class);
                                                        startActivity(intent);
                                                    }
                                                }
        );
    }
} 