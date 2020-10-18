package com.example.sec1814080911131activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class First_Activity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frist_layout_activity);
        mWebView = findViewById(R.id.web_view);
        mWebView.loadUrl("https://github.com/hzuapps/android-labs-2020");

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
