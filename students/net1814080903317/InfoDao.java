package com.example.foundit.model.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.service.autofill.UserData;

import com.example.foundit.model.bean.Info;
import com.example.foundit.utils.DBOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * author: djx
 * created on: 2020/11/22 22:22
 * description:
 */
public class InfoDao {
    private DBOpenHelper dbOpenHelper;//创建DBOpenHelper对象
    private SQLiteDatabase sqLiteDatabase;//创建SqlLiteDataBase

    //定义构造函数
    public InfoDao(Context context){
        // 初始化DBOpenHelper对象
        dbOpenHelper=new DBOpenHelper(context,null,null,0);
    }
    //插入用户数据
    public void  dbInsert(String type,String state,String content){
        // 以读写方法打开数据库，不仅仅是写，getReadableDatabase()是只读
        sqLiteDatabase=dbOpenHelper.getWritableDatabase();
        String sql="insert into t_info(type,state,content) values(?,?,?);";
        // 传递过来的username与password分别按顺序替换上面sql语句的两个?，自动转换类型，下同，不再赘述
        Object bindArgs[] = new Object[] { type, state,content };
        // 执行这条无返回值的sql语句
        sqLiteDatabase.execSQL(sql,bindArgs);
    }
    //求出表中有多少条数据
    public int dbGetInfoSize(){
        sqLiteDatabase=dbOpenHelper.getWritableDatabase();
        String sql="select count(*) from t_info;";
        Cursor cursor=sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToNext()) {
            //判断Cursor中是否有数据
            return cursor.getInt(0);//返回总记录数
        }
        return 0;
    }

    //查询所有用户
    public List<Info> dbSelectAllInfos(){
        sqLiteDatabase=dbOpenHelper.getWritableDatabase();
        List<Info> infoList=new ArrayList<>();
        String sql="select * from t_info;";
        Cursor cursor=sqLiteDatabase.rawQuery(sql,null);
        while (cursor.moveToNext()) {
            //判断Cursor中是否有数据
            //如果有用户，则把查到的值填充这个用户实体
            Info info=new Info();
            info.setId(cursor.getInt(cursor.getColumnIndex("id")));
            info.setType(cursor.getString(cursor.getColumnIndex("type")));
            info.setState(cursor.getString(cursor.getColumnIndex("state")));
            info.setContent(cursor.getString(cursor.getColumnIndex("content")));
            infoList.add(info);
        }
        return infoList;
    }



}
