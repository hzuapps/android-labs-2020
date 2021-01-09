package edu.hzuapps.logindemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBOpenHelper extends SQLiteOpenHelper {

    //声明数据库db
    private SQLiteDatabase db;

    //构造函数，指明上下文、数据库名、工厂默认空值、版本号为1
    DBOpenHelper(Context context){
        super(context,"db_test",null,1);
        db = getReadableDatabase();
    }

    //重写onCreate()、onUpgrade()方法
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE IF NOT EXISTS user(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "password TEXT," +
                "email TEXT," +
                "phonenum TEXT)"
        );
    }
    //版本适应
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS user");
        onCreate(db);
    }

    //定义增方法
    void add(String name, String password,String phonenum){
        db.execSQL("INSERT INTO user (name,password,email,phonenum) VALUES(?,?,?,?)",new Object[]{name,password,phonenum});
    }


    //使用游标获取数据存放到list容器中
    ArrayList<User> getAllData(){
        ArrayList<User> list = new ArrayList<User>();
        @SuppressLint("Recycle") Cursor cursor = db.query("user",null,null,null,null,null,"name DESC");
        while(cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String phonenum = cursor.getString(cursor.getColumnIndex("phonenum"));
            String password = cursor.getString(cursor.getColumnIndex("password"));

            list.add(new User(name,password,phonenum));
        }
        return list;
    }
}

