package edu.hzuapps.myapplication;

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

public class Database extends ContentProvider {

    static final String PROVIDER_NAME = "edu.hzuapps.androidlabs.Library";
    static final String URL = "content://" + PROVIDER_NAME + "/information";
    static final Uri CONTENT_URI = Uri.parse(URL);

    static final String ID = "edid";
    static final String NAME = "edname";
    static final String CLASS = "edclass";

    static final int INFORMATION = 1;
    static final int INFORMATION_ID = 2;

    static final UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME, "informations", INFORMATION);
        uriMatcher.addURI(PROVIDER_NAME, "informations/#", INFORMATION_ID);
    }

    // 数据库相关操作
    private SQLiteDatabase db;

    static final String DATABASE_NAME = "Student_Information";
    static final String TABLE_STUDENTS = "student";
    static final int DATABASE_VERSION = 2;
    static final String CREATE_DB_TABLE =
            " CREATE TABLE " + TABLE_STUDENTS + " (edid INTEGER PRIMARY KEY AUTOINCREMENT, edname VARCHAR(20), edclass VARCHAR(20));";

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
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENTS);
            onCreate(db);
        }
    }

    private static HashMap<String, String> INFORMATIONS_PROJECTION_MAP;

    public Database() {
    }

    @Override
    public String getType(Uri uri) {switch (uriMatcher.match(uri)){
        case INFORMATION:
            return "vnd.android.cursor.dir/vnd.example.students";
        case INFORMATION_ID:
            return "vnd.android.cursor.item/vnd.example.students";

        default:
            throw new IllegalArgumentException("Unsupported URI: " + uri);
    }
    }

    // 插入|保存一条记录
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long rowID = db.insert(TABLE_STUDENTS, "", values);
        if (rowID > 0) {
            Uri _uri = ContentUris.withAppendedId(CONTENT_URI, rowID);
            getContext().getContentResolver().notifyChange(_uri, null);
            return _uri;
        }
        throw new SQLException("无法插入数据： ");
    }

    // 初始化内容提供器
    @Override
    public boolean onCreate() {
        Context context = getContext();
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        // 创建可写的数据库（如果没有则新建）
        this.db = dbHelper.getWritableDatabase();
        //db = dbHelper.getReadableDatabase()
        return (db == null) ? false : true;
    }

    // 查询记录
    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(TABLE_STUDENTS);

        switch (uriMatcher.match(uri)) {
            case INFORMATION:
                qb.setProjectionMap(INFORMATIONS_PROJECTION_MAP);
                break;

            case INFORMATION_ID:
                qb.appendWhere(ID + "=" + uri.getPathSegments().get(1));
                break;

            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }

        if (sortOrder == null || sortOrder == "") {
            sortOrder = NAME;
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
            case INFORMATION:
                count = db.update(TABLE_STUDENTS, values, selection, selectionArgs);
                break;

            case INFORMATION_ID:
                count = db.update(TABLE_STUDENTS, values, ID + " = " + uri.getPathSegments().get(1) +
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
            case INFORMATION:
                count = db.delete(TABLE_STUDENTS, selection, selectionArgs);
                break;

            case INFORMATION_ID:
                String id = uri.getPathSegments().get(1);
                count = db.delete(TABLE_STUDENTS, ID + " = " + id +
                        (!TextUtils.isEmpty(selection) ? " AND (" + selection + ')' : ""), selectionArgs);
                break;

            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

}
