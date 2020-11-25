package com.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


public class RunDao {
    private static DBOpenHelper dbOpenHelper;// 创建DBOpenHelper对象
    private static SQLiteDatabase sqliteDatabase;// 创建SQLiteDatabase对象

    public RunDao(Context context)// 定义构造函数
    {
        dbOpenHelper = new DBOpenHelper(context, null, null, 0);// 初始化DBOpenHelper对象
    }

    // 插入用户数据
    public static void dbInsert(String information) {
        sqliteDatabase = dbOpenHelper.getWritableDatabase();// 以读写方法打开数据库，不仅仅是写，getReadableDatabase()是只读
        String sql = "insert into run(information,isDel) values (?,?,0)";
        Object bindArgs[] = new Object[] { information };
        // 执行这条无返回值的sql语句
        sqliteDatabase.execSQL(sql, bindArgs);
    }


}
