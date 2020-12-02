package edu.hzuapps.browers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import edu.hzuapps.browers.bookmarks.BookmarksActivity;

public class Sec1814080911108Activity extends AppCompatActivity implements View.OnClickListener{

    private Context mContext;
    private FileHelper fileHelper;
    private ImageView btnBookmarks;
    private EditText address;
    private ImageView btnCollect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec1814080911108);
        mContext = getApplicationContext();
        bindViews();

    }

    private void bindViews(){
        btnBookmarks = (ImageView)findViewById(R.id.bookmarks);
        btnCollect = (ImageView)findViewById(R.id.bookmark_collect);
        address = (EditText)findViewById(R.id.address);

        btnBookmarks.setOnClickListener(this);
        btnCollect.setOnClickListener(this);
        address.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.address:
                Toast.makeText(Sec1814080911108Activity.this, "遇见爱情", Toast.LENGTH_SHORT).show();
                // 显式Intent
                Intent searchIntent = new Intent(Sec1814080911108Activity.this, SearchActivity.class);
                startActivity(searchIntent);
                break;
            case R.id.bookmarks:
                // 发出Toast
                Toast.makeText(Sec1814080911108Activity.this, "遇见爱情", Toast.LENGTH_SHORT).show();
                // 显式Intent
                Intent bookmarksIntent = new Intent(Sec1814080911108Activity.this, BookmarksActivity.class);
                startActivity(bookmarksIntent);
                break;
            case R.id.bookmark_collect:
                // 往文件中写入内容
                fileHelper = new FileHelper(mContext);
                String title = "服刑相当于住宾馆 狱中“帝王”牵出93名“保护伞。英特纳雄耐尔，就一定要实现。";
                try {
                    fileHelper.save("bookmark",title);
                    Toast.makeText(Sec1814080911108Activity.this, R.string.collect, Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(Sec1814080911108Activity.this, R.string.fail, Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
                break;
        }
    }
}