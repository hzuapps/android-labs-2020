package edu.hzuapps.androidlabs.net1814080903125;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        Button back_btn = (Button)findViewById(R.id.delay_btn);
        back_btn.setX(600f);
        back_btn.setY(200f);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PasswordActivity.this, Net1814080903125Activity.class);
                PasswordActivity.this.startActivity(intent);
            }
        });
    }
}