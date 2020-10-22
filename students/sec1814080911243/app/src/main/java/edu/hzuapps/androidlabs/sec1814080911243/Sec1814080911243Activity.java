package edu.hzuapps.androidlabs.sec1814080911243;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sec1814080911243Activity extends AppCompatActivity {

    private Button mEnterButton;
    private View.OnClickListener mOnClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.first_Button:
                        Intent intent = new Intent(Sec1814080911243Activity.this, CheckActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.second_Button:
                        Intent intent1 = new Intent(Sec1814080911243Activity.this, ManageActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.record_Button:
                        Intent intent2 = new Intent(Sec1814080911243Activity.this, RecordActivity.class);
                        startActivity(intent2);
                        break;
                }

            }
        };


        mEnterButton = findViewById(R.id.first_Button);
        mEnterButton.setOnClickListener(mOnClickListener);

        mEnterButton = findViewById(R.id.second_Button);
        mEnterButton.setOnClickListener(mOnClickListener);

        mEnterButton = findViewById(R.id.record_Button);
        mEnterButton.setOnClickListener(mOnClickListener);

    }
}