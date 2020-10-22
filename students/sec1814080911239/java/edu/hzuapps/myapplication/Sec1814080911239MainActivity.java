package edu.hzuapps.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sec1814080911239MainActivity extends AppCompatActivity {
    Button myBtn_one;
    Button myBtn_two;
    Button myBtn_three;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Sec1814080911239MainActivity thisActivity = this;

        myBtn_one = (Button)findViewById(R.id.button);
        myBtn_one.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(thisActivity,ShareActivity.class);
                thisActivity.startActivity(intent);
                thisActivity.finish();
            }
        });

        myBtn_two = (Button)findViewById(R.id.button2);
        myBtn_two.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(thisActivity,KnowledgeActivity.class);
                thisActivity.startActivity(intent);
                thisActivity.finish();
            }
        });

        myBtn_two = (Button)findViewById(R.id.button3);
        myBtn_three.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(thisActivity,SolveActivity.class);
            }
        });
    }
}