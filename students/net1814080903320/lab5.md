# 实验五
## 一、实验目标
1. 了解Andoid的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储

## 二、实验内容
1. 将应用产生的数据存储到数据库中；
2. 将应用运行结果截图。

## 三、实验步骤
1. 将连接数据库代码添加入项目；
2. 调用代码测试连接情况。

```java
    @Override
    public void onCreate(SQLiteDatabase sqliteDatabase) {
        String sql=
                "create table if not exists Run("+
                        "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"+
                        "information VARCHAR(255),"+
                        "isDel INTEGER DEFAULT 0"+
                        ")";//如果初次运行，建立一张t_user表，建表的时候注意，自增是AUTOINCREMENT，而不是mysql的AUTO_INCREMENT
        sqliteDatabase.execSQL(sql);
    }
```

## 四、实验心得
此次实验难度不大，我的软件还用不到存储功能，但是我还是试着编写了一下。数据库时安卓自带的不用创建，直接写sql语句就行了。
