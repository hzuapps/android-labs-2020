package edu.hzuapps.androidlabs.net1814080903319;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903319MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Net1814080903319MainActivity thisActivity=this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903319);
        Button btnitem = (Button) findViewById(R.id.button);
        btnitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,ItemActivity.class);
                startActivity(intent);
            }
        });
        Button btnread = (Button) findViewById(R.id.button2);
        btnread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,ItemActivity.class);
                startActivity(intent);
            }
        });
    }
}
