package edu.hzuapps.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903342Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903342);
        final Net1814080903342Activity thisActicity = this;

    Button btnOpen = (Button) findViewById(R.id.button);
        btnOpen.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActicity,SearchIdActivity.class);
                thisActicity.startActivity(intent);
            }
    });

        Button btnStart = (Button) findViewById(R.id.button2);
        btnStart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActicity,SearchTradingActivity.class);
                thisActicity.startActivity(intent);
            }
        });
}
}