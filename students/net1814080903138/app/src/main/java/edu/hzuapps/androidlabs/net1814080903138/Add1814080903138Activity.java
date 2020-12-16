package edu.hzuapps.androidlabs.net1814080903138;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Add1814080903138Activity extends AppCompatActivity {
    private Button mBtn_add,mBtn_check,mBtn_show;
    private EditText medittext;
    public static Intent intent;
    private SharedPreferences mSharePreferences;
    private SharedPreferences.Editor mEditor;
    private TextView mTvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add1814080903138);
        final Add1814080903138Activity thisActivity = this;
        mTvShow = findViewById(R.id.tv_show);
        mBtn_check = (Button)findViewById(R.id.btn_check);
        mBtn_add = findViewById(R.id.btn_add);
        mBtn_show = findViewById(R.id.btn_show);
        medittext = findViewById(R.id.homework_name);

        mSharePreferences = this.getSharedPreferences("data",MODE_PRIVATE);//文件名称，模式:通常使用MORE_PRIVATE
        mEditor = mSharePreferences.edit();

        intent = new Intent();



        mBtn_check.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                intent.setClass(thisActivity, Check1814080903138Activity.class);
                thisActivity.startActivity(intent);

            }
        });

        mBtn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                intent.putExtra("data",medittext.getText().toString());

                Toast.makeText(Add1814080903138Activity.this,"已成功添加",Toast.LENGTH_SHORT).show();
                mEditor.putString("name",medittext.getText().toString());
                mEditor.apply();

            }
        });
        mBtn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvShow.setText(mSharePreferences.getString("name",""));
            }
        });

    }
    }