package com.example.sec1814080911125;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class Sec1814080911125Activity extends Activity {
    private View.OnClickListener onClickListener;
    private Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.button:
                        Intent intent = new Intent(Sec1814080911125Activity.this, com.example.sec1814080911125.FistActvity.class);
                        startActivity(intent);
                    case R.id.button1:
                        Intent intent1 = new Intent(Sec1814080911125Activity.this, com.example.sec1814080911125.SecondActivity.class);
                        startActivity(intent1);
                }
            }
        };

        button = findViewById(R.id.button);
        button.setOnClickListener(onClickListener);

        button = findViewById(R.id.button1);
        button.setOnClickListener(onClickListener);
    }
}
