package edu.hzuapps.net1814080903340activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MiddleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Sudo_middle(this));
    }
}
