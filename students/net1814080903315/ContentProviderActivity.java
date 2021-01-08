package edu.hzuapps.androidlabs.net1814080903315;

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

        // 保存图片信息
        findViewById(R.id.button_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thisActivity.savePicture();
            }
        });

        // 加载下一张图片信息
        findViewById(R.id.button_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thisActivity.showNextPicture();
            }
        });

    }

    // 保存图片信息
    private void savePicture() {
        String name = ((EditText) findViewById(R.id.picture_name)).getText().toString();
        String tags = ((EditText) findViewById(R.id.picture_tags)).getText().toString();

        // 插入新记录
        ContentValues picture = new ContentValues();
        picture.put(ContentProviderOfPicture.NAME, name);
        picture.put(ContentProviderOfPicture.TAGS, tags);
        Uri uri = getContentResolver() // 执行插入操作
                .insert(ContentProviderOfPicture.CONTENT_URI, picture);

        Toast.makeText(getBaseContext(), //
                "保存成功! \n" + uri.toString(), Toast.LENGTH_LONG).show();

        this.showPictureInfo("", ""); // 清除内容
    }

    private void showPictureInfo(String name, String tags) {
        ((EditText) findViewById(R.id.Picture_name)).setText(name);
        ((EditText) findViewById(R.id.Picture_tags)).setText(tags);
    }

    // 显示下一张图片
    private void showNextPicture() {
        Cursor c = getContentResolver() // 执行查询
                .query(ContentProviderOfPicture.CONTENT_URI, null, null, null, null);

        // 随机取1条记录
        int random = (new Random()).nextInt(10);

        if (c.moveToFirst()) {
            String name = "";
            String tags = "";
            int count = 1;
            do {
                name = c.getString(c.getColumnIndex(ContentProviderOfPicture.NAME));
                tags = c.getString(c.getColumnIndex(ContentProviderOfPicture.TAGS));
                if (count++ == random) {
                    break;
                }
            } while (c.moveToNext());
            // 显示在界面上
            this.showPictureInfo(name, tags);
        } else {
            Toast.makeText(getBaseContext(), //
                    "没有可显示的图片!", Toast.LENGTH_LONG).show();
        }
    }
}