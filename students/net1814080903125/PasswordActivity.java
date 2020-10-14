package edu.hzuapps.androidlabs.net1814080903125;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        //设置返回按钮的跳转
        Button back_btn = (Button)findViewById(R.id.back_btn2);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PasswordActivity.this, Net1814080903125Activity.class);
                PasswordActivity.this.startActivity(intent);
            }
        });

        //设置TextView的大小及位置
        Drawable drawable = getResources().getDrawable(R.drawable.lock);
        drawable.setBounds(0,0,1100,700);
        TextView view = findViewById(R.id.lock);
        view.setCompoundDrawables(drawable,null,null,null);
    }
}