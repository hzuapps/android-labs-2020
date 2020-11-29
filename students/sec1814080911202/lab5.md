# 一、实验目的

1. 了解Andoid的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储2.

# 二、实验内容

1. 将应用产生的数据存储到数据库中；
2. 将应用运行结果截图.

# 三、实验步骤

1. 在Sec1814080911202Activity.java 增加以下两个方法操作数据库：
```java
protected void initDatabase(){
        DatabaseHelper dbHelp = new DatabaseHelper(Sec1814080911202Activity.this,
                db_name,null,1);
//        dbHelp.onCreate(db);
        db = dbHelp.getWritableDatabase();

        insert("内网安全攻防");
        insert("web安全攻防");
        insert("SQL注入攻击与防御");
        insert("从0到1：CTFer成长之路");
        insert("逆向工程");

    }


    private void insert(String bookname){
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", bookname);
        contentValues.put("isborrow", "0");
        db.insert(tb_name, null, contentValues);
    }
```

2. 继承SQLiteOpenHelper 的 DatabaseHelper.java：
```java
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";
    private static final String sql = " CREATE TABLE IF NOT EXISTS `book` " +
            "( id integer primary key autoincrement," +
            "name VARCHAR(10)," +
            "isborrow CHAR(1) )";

    DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory cursorFactory, int version)
    {
        super(context, name, cursorFactory, version);
    }

    public DatabaseHelper(Sec1814080911202Activity sec1814080911202Activity, String db_name, SQLiteDatabase.CursorFactory cursorFactory,int i) {
        super(sec1814080911202Activity, db_name, cursorFactory, i);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "onCreate: ");
        db.execSQL(sql);
        // TODO 创建数据库后，对数据库的操作
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO 更改数据库版本的操作
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        // TODO 每次成功打开数据库后首先被执行
    }
}
```


# 四、实验结果

![lab5](https://raw.githubusercontent.com/L1nzSec/android-labs-2020/master/students/sec1814080911202/lab5.png)

# 五、实验心得

本次实验是存储编程，由于项目是图书管理，所以在文件和数据库之间选了数据库进行存储，便于图书的管理。通过上课所学和查阅资料，学会了需要先建立一个继承 SQLiteOpenHelper的类，然后在主activity对数据库进行初始化，即插入预先设置好的几本书。