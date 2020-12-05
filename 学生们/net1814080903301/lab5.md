# 实验五：Android存储编程

## 一、实验目标

1. 了解Andoid的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储

## 二、实验内容

1. 将应用产生的数据保存到文件存储中；
2. 使用文件外部存储方式
3. 运行结果截图。

## 三、实验步骤

1. 建立自己用于保存婚纱相关信息的Activity

```java
public class ContentProviderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);

        final ContentProviderActivity thisActivity = this;

        // 保存婚纱信息
        findViewById(R.id.button_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thisActivity.saveDress();
            }
        });

        // 加载下一套婚纱信息
        findViewById(R.id.button_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thisActivity.showNextDress();
            }
        });

    }

    // 保存婚纱信息
    private void saveDress() {
        String name = ((EditText) findViewById(R.id.dress_name)).getText().toString();
        String tags = ((EditText) findViewById(R.id.dress_tags)).getText().toString();

        // 插入新记录
        ContentValues dress = new ContentValues();
        dress.put(ContentProviderOfWeedingdress.NAME, name);
        dress.put(ContentProviderOfWeedingdress.TAGS, tags);
        Uri uri = getContentResolver() // 执行插入操作
                .insert(ContentProviderOfWeedingdress.CONTENT_URI, dress);

        Toast.makeText(getBaseContext(), //
                "保存成功! \n" + uri.toString(), Toast.LENGTH_LONG).show();

        this.showDressInfo("", ""); // 清除内容
    }

    private void showDressInfo(String name, String tags) {
        ((EditText) findViewById(R.id.dress_name)).setText(name);
        ((EditText) findViewById(R.id.dress_tags)).setText(tags);
    }

    // 显示下一套婚纱
    private void showNextDress() {
        Cursor c = getContentResolver() // 执行查询
                .query(ContentProviderOfWeedingdress.CONTENT_URI, null, null, null, null);

        // 随机取1条记录
        int random = (new Random()).nextInt(10);

        if (c.moveToFirst()) {
            String name = "";
            String tags = "";
            int count = 1;
            do {
                name = c.getString(c.getColumnIndex(ContentProviderOfWeedingdress.NAME));
                tags = c.getString(c.getColumnIndex(ContentProviderOfWeedingdress.TAGS));
                if (count++ == random) {
                    break;
                }
            } while (c.moveToNext());
            // 显示在界面上
            this.showDressInfo(name, tags);
        } else {
            Toast.makeText(getBaseContext(), //
                    "没有可显示的婚纱!", Toast.LENGTH_LONG).show();
        }
    }
}

```

2. 创建java类ContentProviderOfWeedingdress实现用于操作数据库

```java
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
```

3. 对activity_content_provider.xml进行一些页面的设计

```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="edu.hzuapps.net1814080903301.ContentProviderActivity">

    <TextView
        android:id="@+id/Weedingdress_title"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textSize="30dp"
        android:text="婚纱信息"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true"/>

    <ImageView
        android:id="@+id/dress_cover"
        android:layout_width="256px"
        android:layout_height="256px"
        android:src="@drawable/myimage"
        android:layout_below="@+id/Weedingdress_title"
        android:layout_centerHorizontal="true"/>

    <EditText
        android:id="@+id/dress_name"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="婚纱套餐名"
        android:layout_below="@+id/dress_cover"
        android:layout_centerHorizontal="true"/>

    <EditText
        android:id="@+id/dress_tags"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="婚纱备注信息"
        android:layout_below="@+id/dress_name"
        android:layout_centerHorizontal="true"/>

    <Button
        android:id="@+id/button_save"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="保存"
        android:layout_below="@+id/dress_tags"
        android:layout_alignParentLeft="true"/>

    <Button
        android:id="@+id/button_next"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="下一套婚纱"
        android:layout_below="@+id/dress_tags"
        android:layout_alignParentRight="true"/>

</RelativeLayout>
```

## 四、运行结果及截图

![实验五图片](https://github.com/hzuapps/android-labs-2020/blob/master/students/net1814080903301/5.jpg)

## 五、实验心得

本次实验内容主要是去了解安卓的存储机制，我是在老师给的代码上修改让它变成我自己App所需页面的，因为老师的刚好是保存图书信息，我的APP刚好是保存婚纱信息，在了解完相关知识后，进行修改，添加。虽然在修改调试的过程出现了一些问题，但是大都在csdn上有解决方案。最后实验就顺利完成了
