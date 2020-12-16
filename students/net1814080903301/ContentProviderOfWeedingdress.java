package edu.hzuapps.net1814080903301;
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

public class ContentProviderOfWeedingdress extends ContentProvider {

    static final String PROVIDER_NAME = "edu.hzuapps.androidlabs.Weddingdress";
    static final String URL = "content://" + PROVIDER_NAME + "/Weedingdress";
    static final Uri CONTENT_URI = Uri.parse(URL);

    static final String _ID = "_id";
    static final String NAME = "name";
    static final String TAGS = "tags";

    static final int DRESS = 1;
    static final int DRESS_ID = 2;

    static final UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME, "dress", DRESS);
        uriMatcher.addURI(PROVIDER_NAME, "dress/#", DRESS_ID);
    }

    // 数据库相关操作
    private SQLiteDatabase db;
    static final String DATABASE_NAME = "Weddingdress";
    static final String TABLE_DRESS = "dress";
    static final int DATABASE_VERSION = 1;
    static final String CREATE_DB_TABLE =
            " CREATE TABLE " + TABLE_DRESS +
                    " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " name TEXT NOT NULL, " +
                    " tags TEXT NOT NULL);";

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
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_DRESS);
            // backup data, recover data
            onCreate(db);
        }
    }

    private static HashMap<String, String> DRESS_PROJECTION_MAP;

    public ContentProviderOfWeedingdress() {
    }

    @Override
    public String getType(Uri uri) {switch (uriMatcher.match(uri)){
        case DRESS:
            return "vnd.android.cursor.dir/vnd.example.students";
        case DRESS_ID:
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
        // 创建可写的数据库（如果没有则新建）
        this.db = dbHelper.getWritableDatabase(); // insert, update, delete
        //db = dbHelper.getReadableDatabase() // query (select)
        return (db == null) ? false : true;
    }

    // 插入|保存一条记录
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long rowID = db.insert(TABLE_DRESS, "", values);
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
        qb.setTables(TABLE_DRESS);

        switch (uriMatcher.match(uri)) {
            case DRESS:
                qb.setProjectionMap(DRESS_PROJECTION_MAP);
                break;

            case DRESS_ID:
                qb.appendWhere(_ID + "=" + uri.getPathSegments().get(1));
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
            case DRESS:
                count = db.update(TABLE_DRESS, values, selection, selectionArgs);
                break;

            case DRESS_ID:
                count = db.update(TABLE_DRESS, values, _ID + " = " + uri.getPathSegments().get(1) +
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
            case DRESS:
                count = db.delete(TABLE_DRESS, selection, selectionArgs);
                break;

            case DRESS_ID:
                String id = uri.getPathSegments().get(1);
                count = db.delete(TABLE_DRESS, _ID + " = " + id +
                        (!TextUtils.isEmpty(selection) ? " AND (" + selection + ')' : ""), selectionArgs);
                break;

            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }
}