package edu.hzuapps.androidlabs.net1814080903308;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShareActivity extends AppCompatActivity {
    //声明控件
    private EditText Title;
    private EditText Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        initView();
    }
    private void initView() {
        //关联控件
        Title = findViewById(R.id.title);
        Text = findViewById(R.id.text);
    }



    public void save(View view) {
        //当内容不为空时
        if(!TextUtils.isEmpty(Title.getText()) && !TextUtils.isEmpty(Text.getText())){
            FileOutputStream fos = null;
            try {


                //Context中的方法openFileOutput()，获取一个FileOutputStream对象
                fos = openFileOutput("data", Context.MODE_PRIVATE);
                String str = Title.getText().toString().trim() + "#" + Text.getText().toString().trim();
                fos.write(str.getBytes());
                Toast.makeText(getApplicationContext(), "保存成功", Toast.LENGTH_SHORT).show();



            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else{
            Toast.makeText(getApplicationContext(), "请输入内容", Toast.LENGTH_SHORT).show();
        }
    }


    private void read() {
        try{
            //利用Context中的openFileInput()方法获取输入流
            FileInputStream data = openFileInput("data");
            BufferedReader reader = new BufferedReader(new InputStreamReader(data));
            String line = reader.readLine();
            String[] split = line.split("#");
            Title.setText(split[0]);
            Text.setText(split[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}