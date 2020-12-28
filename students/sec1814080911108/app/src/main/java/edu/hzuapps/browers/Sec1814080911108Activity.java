package edu.hzuapps.browers;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.hzuapps.browers.bookmarks.BookmarksActivity;
import edu.hzuapps.browers.helper.FileHelper;
import edu.hzuapps.browers.webview.MyWebViewActivity;

public class Sec1814080911108Activity extends AppCompatActivity implements View.OnClickListener{

    private Context mContext;
    private FileHelper fileHelper;
    private ImageView btnBookmarks;
    private EditText textUrl;
    private ImageView btnCollect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec1814080911108);
        mContext = getApplicationContext();

        initView();
    }


    private void initView(){
        btnBookmarks = (ImageView)findViewById(R.id.bookmarks);
        btnCollect = (ImageView)findViewById(R.id.bookmark_collect);
        textUrl = (EditText)findViewById(R.id.textUrl);
        btnBookmarks.setOnClickListener(this);
        btnCollect.setOnClickListener(this);
        textUrl.setOnClickListener(this);

        // 地址输入栏获取与失去焦点处理
        textUrl.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {

                } else {
//                    Intent intent = new Intent(Sec1814080911108Activity.this, MyWebViewActivity.class);
//                    startActivity(intent);
                }
            }

        });
        // 监听键盘回车搜索
        textUrl.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
                    // 执行搜索
                    textUrl.clearFocus();
                    String searchUrl = textUrl.getText().toString();
                    // 搜索内容写入文件
                    fileHelper = new FileHelper(mContext);
                    try {
                        fileHelper.save("searchList", searchUrl);
                    } catch (Exception e) {
                        Toast.makeText(Sec1814080911108Activity.this, R.string.fail, Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                    Intent intent = new Intent(Sec1814080911108Activity.this, MyWebViewActivity.class);
                    startActivity(intent);
                }
                return false;
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bookmarks:
                // 发出Toast
                Toast.makeText(Sec1814080911108Activity.this, "遇见爱情", Toast.LENGTH_SHORT).show();
                // 显式Intent
                Intent bookmarksIntent = new Intent(Sec1814080911108Activity.this, BookmarksActivity.class);
                startActivity(bookmarksIntent);
                break;
            case R.id.bookmark_collect:
                Toast.makeText(Sec1814080911108Activity.this, "主页无法收藏", Toast.LENGTH_SHORT).show();
                // 往文件中写入内容
//                fileHelper = new FileHelper(mContext);
//                String title = "服刑相当于住宾馆 狱中“帝王”牵出93名“保护伞。英特纳雄耐尔，就一定要实现。";
//                try {
//                    fileHelper.save("bookmark",title);
//                    Toast.makeText(Sec1814080911108Activity.this, R.string.collect, Toast.LENGTH_SHORT).show();
//                } catch (Exception e) {
//                    Toast.makeText(Sec1814080911108Activity.this, R.string.fail, Toast.LENGTH_SHORT).show();
//                    e.printStackTrace();
//                }
                break;
        }
    }
}