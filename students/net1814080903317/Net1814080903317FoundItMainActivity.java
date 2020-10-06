package com.example.foundit.controller.activity.foundIt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foundit.R;

/**
 * author: djx
 * created on: 2020/9/28 15:23
 * description:失物招领主页面
 */
public class Net1814080903317FoundItMainActivity extends Activity {

    private ImageView myIv;
    private TextView publicTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foundit_main);
        initView();
        initListener();
    }

    private void initListener() {
        myIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Net1814080903317FoundItMainActivity.this,Net1814080903317FoundItMyActivity.class);
                startActivity(intent);
            }
        });
        publicTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Net1814080903317FoundItMainActivity.this,Net1814080903317FoundItAddActivity.class);
                startActivity(intent);
            }
        });


    }

    private void initView() {
        myIv = findViewById(R.id.foundit_my_iv);
        publicTv = findViewById(R.id.foundit_public_tv);
    }

}