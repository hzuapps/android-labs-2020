package edu.hzuapp.androidlabs.net1814080903141;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903141Activity extends AppCompatActivity {
    private Net1814080903141Activity myThis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903141);
        myThis=this;
        Button gameButton = findViewById(R.id.GameButton),
                recordButton=findViewById(R.id.RecordButton);
        gameButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent gameIntent=new Intent(myThis,GameActivity.class);
                startActivity(gameIntent);
            }
        });
        recordButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent recordIntent=new Intent(myThis,RecordActivity.class);
                startActivity(recordIntent);
            }
        });
    }
}