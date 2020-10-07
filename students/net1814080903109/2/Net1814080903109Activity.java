package edu.hzuapps.androidlabs.net1814080903109;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903109Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //final Net1814080903109Activity thisActivity = this;

        Button button1 = (Button)findViewById(R.id.btn1);
        button1.setOnClickListener(new View.OnClickListener() {  //匿名类
            @Override
            public void onClick(View v) {   //功能
                Intent intent = new Intent(Net1814080903109Activity.this,Activity1.class);
                startActivity(intent);
            }
        });
        Button button2 = (Button)findViewById(R.id.btn2);
        button2.setOnClickListener(new View.OnClickListener() {  //匿名类
            @Override
            public void onClick(View v) {   //功能
                Intent intent = new Intent(Net1814080903109Activity.this,Activity2.class);
                startActivity(intent);
            }
        });
    }
}