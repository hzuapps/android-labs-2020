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

            Cursor cursor = db.rawQuery(("select id from bookList where addr=\""+addr+"\""),null);
            cursor.moveToFirst();
            for (int i=0;i<chapter.size();i++){
                String chapter_table = "book"+cursor.getInt(0)+"chapter"+i;
                create_table = "create table if not exists "+chapter_table+"(page integer)";
                db.execSQL(create_table);
                for (int j =0;j<chapter.get(i).size();j++){
                    cv = new ContentValues(1);
                    cv.put("page",chapter.get(i).get(j));
                    db.insert(chapter_table,null,cv);
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
        String table = "book"+id+"chapter";
        for (int i=0;i<chapterNum;i++){
            ArrayList<Integer> tem = new ArrayList<>();
            select.replace(0,select.length(),"select page from ");
            select.append(table);
            select.append(i+"");
            cursor = db.rawQuery(select.toString(),null);
            cursor.moveToFirst();
            for (int j =0;j<cursor.getCount();j++){
                tem.add(cursor.getInt(cursor.getColumnIndex("page")));
                cursor.moveToNext();
            }
            arrayLists.add(tem);
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
