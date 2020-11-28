package edu.hzuapps.androidlabs.Net1814080903110;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MainSQLiteOpenHelper extends SQLiteOpenHelper {

    private static final String db_name = "MySchedule";//自定义的数据库名；
    private static final int version = 1;//版本号,增加则会执行onUpgrade方法?

    public MainSQLiteOpenHelper(Context context) {
        super(context, db_name, null, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String  sql ="create table schedules(" +
                "id Integer primary key autoincrement," +     //id自增,只支持integer不支持int
                "scheduleDetail varchar(50))";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists courses");
        onCreate(db);
    }
}