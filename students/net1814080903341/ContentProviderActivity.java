package edu.hzuapps.Net1814080903341Activity;

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

        // 保存菜谱信息
        findViewById(R.id.button_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thisActivity.saveFood();
            }
        });

        // 加载下一个菜谱信息
        findViewById(R.id.button_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thisActivity.showNextFood();
            }
        });

    }

    // 保存菜谱信息
    private void saveFood() {
        String name = ((EditText) findViewById(R.id.food_name)).getText().toString();
        String tags = ((EditText) findViewById(R.id.food_tags)).getText().toString();

        // 插入新记录
        ContentValues food = new ContentValues();
        food.put(ContentProviderOfFoods.NAME, name);
        food.put(ContentProviderOfFoods.TAGS, tags);
        Uri uri = getContentResolver() // 执行插入操作
                .insert(ContentProviderOfFoods.CONTENT_URI,food);

        Toast.makeText(getBaseContext(), //
                "保存成功! \n" + uri.toString(), Toast.LENGTH_LONG).show();

        this.showFoodInfo("", ""); // 清除内容
    }

    private void showFoodInfo(String name, String tags) {
        ((EditText) findViewById(R.id.food_name)).setText(name);
        ((EditText) findViewById(R.id.food_tags)).setText(tags);
    }

    // 显示下一个菜谱
    private void showNextFood() {
        Cursor c = getContentResolver() // 执行查询
                .query(ContentProviderOfFoods.CONTENT_URI, null, null, null, null);

        // 随机取1条记录
        int random = (new Random()).nextInt(10);

        if (c.moveToFirst()) {
            String name = "";
            String tags = "";
            int count = 1;
            do {
                name = c.getString(c.getColumnIndex(ContentProviderOfFoods.NAME));
                tags = c.getString(c.getColumnIndex(ContentProviderOfFoods.TAGS));
                if (count++ == random) {
                    break;
                }
            } while (c.moveToNext());
            // 显示在界面上
            this.showFoodInfo(name, tags);
        } else {
            Toast.makeText(getBaseContext(), //
                    "没有可显示的菜谱!", Toast.LENGTH_LONG).show();
        }
    }
}