package edu.hzuapps.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TxtActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText edtData;
    private Button btnWriteToApp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_txt);

        //初始化控件对象
        edtData =(EditText)findViewById(R.id.edtData);
        btnWriteToApp = (Button)findViewById(R.id.btnWriteToApp);

        btnWriteToApp.setOnClickListener(this);
    }

    public void onClick(View view){
        switch (view.getId()){
            case  R.id.btnWriteToApp:
                writeToApp(edtData.getText().toString());
                break;
        }
    }
    public void writeToApp(String data){
        FileOutputStream out = null;
        try {
            out = openFileOutput("myFile",MODE_PRIVATE);
            out.write(data.getBytes());
            out.flush();// 清理缓冲区的数据流
            out.close();// 关闭输出流
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}