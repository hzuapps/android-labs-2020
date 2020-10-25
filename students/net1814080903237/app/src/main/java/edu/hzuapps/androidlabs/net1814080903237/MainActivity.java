package edu.hzuapps.androidlabs.net1814080903237;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_manage = (Button) findViewById(R.id.button1);
        final MainActivity thisActivity1 = this;
        button_manage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent1 = new Intent(thisActivity1,ManageActivity.class);
                thisActivity1.startActivity(intent1);
            }
        });


        Button button_sell = (Button) findViewById(R.id.button2);
        final MainActivity thisActivity2 = this;
        button_sell.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent2 = new Intent(thisActivity2,SellActivity.class);
                thisActivity2.startActivity(intent2);
            }
        });
    }
}