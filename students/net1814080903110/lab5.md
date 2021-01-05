# 实验五

## 一、实验目标

1. 了解Andoid的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储

## 二、实验内容

应用数据存储可采用数据库存储。

1. 将应用产生的数据存储到数据库中；
2. 将应用运行结果截图。

## 三、实验步骤
1. 创建数据库帮助类 MainSQLiteOpenHelper,重写OnCreate和onUpgrade函数
```java
public class MainSQLiteOpenHelper extends SQLiteOpenHelper {

    private static final String db_name = "MySchedule";
    private static final int version = 1;
    public MainSQLiteOpenHelper(Context context) {
        super(context, db_name, null, version);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String  sql ="create table schedules(" +
                "id Integer primary key autoincrement," +   
                "scheduleDetail varchar(50)," +
                "time varchar(30)" +
                ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists courses");
        onCreate(db);
    }
}
```
2. 在SettingActivity和Setting2Activity利用Cursor和Intent来进行数据库交互
```java
Cursor cursor = myDatabase.query("schedules", null, null, null, null, null, null);  //查询所有列
```
```java
    private void editSchedule(View v) {
        Intent intent = new Intent(SettingActivity.this,Setting2Activity.class);
        String sch = ((TextView) v).getText().toString().split("：")[1];
        intent.putExtra("schedule",sch);
        startActivity(intent);
    }
```

## 四、实验结果
1. ![lab5.1](https://raw.githubusercontent.com/xyl123580/android-labs-2020/master/students/net1814080903110/lab5.1.png)
2. ![lab5.2](https://raw.githubusercontent.com/xyl123580/android-labs-2020/master/students/net1814080903110/lab5.2.png)
3. ![lab5.3](https://raw.githubusercontent.com/xyl123580/android-labs-2020/master/students/net1814080903110/lab5.3.png)
4. ![lab5.4](https://raw.githubusercontent.com/xyl123580/android-labs-2020/master/students/net1814080903110/lab5.4.png)

## 五、实验心得
  这次实验内容是安卓的存储编程，要利用好SQLiteOpenHelper这个帮助类，刚开始接触的时，这个帮助类还有很多地方需要重写，所以花费了一些事件去理解各个语句的作用，写完帮助类后再去实现数据库的交互就会容易很多。
