# 实验五

## 一、实验目标

1. 了解Andoid的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储

## 二、实验内容

应用数据存储可采用数据库存储。

1. 将应用产生的数据存储到数据库中；
2. 将应用运行结果截图。

## 三、实验步骤
1. 创建数据库帮助类 DatabaseHelper.java,重写OnCreate和onUpgrade函数
```java
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

```
2. 在AddDiaryActivity.java中实现数据库的插入
```java
DatabaseHelper dbHelper = new DatabaseHelper(AddDiaryActivity.this,"my_diary",null,1);
SQLiteDatabase db = dbHelper.getWritableDatabase();

ContentValues values = new ContentValues();
values.put("title",title.getText().toString());
values.put("content",content.getText().toString());

db.insert("_diary",null,values);
```

## 四、实验结果
![lab5.1](https://github.com/zkw55/android-labs-2020/blob/master/students/net1814080903125/lab5(1).png)

![lab5.2](https://github.com/zkw55/android-labs-2020/blob/master/students/net1814080903125/lab5(2).png)

## 五、实验心得
  这次实验内容是安卓的存储编程，通过使用SQLite数据库实现数据的增删改查，对该数据库的基本使用有了一定的了解，结合之前也学习过MySQL，对安卓的数据库编程能很快上手。
