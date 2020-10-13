package edu.hzuapps.androidlabs.net1814080903223;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ViewandmodifyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewandmodify);
        Button button2 = findViewById(R.id.button2);
        final HelpActivity _this = this;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(_this,viewandmodifyActivity.class);
                _this.startActivity(intent);
            }
        });
    }
}