package edu.hzuapps.androidlabs.sec1814080911243;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.annotation.Nullable;

public class FindActivity extends Activity {
    private WebView mWebView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_activity);
        mWebView = findViewById(R.id.web_view);
        mWebView.loadUrl("https://ai.taobao.com/?pid=mm_122614137_346800099_97787150492");
        //mWebView.loadUrl("https://github.com/hzuapps/android-labs-2020");

    }

    @Override
    public void onBackPressed() {
        if (mWebView != null && mWebView.canGoBack())
        {
            mWebView.goBack();
        }
        else{
            super.onBackPressed();
        }

    }


}
