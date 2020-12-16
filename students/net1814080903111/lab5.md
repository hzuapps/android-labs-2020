# 一、实验目标
1. 了解Andoid的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储

# 二、实验内容
1. 将应用产生的数据存储到数据库中；
2. 将应用运行结果截图。

# 三、实验步骤
1. 定义好数据库的配置信息
```
    static final String db_name = "RecordDB";
    static final String tb_name = "RecordTB";
    SQLiteDatabase db;
    Cursor c;
```
2. 在数据库中创建一个记录表，包含签到的年月和日期，代码如下：
```
db = openOrCreateDatabase(db_name, Context.MODE_PRIVATE,null);  //有则访问 没则创建
        String createTable = "CREATE TABLE IF NOT EXISTS " +
                tb_name +
                "(yearmonth VARCHAR (6) not null," +
                " day VARCHAR (2) not null )" ;
        db.execSQL(createTable);
```
3.在签到按钮的点击事件中添加存储数据代码：
```
        ContentValues cv = new ContentValues(2);
        cv.put("yearmonth",yearmonth);
        cv.put("day",day);
        db.insert(tb_name,null,cv);
```
# 四、实验结果
### 签到界面未签到情况
![签到界面](https://raw.githubusercontent.com/JC527/android-labs-2020/master/students/net1814080903111/lab5_1.png)
### 签到界面已签到情况
![签到界面2](https://raw.githubusercontent.com/JC527/android-labs-2020/master/students/net1814080903111/lab5_2.png)
### 查看签到情况界面
![查看签到情况](https://raw.githubusercontent.com/JC527/android-labs-2020/master/students/net1814080903111/lab5_3.png)
# 五、实验心得
这次实验使用SQLite数据库对应用数据进行存储管理。
