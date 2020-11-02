package com.example.example2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903230MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_game = (Button)findViewById(R.id.button);
        final Net1814080903230MainActivity thisActivityG = this;
        btn_game.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(thisActivityG,Net1814080903230GameActivity.class);
                thisActivityG.startActivity(intent);
            }
        });

        Button btn_set = (Button)findViewById(R.id.button2);
        final Net1814080903230MainActivity thisActivityS = this;
        btn_set.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(thisActivityS,Net1814080903230SetActivity.class);
                thisActivityS.startActivity(intent);
            }
        });
    }
}