package edu.hzuapps.androidlabs.sec1814080911106;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

import helper.FileHelper;

public class AddActivity extends AppCompatActivity {
    private FileHelper fileHelper;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mContext = getApplicationContext();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Button btnConfirm = (Button) findViewById(R.id.btn_confirm);
        final EditText etInput = (EditText) findViewById(R.id.et_input);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fileHelper = new FileHelper(mContext);
                String fileName = "tag";
                String fileContent = etInput.getText().toString() + "。";
                try {
                    fileHelper.save(fileName,fileContent);
                    Toast.makeText(getApplicationContext(), "标签添加成功", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "标签添加失败", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button cancelBtn = (Button) findViewById(R.id.btn_cancel);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddActivity.this, Sec1814080911106Activity.class);
                startActivity(intent);
            }
        });
    }
}