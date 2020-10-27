package edu.hzuapps.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyViewActivity extends AppCompatActivity {

    private Button returnmainview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view);

        returnmainview = findViewById(R.id.returnmainview);

        returnmainview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyViewActivity.this,Net1814080903226Activity.class);
                startActivity(intent);
            }
        });

    }
}