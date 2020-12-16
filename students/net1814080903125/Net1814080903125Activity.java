package edu.hzuapps.androidlabs.net1814080903125;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903125Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button add_btn = (Button)findViewById(R.id.add_btn);
        add_btn.setX(200f);
        add_btn.setY(200f);
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1814080903125Activity.this, AddDiaryActivity.class);
                Net1814080903125Activity.this.startActivity(intent);
            }
        });

        Button pwd_btn = (Button)findViewById(R.id.pwd_btn);
        pwd_btn.setX(600f);
        pwd_btn.setY(200f);
        pwd_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1814080903125Activity.this, PasswordActivity.class);
                Net1814080903125Activity.this.startActivity(intent);
            }
        });
    }
}