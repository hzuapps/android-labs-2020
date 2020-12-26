# 一、实验目标
1. 了解Android的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储


# 二、实验内容
存储可采用数据库存储
1. 将应用产生的数据存储到数据库中；
2. 将应用运行结果截图。

# 三、实验步骤
1. 新建ContentProviderhouseActivity用于对控件的操作，控制控件需要做什么功能，主要代码如下：
```
保存房间信息
        findViewById(R.id.button_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thisActivity.savehouse();
            }
        });

        // 加载下一间房
        findViewById(R.id.button_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thisActivity.showNexthouse();
            }
        });

    }

    // 保存房间信息
    private void savehouse() {
        String name = ((EditText) findViewById(R.id.housr_name)).getText().toString();
        String tags = ((EditText) findViewById(R.id.house_tags)).getText().toString();

        // 插入新记录
        ContentValues house = new ContentValues();
        //house.put("name", name); // Map <- Key:Value
        house.put(HouseProvider.NAME, name);
        house.put(HouseProvider.TAGS, tags);

        Uri uri = getContentResolver() // 执行插入操作
                .insert(HouseProvider.CONTENT_URI, house);

        Toast.makeText(getBaseContext(), //
                "保存成功! \n" + uri.toString(), Toast.LENGTH_LONG).show();

        this.showhouseInfo("", ""); // 清除内容
}
 // 随机取1条记录
        int random = (new Random()).nextInt(10);

        if (c.moveToFirst()) {
            String name = "";
            String tags = "";
            int count = 1;
            do {
                name = c.getString(c.getColumnIndex(HouseProvider.NAME));
                tags = c.getString(c.getColumnIndex(HouseProvider.TAGS));
                if (count++ == random) {
                    break;
                }
            } while (c.moveToNext());
            // 显示在界面上
            this.showhouseInfo(name, tags);
        } else {
            Toast.makeText(getBaseContext(), //
                    "没有可显示的房间信息", Toast.LENGTH_LONG).show();
        }


```

2. 新建HouseProvider.java 用于对数据库的操作：创建数据库、建表、对数据库进行增删改查等操作,核心代码如下

```
//创建数据库辅助类
private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

```

```
//初始化内容提供器
 public boolean onCreate() {
        Context context = getContext(); // Activity
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        // 创建可写的数据库（如果没有则新建）
        this.db = dbHelper.getWritableDatabase(); // insert, update, delete
        //db = dbHelper.getReadableDatabase() // query (select)
        return (db == null) ? false : true;
}

```

```
//插入或保存一条记录
 public Uri insert(Uri uri, ContentValues values) {
        long rowID = db.insert(TABLE_HOUSE, "", values);
        if (rowID > 0) {
            Uri _uri = ContentUris.withAppendedId(CONTENT_URI, rowID);
            getContext().getContentResolver().notifyChange(_uri, null);
            return _uri;
        }
        throw new SQLException("无法插入数据 " + uri);
    }
```

```
//查询记录
public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(TABLE_HOUSE);

        switch (uriMatcher.match(uri)) {
            case HOUSE:
                qb.setProjectionMap(BOOKS_PROJECTION_MAP);
                break;

            case HOUSE_ID: // WHERE _id=?
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
```
3. 页面布局，两个文本框，一个输入房间名，一个输入地址，两个按钮，“保存”和“下一间”，点击保存，页面提示保存成功，点击下一间就可以继续输入房间信息。
这些功能的实现在ContentProviderhouseActivity中实现。

# 四、实验结果
![实验结果1](https://github.com/Joanwjk/android-labs-2020/blob/master/students/net1814080903239/sy5.1.png)  
![实验结果2](https://github.com/Joanwjk/android-labs-2020/blob/master/students/net1814080903239/sy5.2.png)
# 五、实验感想
这次实验是存储相关的内容，对我来说是有难度的，在先理解老师的代码后再根据自己的功能修改为自己系统的存储。这次的实验SQLiteOpenHelper帮助类的使用是比较关键的，
两个抽象方法 onCreate() 和 onUpdate()要在帮助类中重写，在 onCreate()中实现数据库的创建，onUpdate()主要用于数据库的升级，此次实验没有用到。
关于数据库的存储还有很多不明白的地方，通过查资料希望可以了解更多。
