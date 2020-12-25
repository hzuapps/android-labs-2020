# 一、实验目标
1. 掌握数据库操作方法
2. 掌握界面设计方法
3. 了解更改app桌面图标方法

# 二、实验内容
1. 增加笔记的删除功能
2. 解决输入较长文本时单个item高度不固定问题
3. 更改应用图标

# 三、实验步骤
1. 在数据库操作类写删除数据的方法
```java
    public void delete(SQLiteDatabase sqLiteDatabase, int id) {
        sqLiteDatabase.delete(tablename, "id=?", new String[]{id + ""});
        //sqLiteDatabase.close();
    }
```
2. 给单个item设置长按事件，长按弹出对话框确认删除
```java
textList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                itemID=list.get(position).getId();
                new AlertDialog.Builder(_this)
                        .setTitle("长按删除")
                        .setMessage("确定删除")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                DBHelper db=new DBHelper(_this);
                                sqLiteDatabase=db.getReadableDatabase();
                                db.delete(sqLiteDatabase,itemID);
                                refresh();
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }).create().show();
                return true;
            }
        });
```
3. 解决输入较长文本时单个item高度不固定问题，布局文件加入一行属性：
```xml
android:minHeight="79dp"
```

# 四、实验结果
![lab6](https://github.com/cxcx75/android-labs-2020/tree/master/students/net1814080903127/lab6.png)
# 五、实验心得
本次实验增加了删除功能，写相应的删除方法，再在主界面单条笔记上设置点击事件即可，删除后主界面刷新笔记，以此去掉主界面已经删除的笔记。单条item布局高度不固定问题通过上网查资料后，加入最大、最小高度的属性调整即可，至于桌面图标，导入图标，在AndroidManifest.xml配置就行。
