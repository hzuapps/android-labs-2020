package edu.hzuapps.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TextActivity extends AppCompatActivity {
    private EditText mEditText;
    private Button mBtnShare,mBtnSave;
    private TextView mTvContent;
    private final String mFileName = "text.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        mEditText = (EditText)findViewById(R.id.edit);
        mBtnShare = (Button)findViewById(R.id.preview);
        mBtnSave = (Button)findViewById(R.id.save);
        mTvContent = (TextView)findViewById(R.id.tv_content);

        mBtnSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                save(mEditText.getText().toString());
            }
        });

        mBtnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTvContent.setText(read());
            }
        });
    }

    //存储数据
    private void save(String content){
        FileOutputStream fileOutputStream = null;
        try{
            fileOutputStream = openFileOutput(mFileName,MODE_PRIVATE);
            fileOutputStream.write(content.getBytes());
        }  catch (IOException e) {
            e.printStackTrace();
        } finally{
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //读取数据
    private String read(){
        FileInputStream fileInputStream = null;
        try{
            fileInputStream = openFileInput(mFileName);
            byte[] buff = new byte[1024];
            StringBuilder sb = new StringBuilder("");   //实现字符串的拼接
            int len = 0;
            while((len = fileInputStream.read(buff) )> 0){
                sb.append(new String(buff,0,len)); //把读取出来的内容变成String类型全部拼接在一起
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}