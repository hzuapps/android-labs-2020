package edu.hzuapps.net1814080903340activity;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class EasyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Sudo_easy(this));
    }

}
