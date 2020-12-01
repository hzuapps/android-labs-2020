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

1. 在AndroidManifest.xml中添加provider：

```xml
<provider android:name=".ContentProviderOfMyView" 
android:authorities="edu.hzuapps.androidlabs.ContentProviderOfMyView"/>  
```

2. 创建ContentProviderOfMyView类，该类负责与数据库进行交互；核心代码如下：

```java
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
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_MyView);
            onCreate(db);
        }
    } 
```

3. 在MyViewActivity类中调用ContentProviderOfMyView中的方法，向ContentProviderOfMyView中传送封装好的实体类，然后接收返回的数据，再写到应用界面。

## 四、实验结果

![avatar](/students/net1814080903226/Lab5-1.jpg)
![avatar](/students/net1814080903226/Lab5-2.jpg)

## 五、实验心得

　　本次实验是Android存储编程，实验难度适中。以前有做过web项目开发，写法比较类似。ContentProviderOfMyView类是负责与数据库进行交互的类，其中实现了增
删改查方法，使用了创建数据库的帮助类SQLiteOpenHelper的子类进行创建数据库。整体的实验思路是，MyViewActivity类将界面输入的信息封装给user实体，然后调用ContentProviderOfMyView中
的执行方法user实体的相应信息传送过去，然后再将返回的数据在MyViewActivity上进行处理和显示。
