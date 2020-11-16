package edu.hzuapps.androidlabs.sec1814080911106;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import  android.widget.ImageView;

public class Sec1814080911106Activity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mImage;
    private TextView mText;
    private int num;
    private int index;
    private String[] title;
    private int[] images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();


        final Sec1814080911106Activity thisActivity = this;
        Button clockBtn = (Button) findViewById(R.id.button_edit);
        clockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, EditActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initData() {
        title =new String[] {"第1张图片","第2张图片","第3张图片","第4张图片","第5张图片"};
        images =new int[] {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e};

        mImage.setImageResource(images[0]);
        mText.setText(title[0]);

        num = title.length;
        index = 0;
    }

    private void initView() {
        mImage = findViewById(R.id.iv_show);
        mText = findViewById(R.id.tv_show);
        findViewById(R.id.btn_preious).setOnClickListener(this);
        findViewById(R.id.btn_next).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_preious:
                if (index == 0) {
                    index = title.length - 1;
                }else {
                    index--;
                }
                break;
            case R.id.btn_next:
                if (index == 4) {
                    index = 0;
                }else {
                    index++;
                }
                break;
        }
        updateImageAndTitle();
    }


    private void updateImageAndTitle() {
        mImage.setImageResource(images[index]);
        mText.setText(title[index]);
    }


}