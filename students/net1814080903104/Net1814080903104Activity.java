package edu.hzuapps;


import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Net1814080903104Activity extends AppCompatActivity {

    DatabaseHelper mySql = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySql= new DatabaseHelper(this,"Character",null,5);
        final Net1814080903104Activity thisActivity = this;

        Button button = (Button) findViewById(R.id.button_open);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(thisActivity,GetReward.class);
                thisActivity.startActivity(intent);
            }
        });


        Button button1 = (Button) findViewById(R.id.button_search);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //创建角色表
                SQLiteDatabase db = mySql.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("id","1");
                values.put("name","钟南");
                values.put("profession","极诣 狂战士");
                values.put("level",100);
                values.put("ifget",0);
                db.insert("Character", null, values);
                values.clear();
                values.put("id","2");
                values.put("name","胤");
                values.put("profession","极诣 剑魂");
                values.put("level",100);
                values.put("ifget",0);
                db.insert("Character",null,values);
                //跳转到领取奖励界面
                Intent intent = new Intent(thisActivity,SearchMess.class);
                thisActivity.startActivity(intent);
            }
        });
    }
}