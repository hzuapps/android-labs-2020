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
1. 创建NoteDatabase用于建立数据表。
![实验截图](https://github.com/H-ao-max/android-labs-2020/blob/master/students/net1814080903137/实验报告截图/5-3.JPG)
2. 创建CRUD对数据进行增删改等操作。

核心代码：

```java
	public Note addNote(Note note){
        ContentValues contentValues=new ContentValues();
        contentValues.put(NoteDatabase.CONTENT,note.getContent());
        contentValues.put(NoteDatabase.TIME,note.getTime());
        contentValues.put(NoteDatabase.MODE,note.getTag());
        long insertID =db.insert(NoteDatabase.TABLE_NAME,null,contentValues);
        note.setId(insertID);
        return note;
    }
```
```java
	 public void removeNote(Note note){
        db.delete(NoteDatabase.TABLE_NAME,NoteDatabase.ID+"="+note.getId(),null);
    }
```

## 四、实验结果
![实验截图](https://github.com/H-ao-max/android-labs-2020/blob/master/students/net1814080903137/实验报告截图/5-1.JPG)

![实验截图](https://github.com/H-ao-max/android-labs-2020/blob/master/students/net1814080903137/实验报告截图/5-2.JPG)

![实验截图](https://github.com/H-ao-max/android-labs-2020/blob/master/students/net1814080903137/实验报告截图/5.JPG)


## 五、实验心得
  这次实验内容是安卓的存储编程，难度还是有的，开始先运行老师给的例子，再看每一个方法的功能，基本能理解存储过程的原理，最后在修改成自己的。