package edu.hzuapps.androidlabs.lab5_1;

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

public class Net1814080903219FileStoreActivity extends AppCompatActivity {

    private Button write_btn;
    private Button read_btn;
    private TextView textView;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_store);
        read_btn = findViewById(R.id.read_btn);
        write_btn = findViewById(R.id.write_btn);
        textView = findViewById(R.id.textview);
        editText = findViewById(R.id.edittext);
        read_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(read());
            }
        });
        write_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(editText.getText().toString());
                editText.setText("");
            }
        });

    }

    private void save(String content){
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = openFileOutput("classpath:test.txt", MODE_PRIVATE);
            fileOutputStream.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String read(){
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = openFileInput("classpath:test.txt");
            byte[] buf = new byte[1024];
            StringBuilder sb = new StringBuilder("");
            int len = 0;
            while ((len = fileInputStream.read(buf)) > 0){
                sb.append(new String(buf, 0, len));
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }


}