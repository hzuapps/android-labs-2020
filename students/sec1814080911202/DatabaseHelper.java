package edu.hzuapps.androidlabs.sec1814080911202;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";
    private static final String sql = " CREATE TABLE IF NOT EXISTS `book` " +
            "( id integer primary key autoincrement," +
            "name VARCHAR(10)," +
            "isborrow CHAR(1) )";

    DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory cursorFactory, int version)
    {
        super(context, name, cursorFactory, version);
    }

    public DatabaseHelper(Sec1814080911202Activity sec1814080911202Activity, String db_name, SQLiteDatabase.CursorFactory cursorFactory,int i) {
        super(sec1814080911202Activity, db_name, cursorFactory, i);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "onCreate: ");
        db.execSQL(sql);
        // TODO 创建数据库后，对数据库的操作
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO 更改数据库版本的操作
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        // TODO 每次成功打开数据库后首先被执行
    }
}