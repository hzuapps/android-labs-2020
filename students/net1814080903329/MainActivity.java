package edu.hzuapps.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mbtnTextview;
    private Button mbtnButton;
    private Button mbtnButton1;
    private Button mbtnButton2;
    private Button mbtnButton3;
    private Button mbtnButton4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mbtnTextview = findViewById(R.id.btn_textview);
        mbtnTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到作业提交界面
                Intent intent=new Intent(MainActivity.this,Net1814080903329Activity.class);
                startActivity(intent);
            }
        });


        mbtnButton=(Button) findViewById(R.id.btn_button);
        mbtnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到作业管理按钮界面
                Intent intent=new Intent(MainActivity.this,HomeworkMangerActivity.class);
                startActivity(intent);
            }
        });


        mbtnButton1=(Button) findViewById(R.id.btn_imge);
        mbtnButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到作业图片界面
                Intent intent=new Intent(MainActivity.this,PictureActivity.class);
                startActivity(intent);
            }
        });


        mbtnButton2=(Button) findViewById(R.id.btn_store);
        mbtnButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到存储界面
                Intent intent=new Intent(MainActivity.this,FileActivity.class);
                startActivity(intent);
            }
        });



        mbtnButton3=(Button) findViewById(R.id.btn_url);
        mbtnButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到使用HttpurlConnectionF访问界面
                Intent intent=new Intent(MainActivity.this,HttpUrlConnectionActivity.class);
                startActivity(intent);
            }
        });

        mbtnButton4=(Button) findViewById(R.id.btn_url1);
        mbtnButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到使用下载图片界面
                Intent intent=new Intent(MainActivity.this,SaveImageViewActivity.class);
                startActivity(intent);
            }
        });


    }
}