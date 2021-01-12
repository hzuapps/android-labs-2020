package edu.hzuapps.androidlabs.net1814080903240;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class InstallActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_install);

        //获取网络图片url，用Glide.load加载该网络图片进入该布局
        ImageView img = (ImageView) findViewById(R.id.photo);

        Glide.with(this).load("https://ss2.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/news/crop=4,12,1254,753;w=638/sign=984a2d9c0df41bd5ce1cb2b46ceeadfa/7a899e510fb30f24a7f326b4cb95d143ad4b0318.jpg").into(img);
    }
}
