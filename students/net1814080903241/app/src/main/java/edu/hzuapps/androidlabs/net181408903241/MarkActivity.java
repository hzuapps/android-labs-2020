package edu.hzuapps.androidlabs.net181408903241;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileOutputStream;
import java.io.IOException;

public class MarkActivity extends  AppCompatActivity {
    Button btn_start;
    EditText et_1,et_2;
    TextView text;
    String fileName = "Hello_file";

    private TextView pu_1;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punchtheclock);
        pu_1 = (TextView) findViewById(R.id.pu_1);
        btn_start= findViewById(R.id.btn_start);
        et_2 = findViewById(R.id.et_2);
        et_1 =  findViewById(R.id.et_1);

    }
    public void btClick (View view) throws IOException {
        String t1 = et_1.getText().toString();
        String t2= et_2.getText().toString();
        FileOutputStream fileOutputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
        fileOutputStream.write((t1+"##"+t2).getBytes());
        if(fileOutputStream !=null){
            fileOutputStream.close();
        }
        Toast.makeText(this,"存储成功",Toast.LENGTH_LONG).show();
    }

    }

