package edu.hzuapps.androidlabs.net1814080903125;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowDiaryActivity extends AppCompatActivity {
    DatabaseHelper dbHelper = null;
    SQLiteDatabase db = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_diary);

        Bundle bundle = getIntent().getExtras();
        String title1 = bundle.getString("title");
        String content = bundle.getString("content");
        TextView Iv = (TextView) findViewById(R.id.diary_title);
        Iv.setText("标题："+title1);
        TextView tv = (TextView) findViewById(R.id.diary_content);
        tv.setText("内容：\n"+content);

    }
}