package com.example.net1814080903206activity;

import android.content.ContentProvider;
import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;

import java.util.HashMap;

public class database extends ContentProvider {
    static final String PROVIDER_NAME = "edu.hzuapps.androidlabs.mk0603";
    static final String URL = "content://" + PROVIDER_NAME + "/customer";
    static final Uri CONTENT_URI = Uri.parse(URL);

    static final String ID = "customer_ID";
    static final String Password = "customer_Password";
    static final String goods1 = "customer_goods1";
    static final int CUSTOMER = 1;
    static final int DATE = 2;

    static final UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME, "customer", CUSTOMER);
        uriMatcher.addURI(PROVIDER_NAME, "customer/#", DATE);

    }
    private SQLiteDatabase db;
    static final String DATABASE_NAME = "user_date";
    static final String TABLE_CUSTOMER = "customer";
    static final int DATABASE_VERSION = 1;
    static final String CREATE_DB_TABLE =
            " CREATE TABLE " + TABLE_CUSTOMER +
                    " (customer_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " customer_Password TEXT NOT NULL, " +
                    " customer_goods1 TEXT );";
    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_DB_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // backup data,
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_CUSTOMER);
            onCreate(db);
            // recover data
        }
    }
    private static HashMap<String, String> BOOKS_PROJECTION_MAP;

    public database() {
    }

    @Override
    public String getType(Uri uri) {switch (uriMatcher.match(uri)){
        case CUSTOMER:
            return "vnd.android.cursor.dir/vnd.example.students";
        case DATE:
            return "vnd.android.cursor.item/vnd.example.students";

        default:
            throw new IllegalArgumentException("Unsupported URI: " + uri);
    }
    }
    @Override
    public boolean onCreate() {
        Context context = getContext(); // Activity
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        // 创建可写的数据库（如果没有则新建）
        this.db = dbHelper.getWritableDatabase(); // insert, update, delete
        //db = dbHelper.getReadableDatabase() // query (select)
        return (db == null) ? false : true;
    }
    // 插入|保存一条记录
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long rowID = db.insert(TABLE_CUSTOMER, "", values);
        if (rowID > 0) {
            Uri _uri = ContentUris.withAppendedId(CONTENT_URI, rowID);
            getContext().getContentResolver().notifyChange(_uri, null);
            return _uri;
        }
        throw new SQLException("无法插入数据 " + uri);
    }
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(TABLE_CUSTOMER);

        switch (uriMatcher.match(uri)) {
            case CUSTOMER:
                qb.setProjectionMap(BOOKS_PROJECTION_MAP);
                break;

            case DATE: // WHERE _id=?
                qb.appendWhere(ID + "=" + uri.getPathSegments().get(1));
                break;

            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }

        if (sortOrder == null || sortOrder == "") {
            sortOrder = Password;
        }
        Cursor c = qb.query(db, projection, selection, selectionArgs, null, null, sortOrder);
        c.setNotificationUri(getContext().getContentResolver(), uri);
        return c;
    }
    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        int count = 0;
        switch (uriMatcher.match(uri)) {
            case CUSTOMER:
                count = db.update(TABLE_CUSTOMER, values, selection, selectionArgs);
                break;

            case DATE:
                count = db.update(TABLE_CUSTOMER, values, ID + " = " + uri.getPathSegments().get(1) +
                        (!TextUtils.isEmpty(selection) ? " AND (" + selection + ')' : ""), selectionArgs);
                break;

            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int count = 0;
        switch (uriMatcher.match(uri)) {
            case CUSTOMER:
                count = db.delete(TABLE_CUSTOMER, selection, selectionArgs);
                break;

            case DATE:
                String id = uri.getPathSegments().get(1);
                count = db.delete(TABLE_CUSTOMER, ID + " = " + id +
                        (!TextUtils.isEmpty(selection) ? " AND (" + selection + ')' : ""), selectionArgs);
                break;

            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }
}

