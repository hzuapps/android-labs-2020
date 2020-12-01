package com.example.miracalfarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.*;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FarmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm);
        initialize();
        ImageButton btu2=(ImageButton)findViewById(R.id.shop);
        final FarmActivity thisActivity=this;
        btu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(FarmActivity.this, StoreActivity.class);
                startActivity(intent);

            }
        });

    }
    public void initialize() {  //读取存档文件中的保存状态，并将状态修改进状态栏，使用内部存储。
        File mainMessage = new File(this.getFilesDir(), "mainmessage.txt");
        if (!mainMessage.exists()){
            try {
                mainMessage.createNewFile();
            } catch (IOException ex) {}
        }
        TextView rank = (TextView) findViewById(R.id.rank);
        TextView bar = (TextView) findViewById(R.id.bar);
        TextView moneytext = (TextView) findViewById(R.id.moneytext);
        BufferedReader br;
        PrintWriter pr;
        String nowline;
        try {
            br = new BufferedReader(new FileReader(mainMessage));
            pr = new PrintWriter(mainMessage);
            nowline = br.readLine();
            System.out.println(nowline + "1");
            if(nowline == null) {
                br.close();
                pr.println("1");
                pr.println("1");
                pr.println("10000");
                pr.close();
                br = new BufferedReader(new FileReader(mainMessage));
                nowline = br.readLine();
            }
            System.out.println(nowline + "2");
            rank.setText(nowline);
            int maxbar =Integer.parseInt(nowline) * 250;
            nowline = br.readLine();
            bar.setText(nowline+"/"+maxbar);
            nowline = br.readLine();
            moneytext.setText(nowline);
        }catch (IOException ex){}


    }
}