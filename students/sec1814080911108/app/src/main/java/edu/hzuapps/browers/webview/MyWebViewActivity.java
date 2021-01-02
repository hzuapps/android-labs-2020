package edu.hzuapps.browers.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.Image;
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

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.hzuapps.browers.R;
import edu.hzuapps.browers.Sec1814080911108Activity;
import edu.hzuapps.browers.bookmarks.Bookmark;
import edu.hzuapps.browers.bookmarks.BookmarksActivity;
import edu.hzuapps.browers.helper.FileHelper;

public class MyWebViewActivity extends AppCompatActivity implements View.OnClickListener{
    private WebView webView;
    private ProgressBar progressBar;
    private EditText textUrl;
    private ImageView webIcon;
    private ImageView goBack;
    private ImageView goForward;
    private ImageView bookmarks;
    private ImageView goHome;
    private ImageView btnStart;
    private long exitTime = 0;
    private Context mContext;
    private InputMethodManager manager;
    private FileHelper fileHelper;
    private ImageView bookmarkCollect;

    private static final String HTTP = "http://";
    private static final String HTTPS = "https://";
    private static final int PRESS_BACK_EXIT_GAP = 2000;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_web_view);

        mContext = MyWebViewActivity.this;
        manager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

        // 绑定控件
        initView();

        // 初始化 WebView
        try {
            initWeb();
        } catch (IOException e) {
            e.printStackTrace();
        }
        manager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
    }
    /**
     * 绑定控件
     */
    private void initView() {
        webView = (WebView) findViewById(R.id.webView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        textUrl = (EditText)findViewById(R.id.textUrl);
        webIcon = (ImageView)findViewById(R.id.webIcon);
        btnStart = (ImageView)findViewById(R.id.btnStart);
        goBack = (ImageView)findViewById(R.id.goBack);
        goForward = (ImageView)findViewById(R.id.goForward);
        bookmarks = (ImageView)findViewById(R.id.bookmark_collect);
        goHome = (ImageView)findViewById(R.id.nav_home);
        bookmarkCollect = (ImageView)findViewById(R.id.bookmark_collect);

        // 绑定按钮点击事件
        btnStart.setOnClickListener(this);
        goBack.setOnClickListener(this);
        goForward.setOnClickListener(this);
        bookmarks.setOnClickListener(this);
        goHome.setOnClickListener(this);
        bookmarkCollect.setOnClickListener(this);

        // 地址输入栏获取与失去焦点处理
        textUrl.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
//                    // 显示当前网址链接 TODO:搜索页面显示搜索词
                    textUrl.setText(webView.getUrl());
//                    // 光标置于末尾
                    textUrl.setSelection(textUrl.getText().length());
//                    // 显示因特网图标
                    webIcon.setImageResource(R.drawable.internet);
//                    // 显示跳转按钮
//                    btnStart.setImageResource(R.drawable.go);
                } else {
                    // 显示网站名
                    textUrl.setText(webView.getTitle());
//                    // 显示网站图标
                    webIcon.setImageBitmap(webView.getFavicon());
//                    // 显示刷新按钮
                    btnStart.setImageResource(R.drawable.refresh);
                }
            }
        });

        // 监听键盘回车搜索
        textUrl.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
                    // 执行搜索
                    btnStart.callOnClick();
                    textUrl.clearFocus();
                }
                return false;
            }
        });
    }

    /**
     * 初始化 web
     */
    @SuppressLint("SetJavaScriptEnabled")
    private void initWeb() throws IOException {
        // 重写 WebViewClient
        webView.setWebViewClient(new MyWebViewClient());
        // 重写 WebChromeClient
        webView.setWebChromeClient(new MyWebChromeClient());

        WebSettings settings = webView.getSettings();
        // 启用 js 功能
        settings.setJavaScriptEnabled(true);
        // 设置浏览器 UserAgent
        settings.setUserAgentString(settings.getUserAgentString() + " mkBrowser/" + getVerName(mContext));

        // 将图片调整到适合 WebView 的大小
        settings.setUseWideViewPort(true);
        // 缩放至屏幕的大小
        settings.setLoadWithOverviewMode(true);

        // 支持缩放，默认为true。是下面那个的前提。
        settings.setSupportZoom(true);
        // 设置内置的缩放控件。若为false，则该 WebView 不可缩放
        settings.setBuiltInZoomControls(true);
        // 隐藏原生的缩放控件
        settings.setDisplayZoomControls(false);

        // 缓存
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        // 设置可以访问文件
        settings.setAllowFileAccess(true);
        // 支持通过JS打开新窗口
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        // 支持自动加载图片
        settings.setLoadsImagesAutomatically(true);
        // 设置默认编码格式
        settings.setDefaultTextEncodingName("utf-8");
        // 本地存储
        settings.setDomStorageEnabled(true);

        // 资源混合模式
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }

        // 加载首页
        fileHelper = new FileHelper(getApplicationContext());
        String input = this.fileHelper.read("searchList");
        if (!isHttpUrl(input)){
            // 不是网址，加载搜索引擎处理
            try {
                // URL 编码
                input = URLEncoder.encode(input, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            input = "www.baidu.com/s?wd=" + input + "&ie=UTF-8";
        }
        webView.loadUrl("http://" + input);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnStart:
                if (textUrl.hasFocus()) {
                    // 隐藏软键盘
                    if (manager.isActive()) {
                        manager.hideSoftInputFromWindow(textUrl.getApplicationWindowToken(), 0);
                    }

                    // 地址栏有焦点，是跳转
                    String input = textUrl.getText().toString();
                    if (!isHttpUrl(input)) {
                        // 不是网址，加载搜索引擎处理
                        try {
                            // URL 编码
                            input = URLEncoder.encode(input, "utf-8");
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                        input = "https://www.baidu.com/s?wd=" + input + "&ie=UTF-8";
                    }
                    webView.loadUrl(input);

                    // 取消掉地址栏的焦点
                    textUrl.clearFocus();
                } else {
                    // 地址栏没焦点，是刷新
                    webView.reload();
                }
                break;
            case R.id.goBack:
                webView.goBack();
                break;
            case R.id.goForward:
                webView.goForward();
                break;
            case R.id.bookmarks:
                // 显式Intent
                Intent bookmarksIntent = new Intent(MyWebViewActivity.this, BookmarksActivity.class);
                startActivity(bookmarksIntent);
                break;
            case R.id.nav_home:
                Intent intent = new Intent(MyWebViewActivity.this, Sec1814080911108Activity.class);
                startActivity(intent);
            case R.id.bookmark_collect:
                // 添加书签
                String webTitle = webView.getTitle();
                String webUrl = webView.getUrl();
                fileHelper = new FileHelper(mContext);
                try {
                    fileHelper.save("bookmarks",webTitle + "-" + webUrl + "。");
                    Toast.makeText(MyWebViewActivity.this, "收藏成功", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(MyWebViewActivity.this, "收藏失败", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            default:

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        try {
            webView.getClass().getMethod("onPause").invoke(webView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            webView.getClass().getMethod("onResume").invoke(webView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 重写 WebViewClient
     */
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // 设置在webView点击打开的新网页在当前界面显示,而不跳转到新的浏览器中

            if (url == null) {
                // 返回true自己处理，返回false不处理
                return true;
            }

            // 正常的内容，打开
            if (url.startsWith(HTTP) || url.startsWith(HTTPS)) {
                view.loadUrl(url);
                return true;
            }

            // 调用第三方应用，防止crash (如果手机上没有安装处理某个scheme开头的url的APP, 会导致crash)
            try {
                // TODO:弹窗提示用户，允许后再调用
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
                return true;
            } catch (Exception e) {
                return true;
            }
        }
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            // 网页开始加载，显示进度条
            progressBar.setProgress(0);
            progressBar.setVisibility(View.VISIBLE);

            // 更新状态文字
            textUrl.setText("加载中...");
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            // 网页加载完毕，隐藏进度条
            progressBar.setVisibility(View.INVISIBLE);

            // 改变标题
            setTitle(webView.getTitle());
            // 显示页面标题
            textUrl.setText(webView.getTitle());
        }
    }

/**
 * 重写 WebChromeClient
 */
private class MyWebChromeClient extends WebChromeClient {
    private final static int WEB_PROGRESS_MAX = 100;

    @Override
    public void onProgressChanged(WebView view, int newProgress) {
        super.onProgressChanged(view, newProgress);

        // 加载进度变动，刷新进度条
        progressBar.setProgress(newProgress);
        if (newProgress > 0) {
            if (newProgress == WEB_PROGRESS_MAX) {
                progressBar.setVisibility(View.INVISIBLE);
            } else {
                progressBar.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onReceivedIcon(WebView view, Bitmap icon) {
        super.onReceivedIcon(view, icon);

        // 改变图标
        webIcon.setImageBitmap(icon);
    }

    @Override
    public void onReceivedTitle(WebView view, String title) {
        super.onReceivedTitle(view, title);

        // 改变标题
        setTitle(title);
        // 显示页面标题
        textUrl.setText(title);
    }
}


    /**
     * 判断字符串是否为URL（https://blog.csdn.net/bronna/article/details/77529145）
     *
     * @param urls 要勘定的字符串
     * @return true:是URL、false:不是URL
     */
    public static boolean isHttpUrl(String urls) {
        boolean isUrl;
        // 判断是否是网址的正则表达式
        String regex = "(((https|http)?://)?([a-z0-9]+[.])|(www.))"
                + "\\w+[.|\\/]([a-z0-9]{0,})?[[.]([a-z0-9]{0,})]+((/[\\S&&[^,;\u4E00-\u9FA5]]+)+)?([.][a-z0-9]{0,}+|/?)";

        Pattern pat = Pattern.compile(regex.trim());
        Matcher mat = pat.matcher(urls.trim());
        isUrl = mat.matches();
        return isUrl;
    }

    /**
     * 获取版本号名称
     *
     * @param context 上下文
     * @return 当前版本名称
     */
    private static String getVerName(Context context) {
        String verName = "unKnow";
        try {
            verName = context.getPackageManager().
                    getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return verName;
    }
}