package edu.hzuapps.androidlabs.androidpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class JzyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jzy);


        Button button1 = (Button) findViewById(R.id.return2_button);
        Button button2 = (Button) findViewById(R.id.rent_button);
        final JzyActivity thisActivity = this;
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, Net1814080903239Activity.class);
                thisActivity.startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, RenthouseActivity.class);
                thisActivity.startActivity(intent);
            }
        });
    }
}
