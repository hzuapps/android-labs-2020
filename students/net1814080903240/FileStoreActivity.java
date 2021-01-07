package edu.hzuapps.androidlabs.net1814080903240;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStoreActivity extends AppCompatActivity {
    private EditText suggest_editText;
    private Button save_btn;
    private Button show_btn;
    private TextView mContent;
    private final String mFileName = "test.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filestore);

        suggest_editText = findViewById(R.id.et_suggest);
        save_btn = findViewById(R.id.save_btn);
        show_btn = findViewById(R.id.show_btn);
        mContent = findViewById(R.id.text_view);

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(suggest_editText.getText().toString());
                mContent.setText("");
            }
        });


        show_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContent.setText(read());
            }
        });
    }


    //存储数据
    private void save(String content){
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = openFileOutput(mFileName, MODE_PRIVATE);
            fileOutputStream.write(content.getBytes());
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    //读取数据
    private String read(){
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = openFileInput(mFileName);
            byte[] buff = new byte[1024];
            StringBuffer sb = new StringBuffer("");
            int length = 0;
            while ((length = fileInputStream.read(buff)) > 0){
                sb.append(new String(buff,0,length));
            }return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

}