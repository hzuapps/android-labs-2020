# 实验五 
  ## 一、实验目标 
1. 了解Android的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储 

  ## 二、实验内容 
1. 将应用产生的数据存储到数据库中；
2. 将应用运行结果截图。

  ## 三、实验步骤 
 1. 重新设计BuyActivity用于对控件的操作，控制控件需要做什么功能，主要代码如下：

```java
// 保存图书信息
findViewById(R.id.button_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thisActivity.saveBook();
            }
        });
// 加载下一本书
        findViewById(R.id.button_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thisActivity.showNextBook();
            }
        });
    }
    // 保存图书信息
    private void saveBook() {
        String name = ((EditText) findViewById(R.id.book_name)).getText().toString();
        String tags = ((EditText) findViewById(R.id.book_tags)).getText().toString();
// 插入新记录
        ContentValues book = new ContentValues();
//book.put("name", name); // Map <- Key:Value
        book.put(ContentProviderOfBooks.NAME, name);
        book.put(ContentProviderOfBooks.TAGS, tags);
        Uri uri = getContentResolver() // 执行插入操作
                .insert(ContentProviderOfBooks.CONTENT_URI, book);
        Toast.makeText(getBaseContext(), //
                "保存成功! \n" + uri.toString(), Toast.LENGTH_LONG).show();
        this.showBookInfo("", ""); // 清除内容
    }
    private void showBookInfo(String name, String tags) {
        ((EditText) findViewById(R.id.book_name)).setText(name);
        ((EditText) findViewById(R.id.book_tags)).setText(tags);
    }
    // 显示下一本书
    private void showNextBook() {
//String URL = ContentProviderOfBooks.URL;
        Cursor c = getContentResolver() // 执行查询
                .query(ContentProviderOfBooks.CONTENT_URI, null, null, null, null);
// 随机取1条记录
        int random = (new Random()).nextInt(10);
        if (c.moveToFirst()) {
            String name = "";
            String tags = "";
            int count = 1;
            do {
                name = c.getString(c.getColumnIndex(ContentProviderOfBooks.NAME));
                tags = c.getString(c.getColumnIndex(ContentProviderOfBooks.TAGS));
                if (count++ == random) {
                    break;
                }
            } while (c.moveToNext());
// 显示在界面上
            this.showBookInfo(name, tags);
        } else {
            Toast.makeText(getBaseContext(), //
                    "没有可显示的图书!", Toast.LENGTH_LONG).show();
        }
    }
}
```

  2. 新建ContentProviderOfBooks.java 用于对数据库的操作：创建数据库、建表、对数据库进行增删改查等操作,核心代码如下
```java
//创建数据库辅助类
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
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOKS);
            onCreate(db);
        }
    }
    private static HashMap<String, String> BOOKS_PROJECTION_MAP;
    public ContentProviderOfBooks() {
    }
    @Override
    public String getType(Uri uri) {switch (uriMatcher.match(uri)){
        case BOOKS:
            return "vnd.android.cursor.dir/vnd.example.students";
        case BOOK_ID:
            return "vnd.android.cursor.item/vnd.example.students";
        default:
            throw new IllegalArgumentException("Unsupported URI: " + uri);
    }
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
    // 初始化内容提供器
    @Override
    public boolean onCreate() {
        Context context = getContext();
        DatabaseHelper dbHelper = new DatabaseHelper(context);
// 创建可写的数据库（如果没有则新建）
        db = dbHelper.getWritableDatabase();
//db = dbHelper.getReadableDatabase()
        return (db == null) ? false : true;
    }
    // 查询记录
    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(TABLE_BOOKS);
        switch (uriMatcher.match(uri)) {
            case BOOKS:
                qb.setProjectionMap(BOOKS_PROJECTION_MAP);
                break;
            case BOOK_ID:
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
            case BOOKS:
                count = db.update(TABLE_BOOKS, values, selection, selectionArgs);
                break;
            case BOOK_ID:
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
            case BOOKS:
                count = db.delete(TABLE_BOOKS, selection, selectionArgs);
                break;
            case BOOK_ID:
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
```

  3. 页面布局，两个文本框，一个输入书名，一个输入金额，两个按钮，“保存”和“下一本”，点击保存，页面提示保存成功，点击下一间就可以继续输入书本信息。 这些功能的实现在BuyActivity中实现。

   ## 四、实验结果 
  ![实验截图](https://raw.githubusercontent.com/39-chen/android-labs-2020/master/students/net1814080903339/5.jpg)


   ## 五、实验心得 
 这次实验是存储相关的内容,SQLiteOpenHelper帮助类的使用是比较关键的， 在 onCreate()中实现数据库的创建，onUpdate()主要用于数据库的升级，此次实验没有用到。 
