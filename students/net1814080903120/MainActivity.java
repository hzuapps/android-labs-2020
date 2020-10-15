package edu.hzuapps.androidlabs.net1814080903120;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void skip(View view){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,OtherActivity.class);
        startActivity(intent);
    }
}