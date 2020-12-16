# 实验五 Android存储编程

## 一、实验目标

1. 了解Andoid的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储

## 二、实验内容

应用数据存储可采用数据库存储。

1. 将应用产生的数据存储到数据库中；
2. 将应用运行结果截图。

## 三、实验步骤

1. 创建DatabaseHelper类，该类负责与数据库进行交互；核心代码如下：

```java
package edu.hzuapps.androidlabs.myContreller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.IOException;
import java.util.ArrayList;

public class DatabaseHelper {
    SQLiteDatabase db;
    static DatabaseHelper dh;
    public static DatabaseHelper getData(){
        if (dh==null){
            dh = new DatabaseHelper();
        }
        return dh;
    }
    public void setSQL(Context context, String dbName){
        db = context.openOrCreateDatabase(dbName,context.MODE_PRIVATE,null);
    }
    public void addBook(String name, String author, String image, String addr, int history, ArrayList<ArrayList<Integer>> chapter){
        int chapterNum = chapter.size();
        ContentValues cv;
        String create_table;
        createBookListTable();
        if (db.rawQuery(("select * from bookList where addr=\""+addr+"\""),null).getCount()==0){
            cv = new ContentValues(6);
            cv.put("name",name);
            cv.put("author",author);
            cv.put("image",image);
            cv.put("addr",addr);
            cv.put("history",history);
            cv.put("chapterNum",chapterNum);
            db.insert("bookList",null,cv);

            create_table = "create table if not exists bookChapter ( id integer," +
                    "chapter integer," +
                    "page integer)";
            db.execSQL(create_table);

            Cursor cursor = db.rawQuery(("select id from bookList where addr=\""+addr+"\""),null);
            cursor.moveToFirst();
            int id = cursor.getInt(cursor.getColumnIndex("id"));

            for (int i=0;i<chapter.size();i++){
                for (int j =0;j<chapter.get(i).size();j++){
                    cv = new ContentValues(3);
                    cv.put("id",id);
                    cv.put("chapter",i);
                    cv.put("page",chapter.get(i).get(j));
                    db.insert("bookChapter",null,cv);
                }
            }
        }
    }
    public ArrayList<Book> initbook(Context context) throws IOException {
        createBookListTable();
        ArrayList<Book> bookList = new ArrayList<Book>();
        Cursor cursor = db.rawQuery("select * from bookList",null);
        cursor.moveToFirst();
        for (int i = 0;i<cursor.getCount();i++){
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String author = cursor.getString(cursor.getColumnIndex("author"));
            String image = cursor.getString(cursor.getColumnIndex("image"));
            String addr = cursor.getString(cursor.getColumnIndex("addr"));
            int history = cursor.getInt(cursor.getColumnIndex("history"));
            cursor.moveToNext();
            Book book = new Book(name,author,image,addr,context);
            book.setId(id);
            book.setNowChapter(history);
            book.setInitState(true);
            bookList.add(book);
        }
        return bookList;
    }
    private void createBookListTable(){
        String create_table = "create table if not exists bookList("+
                "id integer primary key autoincrement,"+
                "name varchar(32)," +
                "author varchar(32)," +
                "image varchar(64)," +
                "addr varchar(64)," +
                "history integer," +
                "chapterNum integer)";
        db.execSQL(create_table);
    }
    public ArrayList<ArrayList<Integer>> getChapter(int id){
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>();
        StringBuilder select = new StringBuilder();
        select.append("select chapterNum from bookList where id="+id);
        Cursor cursor = db.rawQuery(select.toString(),null);
        cursor.moveToFirst();
        int chapterNum = cursor.getInt(cursor.getColumnIndex("chapterNum"));
        cursor = db.rawQuery("select chapter,page from bookChapter where id = "+id,null);
        cursor.moveToFirst();
        for (int i=0;i<chapterNum;i++) {
            ArrayList<Integer> tem = new ArrayList<>();
            arrayLists.add(tem);
        }
       for (int i =0;i<cursor.getCount();i++){
           int chapter = cursor.getInt(cursor.getColumnIndex("chapter"));
           arrayLists.get(chapter).add(cursor.getInt(cursor.getColumnIndex("page")));
           cursor.moveToNext();
       }
        return arrayLists;
    }
    public Boolean bookExist(String addr){
        Cursor cursor = db.rawQuery("select id from bookList where addr="+"\""+addr+"\"",null);
        if (cursor.getCount()==0)
            return false;
        else
            return true;
    }
    public int getId(String addr){
        Cursor cursor = db.rawQuery("select id from bookList where addr="+"\""+addr+"\"",null);
        cursor.moveToFirst();
        int id = cursor.getInt(cursor.getColumnIndex("id"));
        return id;
    }
    public void updateHistory(int id,int history){
        ContentValues cv = new ContentValues(1);
        cv.put("history",history);
        db.update("bookList",cv,"id=?",new String[]{id+""});
    }
    public void test(Context context){
        context.deleteDatabase("novel");
    }

}

```

2. DatabaseHelper为单例模式，在需要用到的数据库的地方直接使用getData()获得数据库实例，通过定义的函数进行数据库操作。

## 四、实验结果

![SQLite效果截图](https://raw.githubusercontent.com/xiaohei504/image/master/lab5(1).png))

## 五、实验心得

　　本次实验使用SQLite作为存储手段，将对小说的txt文件进行处理过的信息存储到本地，但是功能完成时发现SQLite的存储特别耗费性能，效率很低，储存时需要耗费大量的时间去处理，而一本小说需要存储的信息又非常多，这与我使用的SQLite的初衷相违背，最后通过使用线程的方式去解决这个问题，让SQLite在后台运行，程序继续执行其他程序。