package com.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper {

    public DBOpenHelper(Context context, String name, CursorFactory factory, int version) {
        super(context, "SqliteTest.db", null, 1);//向系统申请一个SqliteTest.db文件存这个数据库，其中1是数据库版本。
    }

    @Override
    public void onCreate(SQLiteDatabase sqliteDatabase) {
        String sql=
                "create table if not exists Run("+
                        "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"+
                        "information VARCHAR(255),"+
                        "isDel INTEGER DEFAULT 0"+
                        ")";//如果初次运行，建立一张t_user表，建表的时候注意，自增是AUTOINCREMENT，而不是mysql的AUTO_INCREMENT
        sqliteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        //这里是更新数据库版本时所触发的方法
    }

}
