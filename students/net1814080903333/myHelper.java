package edu.hzuapps.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class myHelper extends SQLiteOpenHelper {
    private SQLiteDatabase db;
    static final String DATABASE_NAME = "TeachingbarImformation";
    static final int DATABASE_VERSION = 1;
    public myHelper(@Nullable Context context) {

        super(context,DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE StuImformation(stuname VARCHAR(20), courses VARCHAR(20), classtime VARCHAR(20))");
        db.execSQL("CREATE TABLE TimeAndMoney(teachername VARCHAR(20), stuname VARCHAR(20), totaltimes VARCHAR(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
