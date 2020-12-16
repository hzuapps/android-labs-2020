package edu.hzuapps.androidlabs;

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

public class FileActivity extends AppCompatActivity {
   private EditText mEtName;
   private Button mBtnSave,mBtnShow;
   private TextView mTvContent;
   private final String mFileName="test.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        mEtName = (EditText) findViewById(R.id.et_name);
        mBtnSave = (Button) findViewById(R.id.btn_save);
        mBtnShow = (Button) findViewById(R.id.btn_show);
        mTvContent = (TextView) findViewById(R.id.tv_content);

        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(mEtName.getText().toString());
            }
        });

        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  mTvContent.setText(read());
            }
        });
    }
        //存储数据

        private void save (String content){
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = openFileOutput(mFileName, MODE_PRIVATE);
                fileOutputStream.write(content.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fileOutputStream != null) {
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

            try {
                fileInputStream = openFileInput(mFileName);
                byte[] buff = new byte[1024];
                StringBuilder sb = new StringBuilder(" ");
                int len = 0;
                while ((len = fileInputStream.read(buff)) > 0) {
                    sb.append(new String(buff, 0, len));
                }
                return sb.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }






