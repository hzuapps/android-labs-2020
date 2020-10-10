package edu.hzuapps.androidlabs.net1814080903141;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class Net1814080903141Activity extends AppCompatActivity {
    private Net1814080903141Activity thisActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903141);
        thisActivity = this;
        Button btnNewGame=findViewById(R.id.button_newgame),btnRecord=findViewById(R.id.button_record);
        btnNewGame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent NewGameIntent=new Intent(thisActivity,NewGameActivity.class);
                startActivity(NewGameIntent);
            }
        });
        btnRecord.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent recordIntent=new Intent(thisActivity,RecordActivity.class);
                startActivity(recordIntent);
            }
        });
    }
}
