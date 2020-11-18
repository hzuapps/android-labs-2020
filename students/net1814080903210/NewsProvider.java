package edu.hzuapp.androidlabs.net1814080903210;

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

public class NewsProvider extends ContentProvider {
    static final String PROVIDER_NAME = "edu.hzuapp.androidlabs.News";
    static final String URL = "content://" + PROVIDER_NAME + "/news";
    static final Uri CONTENT_URI = Uri.parse(URL);

    static final String _ID = "_id";
    static final String INTRODUCTION = "introduction";
    static final String CONTENT = "content";
    static final String IMAGE = "image";

    static final int NEWS = 1;
    static final int NEW_ID = 2;

    static final UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME, "news", NEWS);
        uriMatcher.addURI(PROVIDER_NAME, "news/#", NEW_ID);
    }

    // 数据库相关操作
    private SQLiteDatabase db;
    static final String DATABASE_NAME = "New";
    static final String TABLE_BOOKS = "news";
    static final int DATABASE_VERSION = 2;
    static final String CREATE_DB_TABLE =
            " CREATE TABLE " + TABLE_BOOKS +
                    " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " introduction TEXT NOT NULL, " +
                    " content TEXT NOT NULL,"+
                    "image INTEGER  NOT NULL"+
                    ");";

    /**
     * 用于创建数据库的帮助类
     */
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
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOKS);
            onCreate(db);
            // recover data
        }
    }

    private static HashMap<String, String> NEWS_PROJECTION_MAP;

    public NewsProvider() {
    }

    @Override
    public String getType(Uri uri) {switch (uriMatcher.match(uri)){
        case NEWS:
            return "vnd.android.cursor.dir/vnd.example.students";
        case NEW_ID:
            return "vnd.android.cursor.item/vnd.example.students";

        default:
            throw new IllegalArgumentException("Unsupported URI: " + uri);
    }
    }

    // 初始化内容提供器
    @Override
    public boolean onCreate() {
        Context context = getContext(); // Activity
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        this.db = dbHelper.getWritableDatabase(); // insert, update, delete
        return (db == null) ? false : true;
    }

    // 插入|保存一条记录
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long rowID = db.insert(TABLE_BOOKS, "", values);
        if (rowID > 0) {
            Uri _uri = ContentUris.withAppendedId(CONTENT_URI, rowID);
            getContext().getContentResolver().notifyChange(_uri, null);
            return _uri;
        }
        throw new SQLException("无法插入数据 " + uri);
    }

    // 查询记录
    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(TABLE_BOOKS);

        switch (uriMatcher.match(uri)) {
            case NEWS:
                qb.setProjectionMap(NEWS_PROJECTION_MAP);
                break;

            case NEW_ID: // WHERE _id=?
                qb.appendWhere(_ID + "=" + uri.getPathSegments().get(1));
                break;

            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }

        if (sortOrder == null || sortOrder == "") {
            sortOrder = INTRODUCTION;
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
            case NEWS:
                count = db.update(TABLE_BOOKS, values, selection, selectionArgs);
                break;

            case NEW_ID:
                count = db.update(TABLE_BOOKS, values, _ID + " = " + uri.getPathSegments().get(1) +
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
            case NEWS:
                count = db.delete(TABLE_BOOKS, selection, selectionArgs);
                break;

            case NEW_ID:
                String id = uri.getPathSegments().get(1);
                count = db.delete(TABLE_BOOKS, _ID + " = " + id +
                        (!TextUtils.isEmpty(selection) ? " AND (" + selection + ')' : ""), selectionArgs);
                break;

            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }
}
