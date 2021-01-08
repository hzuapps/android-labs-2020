package edu.hzuapps.androidlabs.androidpractice;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class ShowhouseActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showhouse);

        Button button1 = (Button) findViewById(R.id.wkc_button);
        Button button2 = (Button) findViewById(R.id.jzy_button);
        Button button3 = (Button) findViewById(R.id.bgy_button);
        Button button4 = (Button) findViewById(R.id.return1_button);
        final ShowhouseActivity thisActivity = this;
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, WkechengActivity.class);
                thisActivity.startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, JzyActivity.class);
                thisActivity.startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, BgyActivity.class);
                thisActivity.startActivity(intent);
            }
        });
        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, Net1814080903239Activity.class);
                thisActivity.startActivity(intent);
            }
        });
    }
}
