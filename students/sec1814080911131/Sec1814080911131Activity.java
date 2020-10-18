package com.example.sec1814080911131activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sec1814080911131Activity extends AppCompatActivity {

    private Button mEnterButton;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.first_Button:
                    Intent intent1 = new Intent(Sec1814080911131Activity.this, First_Activity.class);
                    startActivity(intent1);
                    break;
                case R.id.second_Button:
                    Intent intent2 = new Intent(Sec1814080911131Activity.this, Second_Activity.class);
                    startActivity(intent2);
                    break;

                case R.id.third_Button:
                    Intent intent3 = new Intent(Sec1814080911131Activity.this, Third_Activity.class);
                    startActivity(intent3);
                    break;

                case R.id.four_Button:
                    Intent intent4 = new Intent(Sec1814080911131Activity.this, Four_Activity.class);
                    startActivity(intent4);
                    break;
            }

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEnterButton = findViewById(R.id.first_Button);
        mEnterButton.setOnClickListener(mOnClickListener);

        mEnterButton = findViewById(R.id.second_Button);
        mEnterButton.setOnClickListener(mOnClickListener);

        mEnterButton = findViewById(R.id.third_Button);
        mEnterButton.setOnClickListener(mOnClickListener);

        mEnterButton = findViewById(R.id.four_Button);
        mEnterButton.setOnClickListener(mOnClickListener);


    }
}