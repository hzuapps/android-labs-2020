package edu.hzuapps.androidlabs;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.InputStreamReader;


public class AskActivity extends AppCompatActivity {

    EditText comment_nr;
    static final int READ_BLOCK_SIZE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask);

        comment_nr=(EditText)findViewById(R.id.comment_nr);
    }

    public void ReadBtn(View v) {
        //从文件读取文本
        try {
            FileInputStream FileIn=openFileInput("MyTextFile.txt");
            InputStreamReader InputRead= new InputStreamReader(FileIn);

            char[] inputBuffer= new char[READ_BLOCK_SIZE];
            String s="";
            int charRead;

            while ((charRead=InputRead.read(inputBuffer))>0) {
                //转换
                String ReadString=String.copyValueOf(inputBuffer,0,charRead);
                s += ReadString;
            }
            InputRead.close();
            comment_nr.setText(s);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}