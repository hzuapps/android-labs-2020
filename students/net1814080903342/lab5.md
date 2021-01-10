# 一、实验目标
1. 了解Android的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储


# 二、实验内容
存储可采用数据库存储
1. 将应用产生的数据存储到数据库中；
2. 将应用运行结果截图。

# 三、实验步骤
1. 新建ContentProviderActivity.java，添加按钮点击事件处理，主要代码如下：
 ```
 // 保存交易记录
        findViewById(R.id.button_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thisActivity.saveBook();
            }
        });

        // 加载下一个交易记录
        findViewById(R.id.button_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thisActivity.showNextBook();
            }
        });
```
```
    // 保存交易记录
    private void saveBook() {
        String name = ((EditText) findViewById(R.id.trading_name)).getText().toString();
        String tags = ((EditText) findViewById(R.id.trading_tags)).getText().toString();

        // 插入新记录
        ContentValues book = new ContentValues();
        book.put(TradingProvider.NAME, name);
        book.put(TradingProvider.TAGS, tags);

        Uri uri = getContentResolver() // 执行插入操作
                .insert(TradingProvider.CONTENT_URI, book);

        Toast.makeText(getBaseContext(), //
                "保存成功! \n" + uri.toString(), Toast.LENGTH_LONG).show();

        //this.showBookInfo("", ""); // 清除内容
    }

    private void showBookInfo(String name, String tags) {
        ((EditText) findViewById(R.id.trading_name)).setText(name);
        ((EditText) findViewById(R.id.trading_tags)).setText(tags);
    }

    // 显示下一个交易记录
    private void showNextBook() {
        //String URL = ContentProviderOfBooks.URL;
        Cursor c = getContentResolver() // 执行查询
                .query(TradingProvider.CONTENT_URI, null, null, null, null);

        // 随机取1条记录
        int random = (new Random()).nextInt(10);

        if (c.moveToFirst()) {
            String name = "";
            String tags = "";
            int count = 1;
            do {
                name = c.getString(c.getColumnIndex(TradingProvider.NAME));
                tags = c.getString(c.getColumnIndex(TradingProvider.TAGS));
                if (count++ == random) {
                    break;
                }
            } while (c.moveToNext());
            // 显示在界面上
            this.showBookInfo(name, tags);
        } else {
            Toast.makeText(getBaseContext(), //
                    "没有可显示的交易记录!", Toast.LENGTH_LONG).show();
        }
    }
}
```

2. 新建TradingProvider.java ,对数据库进行操作,主要代码如下

```
 // 数据库相关操作
    private SQLiteDatabase db;
    static final String DATABASE_NAME = "bank";
    static final String TABLE_Trading = "trading";
    static final int DATABASE_VERSION = 1;
    static final String CREATE_DB_TABLE =
            " CREATE TABLE " + TABLE_Trading +
                    " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " name TEXT NOT NULL, " +
                    " tags TEXT NOT NULL);";
```
```
 // 用于创建数据库的帮助类
    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

```
```
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
```
3. 新建activity_content_provider.xml,做了个相对布局，主要有两个EditText，两个Button，功能在ContentProviderActivity实现

# 四、实验结果
![实验结果截图](https://raw.githubusercontent.com/momingyu1/android-labs-2020/master/students/net1814080903342/lab5.jpg)  
# 五、实验感想
这个实验对我来说挺有难度，但跟着老师的思路与代码，总算做出来了，但是对于数据库存储这个方面的内容还是挺有待加强。
