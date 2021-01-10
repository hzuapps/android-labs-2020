package edu.hzuapps.androidlabs.sec1814080911133;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sec1814080911133.R;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class TActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    EditText editName,editTem;
    TextView textView1;
    TextView textView2;

    String fileName = "file";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t);

        Button 返回 = (Button)findViewById(R.id.button7);
        返回.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TActivity.this, TemActivity.class);
                startActivity(intent);
            }
        });

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        editName = findViewById(R.id.editName);
        editTem = findViewById(R.id.editTem);

        textView1 = findViewById(R.id.txt1);
        textView2 = findViewById(R.id.txt2);

    }

    public void btn1Click(View view) throws IOException {
     String name = editName.getText().toString();
     String tem = editTem.getText().toString();

     FileOutputStream fileOutputStream = openFileOutput(fileName,Context.MODE_APPEND);
     fileOutputStream.write((name+"##"+tem+"##").getBytes());
     if(fileOutputStream != null){
         fileOutputStream.close();
     }
     Toast.makeText(this,"存储成功",Toast.LENGTH_LONG).show();
}

    public void btn2Click(View view) throws IOException {
        FileInputStream fileInputStream = openFileInput(fileName);
        byte[] input = new byte[fileInputStream.available()];
        while (fileInputStream.read(input) != -1){
            String str = new String(input);
            String [] s = str.split("##");

            int n=s.length;
            textView1.setText("姓名："+s[n-2]);
            textView2.setText("体温："+s[n-1]);


        }
        if(fileInputStream != null){
            fileInputStream.close();
        }
    }
}