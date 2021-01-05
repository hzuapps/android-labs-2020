package edu.hzuapps.androidlabs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Net1814080903226Activity extends AppCompatActivity {

    private ImageView imageView;

    private ViewPager vp;
    private MyAdapter myAdapter;
    private List<ImageView> imgList;
    // 获取到图片
    private Integer[] img = { R.drawable.hzup1, R.drawable.hzup2,
            R.drawable.hzup3, R.drawable.hzup4 };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Net1814080903226Activity thisActivity = this;
        Button button = (Button) findViewById(R.id.myview);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, MyViewActivity.class);
                thisActivity.startActivity(intent);
            }
        });

        Button button2 = (Button) findViewById(R.id.message);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, MessageActivity.class);
                thisActivity.startActivity(intent);
            }
        });


        vp = (ViewPager) findViewById(R.id.vp);

        imgList = new ArrayList<ImageView>();

        // 将图片放到集合中
        for (int i = 0; i < img.length; i++) {
            ImageView iv = new ImageView(this);
            iv.setImageResource(img[i]);
            // 将图片全屏显示
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            imgList.add(iv);
        }

        // 进行适配
        myAdapter = new MyAdapter(imgList);
        vp.setAdapter(myAdapter);


    }

}