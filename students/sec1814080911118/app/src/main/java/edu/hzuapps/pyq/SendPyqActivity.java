package edu.hzuapps.pyq;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.hzuapps.pyq.filehelper.FileHelper;
import edu.hzuapps.pyq.listview.Message;

public class SendPyqActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText;
    private Button btnSubmit;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_pyq);
        mContext = getApplicationContext();
        initView();
    }
    private void initView(){
        editText = (EditText) findViewById(R.id.content);
        btnSubmit = (Button)findViewById(R.id.submit);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.submit:
                String text = editText.getText().toString();
                FileHelper fHelper = new FileHelper(mContext);
                String filename = "message";
                String fileContent = editText.getText().toString();
                try {
                    fHelper.save(filename, fileContent + "。");
                    Toast.makeText(getApplicationContext(), "数据写入成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SendPyqActivity.this, LookPyqActivity.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "数据写入失败", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}