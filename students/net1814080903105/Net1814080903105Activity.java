package edu.hzuapps.androidlabs.net1814080903105;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

public class Net1814080903105Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.shopping);
        final Net1814080903105Activity _this = this;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(_this, ShoppingActivity.class);
                _this.startActivity(intent);
            }
        });

        Button button1 = findViewById(R.id.list);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(_this, ListActivity.class);
                _this.startActivity(intent);
            }
        });
    }
}
