package edu.hzuapps.studentapp.until;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DatabaseHelper extends SQLiteOpenHelper {

    private static Integer Version = 1;

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DatabaseHelper(Context context, String course, int version) {
        this(context,course,null,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("创建数据库和表");
        String sql = "create table course(id int primary key,course_name varchar(120),teacher_name varchar(32),class_name varchar(32),num int)";
        db.execSQL(sql);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("更新的版本:"+newVersion);
    }
}
