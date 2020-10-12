package com.example.facewords_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903213Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 注册按钮
        Button buttonToSubmitResult = (Button) findViewById(R.id.buttonToSubmitResult);
        buttonToSubmitResult.setOnClickListener(this);
        Button buttonToWordList = (Button) findViewById(R.id.buttonToWordList);
        buttonToWordList.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonToSubmitResult:
                Intent intentSubmitResultActivity = new Intent(Net1814080903213Activity.this, SubmitResultActivity.class);
                startActivity(intentSubmitResultActivity);
            case R.id.buttonToWordList:
                Intent intentWordListActivity = new Intent(Net1814080903213Activity.this, WordListActivity.class);
                startActivity(intentWordListActivity);
            default:
                break;
        }
    }
}