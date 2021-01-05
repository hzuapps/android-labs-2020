package edu.hzuapps;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper{
    private static final String CREATE_Character = "create table Character("
        + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
        + "name text,"
        + "profession text,"
        + "level interger,"
        + "ifget integer )";
    private Context mContext;
    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_Character);
        Log.i("create", "create");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
