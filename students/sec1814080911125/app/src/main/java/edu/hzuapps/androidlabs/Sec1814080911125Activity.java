package edu.hzuapps.androidlabs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sec1814080911125Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec1814080911125);

        final Sec1814080911125Activity thisActivity = this;
        Button BtnStart = (Button) findViewById(R.id.button_start);
        BtnStart.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View view){
               Intent intent = new Intent(thisActivity,GameSceneActivity.class);
               thisActivity.startActivity(intent);
           }
        });
    }
}
