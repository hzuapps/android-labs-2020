package edu.hzuapps.androidlabs.net1814080903312;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903312Activity extends AppCompatActivity {
    private Button mBtPlay;
    private Button mBtMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtPlay = findViewById(R.id.bt_main_play);
        mBtPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1814080903312Activity.this,PlayActivity.class);
                startActivity(intent);
            }
        });
        mBtMusic = findViewById(R.id.bt_main_music);
        mBtMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1814080903312Activity.this,MusicActivity.class);
                startActivity(intent);
            }
        });
    }
}