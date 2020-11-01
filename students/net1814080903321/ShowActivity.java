package edu.hzuapp.androidlabs.net1814080903321;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;


public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ImageButton kaonai = findViewById(R.id.kaonai);
        kaonai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ShowActivity.this, StoreActivity.class);
                startActivity(i);
            }
        });
        ImageButton fan = findViewById(R.id.fan);
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ShowActivity.this, StoreActivity.class);
                startActivity(i);
            }
        });
        ImageButton hanbao = findViewById(R.id.hanbao);
        hanbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ShowActivity.this, StoreActivity.class);
                startActivity(i);
            }
        });
        ImageButton roujuan = findViewById(R.id.roujuan);
        roujuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ShowActivity.this, StoreActivity.class);
                startActivity(i);
            }
        });

    }

}