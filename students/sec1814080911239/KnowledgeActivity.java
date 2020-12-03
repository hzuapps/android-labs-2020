package edu.hzuapps.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class KnowledgeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge);
        
        //接收文字
        //获取意图
        Intent intent = getIntent();
        //判断内容是否为空，防止出现闪退
        if (intent != null) {
            //获取另一个界面传过来的数据
            String string_knowledge = intent.getStringExtra("mstring_knowledge");
            //打开获得的数据
            setTitle(string_knowledge);
        }
    }
}