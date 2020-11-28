package edu.hzuapps.androidlabs.net1814080903120;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class BorrowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.borrow);

        final ContentProviderActivity thisActivity = this;

        // 保存图书信息
        findViewById(R.id.save_book).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thisActivity.saveBook();
            }
        });


    }



    // 保存图书信息
    private void saveBook() {
        String bookname = ((EditText) findViewById(R.id.bookname)).getText().toString();
        String writer = ((EditText) findViewById(R.id.writer)).getText().toString();

        // 插入新记录
        ContentValues book = new ContentValues();
        //book.put("name", name); // Map <- Key:Value
        book.put(ContentProviderOfBooks.BOOKNAME, bookname);
        book.put(ContentProviderOfBooks.WRITER, writer);

        Uri uri = getContentResolver() // 执行插入操作
                .insert(ContentProviderOfBooks.CONTENT_URI, book);

        Toast.makeText(getBaseContext(),
                "借书请求已发送 \n" + uri.toString(), Toast.LENGTH_LONG).show();

        this.showBookInfo("",""); // 清除内容
    }

    private void showBookInfo(String bookname, String writer) {
        ((EditText) findViewById(R.id.bookname)).setText(bookname);
        ((EditText) findViewById(R.id.writer)).setText(writer);
    }

}