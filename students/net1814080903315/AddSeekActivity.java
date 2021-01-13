package edu.hzuapps.androidlabs.net1814080903315;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AddSeekActivity extends AppCompatActivity implements View.OnClickListener {
private ImageView mImage;
private  TextView mText;
    private int num;
    private int index;
    private String[] title;
    private int[] images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_seek);
        initView();
        initDate();




    }

    private void initDate() {
        title =new String[]{"第一张图片","第二张图片","第三张图片","第四张图片","第五张图片","第六张图片","第七张图片","第八张图片","第九张图片",};
        images =new int[]{R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i};
        mImage.setImageResource(images[0]);
        mText.setText(title[0]);
        num = title.length;//图片张数
         index =0;
    }

    private void initView(){
        mImage = findViewById(R.id.picture_show);
        mText = findViewById(R.id.tv_show);
        findViewById(R.id.picture_previous).setOnClickListener(this);
        findViewById(R.id.picture_next).setOnClickListener(this);
        }
        @Override
    public void onClick(View view) {
            final AddSeekActivity thisActivity = this;
            switch (view.getId()) {
                case R.id.back:
                    Intent intent = new Intent(thisActivity, Net1814080903315MainActivity.class);//实现第一个跳转
                    startActivity(intent);
                    break;
                case R.id.picture_previous:
                    //上一张图片
                    if (index == 0) {

                        index = title.length - 1;
                    } else {

                        index--;
                    }

                    break;
                case R.id.picture_next:
                    //下一张图片
                    if (index == 8) {

                        index = 0;
                    } else {

                        index++;
                    }

                    break;
            }
            updateImageTitle();
        }
        private void updateImageTitle(){
        mImage.setImageResource(images[index]);
        mText.setText(title[index]);
        }



}