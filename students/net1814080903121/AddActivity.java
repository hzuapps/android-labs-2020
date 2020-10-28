package edu.hzuapps.androidlabs.net1814080903121;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddActivity extends AppCompatActivity {
    Button btn_return,btn_save;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//子类在重写onCreate方法时必须调用父类方法
        setContentView(R.layout.activity_jilu);//
        btn_return=findViewById(R.id.btn_return);
        btn_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AddActivity.this,Net1814080903121Activity.class);
                startActivity(intent);
            }
        });
    }
}