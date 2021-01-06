package edu.hzuapps.androidlabs.net1814080903115;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BrowseActivity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brouse);

            textView=findViewById(R.id.tv_show);
            //设置一下最多能显示几行
            textView.setMaxLines(16);
            //一定要设置文本的移动方式
            textView.setMovementMethod(ScrollingMovementMethod.getInstance());
//        Button btnBack = (Button) findViewById(R.id.button_back);
//        View view = findViewById(R.id.button_back);
//
//        btnBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(BrowseActivity.this, Net1814080903115Activity.class);
//                BrowseActivity.this.startActivity(intent);
//                //thisActivity.startActivityForResult(intent, 2016);
//            }
//        });
    }
//    public void save(String text){
//        FileOutputStream out = null;
//        BufferedWriter writer = null;
//        try {
//            //文件名为"data", 操作方式为追加
//            out = openFileOutput("data", Context.MODE_APPEND);
//            writer = new BufferedWriter(new OutputStreamWriter(out));
//            writer.write(text);
//        }catch (IOException e){
//            e.printStackTrace();
//        }finally {
//            try {
//                if(writer != null){
//                    writer.close();
//                }
//            }catch (IOException e){
//                e.printStackTrace();
//            }
//        }
//    }
//    public String load(){
//        FileInputStream in = null;
//        BufferedReader reader = null;
//        StringBuilder content = new StringBuilder();
//        try {
//            //指定读取文件"data"
//            in = openFileInput("data");
//            reader = new BufferedReader(new InputStreamReader(in));
//            String line = "";
//            while ((line = reader.readLine()) != null){
//                content.append(line);  //将数据放在Builder
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }finally {
//            if (reader != null){
//                try {
//                    reader.close();
//                }catch (IOException e){
//                    e.printStackTrace();
//                }
//            }
//        }
//        return content.toString();
//    }

}