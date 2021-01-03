# 实验五
## 一、实验目标
1. 了解Andoid的存储手段；
2. 掌握Android的文件存储；
3. 掌握Android的数据库存储。

## 二、实验内容
1. 根据选题要求使用文件存储；
2. 应用数据存储可采用数据库存储；
3. 将应用产生的数据存储到数据库中；
4. 将应用运行结果截图。

## 三、实验步骤
1. 创建显示作业信息和完成进度的列表，新添加的作业进度默认未完成；
2. 编写数据库创建、查询、插入相关代码；
```java
protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check1814080903138);
        mLV = findViewById(R.id.mlist);
        db = SQLiteDatabase.openOrCreateDatabase(this.getFilesDir().toString()
                + "/my.db3", null);
        String hwname = getIntent().getStringExtra("data");
        String hwfinish = "未完成";
        System.out.println(hwname);
        System.out.println(hwfinish);
        try {

                insertData(db, hwname, hwfinish);

                Cursor cursor = db.rawQuery("select * from tb_hw", null);

                inflateListView(cursor);


        } catch (Exception e) {
                String sql = "create table tb_hw(_id integer primary key autoincrement,db_hwname varchar(20),db_hwfinish varchar(50))";
                db.execSQL(sql);

                insertData(db, hwname, hwfinish);

                Cursor cursor = db.rawQuery("select * from tb_hw", null);

                inflateListView(cursor);
            }
        }

```
3. 向数据库中插入数据
```java
  private void insertData (SQLiteDatabase db, String hwname, String hwfinish){
      db.execSQL("insert into tb_hw values (null,?,?)", new String[]{hwname,
              hwfinish});
      System.out.println("------------------");
  }
```
4. 向ListView填充数据。
```java
    @SuppressLint("NewApi")
    public void inflateListView (Cursor cursor){
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(Check1814080903138Activity.this,
                    R.layout.mytextview, cursor, new String[]{"db_hwname",
                    "db_hwfinish"},
                    new int[]{R.id.list_hwname, R.id.lsit_hwfinish},
                    CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);


            mLV.setAdapter(adapter);

    }
```

## 四、实验结果
![运行截图](https://github.com/linjhong/android-labs-2020/blob/master/students/net1814080903138/lab5.png)

## 五、实验心得
本次实验使用数据库进行存储作业信息。先将数据存储在数据库中，通过按钮跳转到下一个页面并在ListView显示出来。学习了Android的存储手段，熟悉了数据库相关操作的编写。
