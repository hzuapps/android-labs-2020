package edu.hzuapps.androidlabs.net1814080903125;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    static final String table_name = "_diary";

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,int version){
        super(context,name,null,version);
    }

    /**
     * 创建数据库表 _diary
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table "+table_name+"("+
                    "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "title VARCHAR(20) NOT NULL,"+
                    "password VARCHAR(20), "+
                    "content VARCHAR(255) NOT NULL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
