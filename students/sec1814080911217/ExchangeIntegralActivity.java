package edu.hzuapps.androidlabs.sec1814080911217;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ExchangeIntegralActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange_integral);
        Toast toast1=Toast.makeText(this,"积分不足，兑换失败",Toast.LENGTH_SHORT);
        Toast toast2=Toast.makeText(this,"兑换成功",Toast.LENGTH_SHORT);
        final Activity thisActivity = this;

        Button Exchange1 = (Button) findViewById(R.id.exchange1);

        View view1 = findViewById(R.id.exchange1);

        Exchange1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view1) {
                if(Sec1814080911217Activity.h>=1000)
                {
                toast2.show();
                try {
                    Sec1814080911217Activity.file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Sec1814080911217Activity.h=Sec1814080911217Activity.h-1000;
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
                    fos.write((result+"兑换英雄瑞文，积分-1000").getBytes());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
                else
                {toast1.show();};
            }

        });
        Button Exchange2 = (Button) findViewById(R.id.exchange2);

        View view2 = findViewById(R.id.exchange2);

        Exchange2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view2) {
                if(Sec1814080911217Activity.h>=800)
                {
                    toast2.show();
                    try {
                        Sec1814080911217Activity.file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Sec1814080911217Activity.h=Sec1814080911217Activity.h-800;
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
                        fos.write((result+"兑换英雄剑圣，积分-800").getBytes());
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else
                {toast1.show();};
            }

        });
        Button Exchange3 = (Button) findViewById(R.id.exchange3);

        View view3 = findViewById(R.id.exchange3);

        Exchange3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view3) {
                if(Sec1814080911217Activity.h>=50)
                {
                    toast2.show();
                    try {
                        Sec1814080911217Activity.file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Sec1814080911217Activity.h=Sec1814080911217Activity.h-50;
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
                        fos.write((result+"兑换双倍经验卡，积分-50").getBytes());
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else
                {toast1.show();};
            }

        });
    }
}