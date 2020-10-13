package edu.hzuapps.androidlabs.Net1814080903101;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FarmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm);
        Button button=(Button)findViewById(R.id.tostore);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(FarmActivity.this, StoreActivity.class);
                startActivity(intent);

            }
        });
        Button button2=(Button)findViewById(R.id.tostoreware);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(FarmActivity.this, StorewareActivity.class);
                startActivity(intent);

            }
        });

    }
}