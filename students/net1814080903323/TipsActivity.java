package edu.hzuapp.androidlabs.net1814080903323activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TipsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        final EditText text1ET =(EditText)findViewById(R.id.editText1);
        Button login=(Button)findViewById(R.id.button1);
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //把获取到信息利用起来

                String text1=text1ET.getText().toString();
                FileOutputStream fos=null;
                //抛出异常
                try {
                    fos=openFileOutput("login",MODE_PRIVATE);
                    //把这些信息写入
                    fos.write((text1).getBytes());
                    fos.flush();//刷新
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();
                } finally {
                    if(fos!=null){
                        try {
                            fos.close();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                }
                Intent intent =new Intent();
                //跳转到InternalDataReadActivity
                intent.setClass(TipsActivity.this,TipsActivity.class);
                startActivity(intent);//实现跳转
            }
        });

    }

}