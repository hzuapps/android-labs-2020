package edu.hzuapps.dao;

import java.util.ArrayList;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import edu.hzuapps.model.*;

public class UserDao {
    private DBOpenHelper dbOpenHelper;// 创建DBOpenHelper对象
    private SQLiteDatabase sqliteDatabase;// 创建SQLiteDatabase对象

    public UserDao(Context context)// 定义构造函数
    {
        dbOpenHelper = new DBOpenHelper(context, null, null, 0);// 初始化DBOpenHelper对象
    }

    // 插入用户数据
    public void dbInsert(String text) {
        sqliteDatabase = dbOpenHelper.getWritableDatabase();// 以读写方法打开数据库，不仅仅是写，getReadableDatabase()是只读
        String sql = "insert into t_user(text,isDel) values (?,0)";

        Object bindArgs[] = new Object[] { text };
        // 执行这条无返回值的sql语句
        sqliteDatabase.execSQL(sql, bindArgs);
    }

    // 求出表中有多少条数据
    public int dbGetUserSize() {
        sqliteDatabase = dbOpenHelper.getWritableDatabase();
        String sql = "select count(*) from t_user where isDel=0";
        Cursor cursor = sqliteDatabase.rawQuery(sql, null);
        if (cursor.moveToNext())// 判断Cursor中是否有数据
        {
            return cursor.getInt(0);// 返回总记录数
        }
        return 0;// 如果没有数据，则返回0
    }





    public ArrayList<User> dbQueryAll() {
        ArrayList<User> userArrayList = new ArrayList<User>();
        sqliteDatabase = dbOpenHelper.getWritableDatabase();
        String sql = "select * from t_user where isDel=0";
        Cursor cursor = sqliteDatabase.rawQuery(sql, null);
        // 游标从头读到尾
        for (cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()) {
            if (cursor.getInt(cursor.getColumnIndex("isDel")) != 1) {
                User user = new User();
                user.setId(cursor.getInt(cursor.getColumnIndex("id")));
                user.setText(cursor.getString(cursor
                        .getColumnIndex("text")));
                userArrayList.add(user);
            }
        }
        return userArrayList;
    }

    // 删除记录，其实是把相应的isDel值从0改1
    public void dbDeleteUser(int id) {
        sqliteDatabase = dbOpenHelper.getWritableDatabase();
        String sql = "update t_user set isDel=1 where id=?";
        Object bindArgs[] = new Object[] { id };
        sqliteDatabase.execSQL(sql, bindArgs);

    }

}