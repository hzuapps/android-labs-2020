package edu.hzuapps.androidlabs.sec1814080911202;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ManageActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView mImage;
    private TextView mText;
    private int index;
    private int num;
    private String[] title;
    private int[] images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);
        bookShow();
        bookText();
    }


    private void bookText() {
        title =new String[] {"内网安全攻防","web安全攻防","SQL注入攻击与防御","从0到1：CTFer成长之路","逆向工程"};
        images =new int[] {R.drawable.lan_sec_awd,R.drawable.web_sec_awd,R.drawable.sqli_awd,R.drawable.from_0_to_1,R.drawable.reverse};

        mImage.setImageResource(images[0]);
        mText.setText(title[0]);

        num = title.length;
        index = 0;
    }

    private void bookShow() {
        mImage = findViewById(R.id.boot_show);
        mText = findViewById(R.id.book_text);
        findViewById(R.id.btn_left).setOnClickListener(this);
        findViewById(R.id.btn_right).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_left:
                if (index == 0) {
                    index = title.length - 1;
                }else {
                    index--;
                }
                break;
            case R.id.btn_right:
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