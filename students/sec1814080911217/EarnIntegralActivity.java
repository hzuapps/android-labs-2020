package edu.hzuapps.androidlabs.sec1814080911217;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class EarnIntegralActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earn_integral);
        Toast toast1=Toast.makeText(this,"签到成功",Toast.LENGTH_SHORT);
        Toast toast2=Toast.makeText(this,"分享成功",Toast.LENGTH_SHORT);
        Toast toast3=Toast.makeText(this,"观看成功",Toast.LENGTH_SHORT);
        final Activity thisActivity = this;

        Button Earn1 = (Button) findViewById(R.id.earn1);

        View view1 = findViewById(R.id.earn1);

        Earn1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view1) {
                try {
                    Sec1814080911217Activity.file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                toast1.show();
                Sec1814080911217Activity.h=Sec1814080911217Activity.h+10;
                try {
                    FileInputStream fis = new FileInputStream(Sec1814080911217Activity.file);
                    StringBuilder stringBuilder = new StringBuilder(); // 动态字符串
                    InputStreamReader inputStreamReader =
                            new InputStreamReader(fis, StandardCharsets.UTF_8);
                    BufferedReader br = new BufferedReader(inputStreamReader);
                    String line = null;
                    while ((line = br.readLine()) != null) {
                        stringBuilder.append(line + "\n");
                    }
                    br.close();
                    String result = stringBuilder.toString();
                    FileOutputStream fos = new FileOutputStream(Sec1814080911217Activity.file);
                    fos.write((result+"完成签到，积分+10").getBytes());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                }
        });

        Button Earn2 = (Button) findViewById(R.id.earn2);

        View view2 = findViewById(R.id.earn2);

        Earn2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view2) {
                try {
                    Sec1814080911217Activity.file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                toast2.show();
                Sec1814080911217Activity.h=Sec1814080911217Activity.h+20;
                try {
                    FileInputStream fis = new FileInputStream(Sec1814080911217Activity.file);
                    StringBuilder stringBuilder = new StringBuilder(); // 动态字符串
                    InputStreamReader inputStreamReader =
                            new InputStreamReader(fis, StandardCharsets.UTF_8);
                    BufferedReader br = new BufferedReader(inputStreamReader);
                    String line = null;
                    while ((line = br.readLine()) != null) {
                        stringBuilder.append(line + "\n");
                    }
                    br.close();
                    String result = stringBuilder.toString();
                    FileOutputStream fos = new FileOutputStream(Sec1814080911217Activity.file);
                    fos.write((result+"完成分享，积分+20").getBytes());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Button Earn3 = (Button) findViewById(R.id.earn3);

        View view3 = findViewById(R.id.earn3);

        Earn3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view1) {
                try {
                    Sec1814080911217Activity.file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                toast3.show();
                Sec1814080911217Activity.h=Sec1814080911217Activity.h+20;
                try {
                    FileInputStream fis = new FileInputStream(Sec1814080911217Activity.file);
                    StringBuilder stringBuilder = new StringBuilder(); // 动态字符串
                    InputStreamReader inputStreamReader =
                            new InputStreamReader(fis, StandardCharsets.UTF_8);
                    BufferedReader br = new BufferedReader(inputStreamReader);
                    String line = null;
                    while ((line = br.readLine()) != null) {
                        stringBuilder.append(line + "\n");
                    }
                    br.close();
                    String result = stringBuilder.toString();
                    FileOutputStream fos = new FileOutputStream(Sec1814080911217Activity.file);
                    fos.write((result+"完成观看，积分+20").getBytes());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}