package edu.hzuapps.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

import edu.hzuapps.androidlabs.R;

public class ContentProviderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);

        final ContentProviderActivity thisActivity = this;

        // 保存交易记录
        findViewById(R.id.button_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thisActivity.saveBook();
            }
        });

        // 加载下一个交易记录
        findViewById(R.id.button_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thisActivity.showNextBook();
            }
        });
    }



    // 保存交易记录
    private void saveBook() {
        String name = ((EditText) findViewById(R.id.trading_name)).getText().toString();
        String tags = ((EditText) findViewById(R.id.trading_tags)).getText().toString();

        // 插入新记录
        ContentValues book = new ContentValues();
        book.put(TradingProvider.NAME, name);
        book.put(TradingProvider.TAGS, tags);

        Uri uri = getContentResolver() // 执行插入操作
                .insert(TradingProvider.CONTENT_URI, book);

        Toast.makeText(getBaseContext(), //
                "保存成功! \n" + uri.toString(), Toast.LENGTH_LONG).show();

        //this.showBookInfo("", ""); // 清除内容
    }

    private void showBookInfo(String name, String tags) {
        ((EditText) findViewById(R.id.trading_name)).setText(name);
        ((EditText) findViewById(R.id.trading_tags)).setText(tags);
    }

    // 显示下一本书
    private void showNextBook() {
        //String URL = ContentProviderOfBooks.URL;
        Cursor c = getContentResolver() // 执行查询
                .query(TradingProvider.CONTENT_URI, null, null, null, null);

        // 随机取1条记录
        int random = (new Random()).nextInt(10);

        if (c.moveToFirst()) {
            String name = "";
            String tags = "";
            int count = 1;
            do {
                name = c.getString(c.getColumnIndex(TradingProvider.NAME));
                tags = c.getString(c.getColumnIndex(TradingProvider.TAGS));
                if (count++ == random) {
                    break;
                }
            } while (c.moveToNext());
            // 显示在界面上
            this.showBookInfo(name, tags);
        } else {
            Toast.makeText(getBaseContext(), //
                    "没有可显示的交易记录!", Toast.LENGTH_LONG).show();
        }
    }
}