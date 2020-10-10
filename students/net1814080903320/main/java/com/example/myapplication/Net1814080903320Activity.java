package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903320Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button jumpBtn=this.findViewById(R.id.run_jump_btn);
        jumpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击之后的处理
                Intent intent=new Intent(Net1814080903320Activity.this,RunActivity.class);
                startActivity(intent);
            }
        });

        Button jumpBtn_1=this.findViewById(R.id.friends_jump_btn);
        jumpBtn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击之后的处理
                Intent intent=new Intent(Net1814080903320Activity.this,FriendsActivity.class);
                startActivity(intent);
            }
        });

        Button jumpBtn_2=this.findViewById(R.id.talk_jump_btn);
        jumpBtn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击之后的处理
                Intent intent=new Intent(Net1814080903320Activity.this,TalkActivity.class);
                startActivity(intent);
            }
        });
    }
}
