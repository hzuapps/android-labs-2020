package edu.hzuapps.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeworkMangerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework_manger);
    }
        public void showToast(View view){
            Toast.makeText(this,"点击启动了",Toast.LENGTH_LONG).show();
        }
    }
