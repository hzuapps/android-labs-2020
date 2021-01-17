package edu.hzuapps.androidlabs.sec1814080911222;


import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;


public class PlanActivity extends AppCompatActivity {

    public static int countTask = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Activity thisActivity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        final EditText view = (EditText) findViewById(R.id.editText);
        view.setOnFocusChangeListener(
                new android.view.View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if(hasFocus) {
                            // 此处为得到焦点时的处理内容
                        } else {
                            // 此处为失去焦点时的处理内容
                            String count = view.getText().toString();
                            countTask = Integer.parseInt(count);

                        }
                    }
                }

        );

    }
}