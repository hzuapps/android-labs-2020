package com.example.foundit.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/**
 * author: djx
 * created on: 2020/11/22 21:40
 * description:
 */
public class DBOpenHelper extends SQLiteOpenHelper {
    public DBOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        //调用构造方法，向系统申请一个SqliteTest.db文件存这个数据库，其中1是数据库版本
        super(context, "foundit", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        ///如果初次运行，建立一张t_user表，建表的时候注意，自增是AUTOINCREMENT，而不是mysql的AUTO_INCREMENT
        String sql="create table if not exists t_info(" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"+
                "type VARCHAR(255),"+
                "state VARCHAR(255),"+
                "content VARCHAR(255)"+
                ");";

        db.execSQL(sql);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //这里是更新数据库版本时所触发的方法
    }
}
