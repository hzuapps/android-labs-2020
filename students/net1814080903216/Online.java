package edu.hzuapps.androidlabs.net1814080903216;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Online extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online);
        TextView t1 = (TextView)findViewById(R.id.test1);
        String s1 = "<font color='blue'><b>进入网站，有更多好看的视频哦：</b></font><br>";
        s1 += "<a href = 'http://www.bilibili.com'>哔哩哔哩网站</a>";
        t1.setText(Html.fromHtml(s1));
        t1.setMovementMethod(LinkMovementMethod.getInstance());
    }
}