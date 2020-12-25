package edu.hzuapp.androidlabs.sqlitetest2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import static android.content.ContentValues.TAG;

public class Util {

    public void insert(SQLiteDatabase db){
        String sql="insert into student values(1,'ly'),(2,'lq');";
        db.execSQL(sql);
       // db.close();
    }

    public void Query(SQLiteDatabase db){
        String sql="select * from student";
        try{
            Cursor cursor=db.rawQuery(sql,null);
        while(cursor.moveToNext()){
                    String id=cursor.getString(cursor.getColumnIndex("_id"));
                    String sname=cursor.getString(cursor.getColumnIndex("sname"));
                    Log.d(TAG,sname);
                }
       }catch (SQLiteException ex){
            ex.printStackTrace();
        }finally {
       //     cursor.close();
            db.close();
        }
    }
    public void delete(SQLiteDatabase db){
        String sql="delete from student ;";
        db.execSQL(sql);
       // db.close();
    }

}
