package edu.hzuapps.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SolveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solve);

        //接收文字
        Intent intent = getIntent();
        if(intent !=null){
            String string_solve = intent.getStringExtra("mstring_solve");
            setTitle(string_solve);
        }
    }
}