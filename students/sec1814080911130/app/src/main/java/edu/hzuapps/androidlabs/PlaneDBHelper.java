package edu.hzuapps.androidlabs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class PlaneDBHelper extends SQLiteOpenHelper {
	static final String ID = "_id";
	static final String NAME = "name";
	static final String SCORE = "score";
	static final String TABLE = "rank";

	public PlaneDBHelper(Context context, String name, CursorFactory factory,
						 int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String sql = "create table if not exists " + TABLE + "(" + ID + " integer primary key," + NAME + " varchar(16),"
				+ SCORE + " varchar(5))";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}

