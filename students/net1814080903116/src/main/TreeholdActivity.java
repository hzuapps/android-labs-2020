package edu.hzuapps.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TreeholdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treehold);


            //获取各个数据信息
            final EditText nameET =(EditText)findViewById(R.id.nameTV);
            final EditText idET =(EditText)findViewById(R.id.idTV);

            //获得按钮控件
            Button login=(Button)findViewById(R.id.button);
            login.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    //把获取到信息利用起来
                    String name=nameET.getText().toString();
                    String id=idET.getText().toString();
                    FileOutputStream fos=null;
                    //抛出异常
                    try {
                        fos=openFileOutput("login",MODE_PRIVATE);
                        //把这些信息写入
                        fos.write((name+" "+id+" ").getBytes());
                        fos.flush();//刷新
                    }catch (FileNotFoundException e){
                        e.printStackTrace();
                    }catch (IOException e){
                        e.printStackTrace();
                    }finally {
                        if(fos!=null){
                            try {
                                fos.close();
                            }catch (IOException e){
                                e.printStackTrace();
                            }
                        }
                    }
                    Intent intent =new Intent();
                    intent.setClass(TreeholdActivity.this,PostActivity.class);
                    startActivity(intent);//实现跳转
                }
            });
        }
}