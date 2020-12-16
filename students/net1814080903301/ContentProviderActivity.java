package edu.hzuapps.net1814080903301;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class ContentProviderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);

        final ContentProviderActivity thisActivity = this;

        // 保存婚纱信息
        findViewById(R.id.button_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thisActivity.saveDress();
            }
        });

        // 加载下一套婚纱信息
        findViewById(R.id.button_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thisActivity.showNextDress();
            }
        });

    }

    // 保存婚纱信息
    private void saveDress() {
        String name = ((EditText) findViewById(R.id.dress_name)).getText().toString();
        String tags = ((EditText) findViewById(R.id.dress_tags)).getText().toString();

        // 插入新记录
        ContentValues dress = new ContentValues();
        dress.put(ContentProviderOfWeedingdress.NAME, name);
        dress.put(ContentProviderOfWeedingdress.TAGS, tags);
        Uri uri = getContentResolver() // 执行插入操作
                .insert(ContentProviderOfWeedingdress.CONTENT_URI, dress);

        Toast.makeText(getBaseContext(), //
                "保存成功! \n" + uri.toString(), Toast.LENGTH_LONG).show();

        this.showDressInfo("", ""); // 清除内容
    }

    private void showDressInfo(String name, String tags) {
        ((EditText) findViewById(R.id.dress_name)).setText(name);
        ((EditText) findViewById(R.id.dress_tags)).setText(tags);
    }

    // 显示下一套婚纱
    private void showNextDress() {
        Cursor c = getContentResolver() // 执行查询
                .query(ContentProviderOfWeedingdress.CONTENT_URI, null, null, null, null);

        // 随机取1条记录
        int random = (new Random()).nextInt(10);

        if (c.moveToFirst()) {
            String name = "";
            String tags = "";
            int count = 1;
            do {
                name = c.getString(c.getColumnIndex(ContentProviderOfWeedingdress.NAME));
                tags = c.getString(c.getColumnIndex(ContentProviderOfWeedingdress.TAGS));
                if (count++ == random) {
                    break;
                }
            } while (c.moveToNext());
            // 显示在界面上
            this.showDressInfo(name, tags);
        } else {
            Toast.makeText(getBaseContext(), //
                    "没有可显示的婚纱!", Toast.LENGTH_LONG).show();
        }
    }
}
