package edu.hzuapps.androidlabs.net1814080903216;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        Button btn1 = (Button)findViewById(R.id.button4);
        Button btn2 = (Button)findViewById(R.id.button2);
        Button btn3 = (Button)findViewById(R.id.button);
        final ViewActivity thisActivity = this;
        btn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(thisActivity, MainActivity.class);
                thisActivity.startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(thisActivity, online.class);
                thisActivity.startActivity(intent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(thisActivity, MainActivity2.class);
                thisActivity.startActivity(intent);
            }
        });
    }
}