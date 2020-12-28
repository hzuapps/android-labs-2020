# 一、实验目标
1. 了解Andoid的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储  
# 二、实验内容
1. 将应用产生的数据存储到数据库中；
2. 将应用运行结果截图。  
# 三、实验步骤
1. 创建类DatabaseHelper.java继承SQLiteOpenHelper，实现SQLite数据库操作，创建表。
```
  String sql = "create table comments(name varchar(20),time varchar(20),content varchar(20),head integer)";
  db.execSQL(sql);
```
2. 修改类Comment1814080903202Activity.java，创建DatabaseHelper对象，封装查询及显示方法query()，重写按钮发送代码为写入数据库。
```
  //创建对象
  private DatabaseHelper databaseHelper = new DatabaseHelper(this,"comment.db",null,1);
```
```
  //query()查询数据库数据的对象
  SQLiteDatabase db = databaseHelper.getReadableDatabase();
  Cursor cursor = db.query("comments",null,null,null,null,null,null);
```
```
  //按钮发送写入数据库的对象
  SQLiteDatabase db = databaseHelper.getWritableDatabase();
  ContentValues values = new ContentValues();
```
# 四、实验结果
![lab5_1](https://github.com/tillsunrise/android-labs-2020/blob/master/students/net1814080903202/lab5_1.png)
![lab5_2](https://github.com/tillsunrise/android-labs-2020/blob/master/students/net1814080903202/lab5_2.png)
![lab5_3](https://github.com/tillsunrise/android-labs-2020/blob/master/students/net1814080903202/lab5_3.png)
# 五、实验心得
这次实验根据我自己APP的需求，我选择了数据库存储，以前没有接触过SQLite，所以一开始不知道从何下手去结合自己的APP，学习和构思后才完成了代码的修改完善。
