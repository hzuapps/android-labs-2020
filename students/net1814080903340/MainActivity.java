package edu.hzuapps.net1814080903340activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(new Sudo_easy(this));
        setContentView(new Sudo_middle(this));
        setContentView(new Sudo_high(this));

    }
}

