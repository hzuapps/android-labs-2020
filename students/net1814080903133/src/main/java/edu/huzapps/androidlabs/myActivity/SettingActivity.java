package edu.hzuapps.androidlabs.myActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.hzuapps.androidlabs.R;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        setTitle("设置界面");
    }
}