package edu.hzuapp.androidlabs.net1814080903210;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewsInfo1814080903210Activityextends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Button button = findViewById(R.id.button);
        final NewsInfoActivity _this = this;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(_this, Comment1814080903210Activity.class);
                _this.startActivity(intent);
            }
        });
    }
}
