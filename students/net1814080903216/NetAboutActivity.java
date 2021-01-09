package edu.hzuapps.androidlabs.net1814080903216;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NetAboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_about_ativity);

        Button btn1 = (Button)findViewById(R.id.button);
        Button btn3 = (Button)findViewById(R.id.button3);
        Button btn4 = (Button)findViewById(R.id.button4);
        final NetAboutActivity thisActivity = this;
        btn3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(thisActivity,LeaveMassage.class);
                thisActivity.startActivity(intent);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(thisActivity,MainActivity.class);
                thisActivity.startActivity(intent);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(thisActivity,MainActivity3.class);
                thisActivity.startActivity(intent);
            }
        });
    }

}