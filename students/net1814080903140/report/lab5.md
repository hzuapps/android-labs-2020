#实验五 Android存储编程

##  一、实验目标

1.	了解Android的存储手段；
2.	掌握Android的文件存储；
3.	掌握Android的数据库存储。

## 二、实验内容

1.	根据自己的选题选择适合的存储方式；
2.	创建数据库；
3.	编写数据库中相关的表，写入相关的存储信息；
4.	编写实现对数据库中的表进行管理的类。

## 三、实验步骤

1. 创建一个类DatabaseBean.java，写入数据库相关的存储信息；
```
public class DatabaseBean {
    private int _id;
    private String city;
    private String content;

    public DatabaseBean() {
    }

    public DatabaseBean(int _id, String city, String content) {
        this._id = _id;
        this.city = city;
        this.content = content;
    }

```
2. 创建数据库，并编写构造方法；

```
public class DBHelper extends SQLiteOpenHelper{

    public DBHelper(Context context){
        super(context,"forecast.db",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
//        创建表的操作
        String sql = "create table info(_id integer primary key autoincrement,city varchar(20) unique not null,content text not null)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
```
3. 创建项目所需要用到的表；

```
 public void onCreate(SQLiteDatabase db) {
//        创建表的操作
        String sql = "create table info(_id integer primary key autoincrement,city varchar(20) unique not null,content text not null)";
        db.execSQL(sql);
    }
```
4. 创建对数据库进行管理的类DBManger.java，实现对数据库的初始化以及对数据库中相关表的查询、增加、删除等操作。（考虑到实验报告的篇幅原因，这里只附上初始化代码，其他代码请看本次实验提交的.java文件）

```
public class DBManager {
    public static SQLiteDatabase database;
    /* 初始化数据库信息*/
    public static void initDB(Context context){
        DBHelper dbHelper = new DBHelper(context);
        database = dbHelper.getWritableDatabase();
    }
```

## 四、实验结果

![image](https://github.com/bowwran/android-labs-2020/blob/master/students/net1814080903140/reportphoto/5/result.png?raw=true)

## 五、实验心得体会

   本次实验是对于安卓开发中数据存储的一个学习，结合自己想要做的项目的实际情况，我采用的是数据库存储的方式来存储数据，在掌握了相关知识的基础上，我完成了本次实验，也学习到一些其他的数据存储方法。