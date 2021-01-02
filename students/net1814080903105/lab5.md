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
1. 创建一个用于填充数据的xml，有两个TextView；
2. 编写数据库创建、查询、插入相关代码；
```java
public void onClick(View view) {
                String name = textView1.getText().toString();
                String num = editText1.getText().toString();
                try {
                    insertData(db, name, num);
                    Cursor cursor = db.rawQuery("select * from table_info", null);
                    inflateListView(cursor);
                } catch (Exception e) {
                    String sql = "create table table_info(_id integer primary key autoincrement,name varchar(25),num varchar(20))";
                    db.execSQL(sql);
                    insertData(db, name, num);
                    Cursor cursor = db.rawQuery("select * from table_info", null);
                    inflateListView(cursor);
                }
            }
        });

    private void insertData(SQLiteDatabase db, String name, String num) {
        db.execSQL("insert into table_info values (null,?,?)", new String[] { name, num });
    }
```
3. 向ListView填充数据。
```java
    public void inflateListView(Cursor cursor) {
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(ShoppingActivity.this,
                R.layout.activity_splist_view_item, cursor, new String[] { "name", "num" },
                new int[] { R.id.listname, R.id.listnum },
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        lv.setAdapter(adapter);
    }
```

## 四、实验结果
![运行截图](https://github.com/czj-105/android-labs-2020/blob/master/students/net1814080903105/lab5.jpg)

## 五、实验心得
本次实验利用数据库存储，将数据存储在数据库中，并在ListView显示出来。学习了Android的存储手段，熟悉了数据库相关操作的编写。