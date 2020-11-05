package edu.hzuapps;

import androidx.annotation.RequiresPermission;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

import java.io.File;
import java.io.IOException;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class WriteActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

    }


public void sendMessage(View view){

    Intent intent = new Intent(WriteActivity.this, ReadActivity.class);
    EditText editText = (EditText) findViewById(R.id.EditWrite1);
    File file = new File(this.getFilesDir(),"lab5.txt");
    try {
        file.createNewFile(); // 练习1： 如何确认文件已经创建？
    } catch (IOException e) {
        e.printStackTrace();
    }
    EditText text = (EditText) findViewById(R.id.EditWrite1);
    String inputText = text.getText().toString();
    }
}