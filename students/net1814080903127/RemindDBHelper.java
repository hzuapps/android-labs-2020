package edu.hzuapps.androidlabs.net1814080903127;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class RemindDBHelper extends DBHelper{
    public RemindDBHelper(Context context) {
        super(context);
        setTablename("remind");
    }
    public int queryre(SQLiteDatabase sqLiteDatabase)
    {
        int id=0;
        Cursor cursor=sqLiteDatabase.query(tablename,null,null,null,null,null,"id ASC");
        while (cursor.moveToNext())
        {
            id=cursor.getInt(cursor.getColumnIndex("id"));
        }
        //cursor.close();
        //sqLiteDatabase.close();
        return id;
    }
    }

