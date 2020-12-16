package edu.hzuapps.androidlabs.Net1814080903207;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Net1814080903207FileActivity extends Activity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        OutputStream os = null;
        try {

            os = openFileOutput("user_files", MODE_PRIVATE);
            os.write("i am a string in the file!".getBytes());
            os.write("i am the second string in the file!".getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        FileInputStream fis = null;
        try {
            StringBuilder sb = new StringBuilder();
            fis = openFileInput("user_files");
            byte[] buff =new byte[1024];
            int len = 0;
            while((len = fis.read(buff))!=-1){
                sb.append(new String(buff,0,len));
            }

            TextView textView;
            textView=findViewById(R.id.textView);
            textView.setText(sb.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }




}

