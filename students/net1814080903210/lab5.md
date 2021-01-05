# 一、实验目标

1. 了解Andoid的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储
# 二、实验内容

1. 将数据存储到数据库中
2. 将需要展示的数据从数据库中查询出来

# 三、实验步骤

1. 创建类NewsProvider并继承ContentProvider
2. 将NewsProvider注册到manifests.xml中
```xml
<provider android:authorities="edu.hzuapp.androidlabs.News" android:name=".NewsProvider" />
```
3. NewsProvider实现ContentProvider中的增删改查方法
4. 创建数据库类SQLiteDatabase
5. 创建数据库的帮助类并创建表news
6. 将所需数据循环插入到数据库New中
```java
for(int i=0;i<news.length;i++){
            ContentValues values=new ContentValues();
            values.put(NewsProvider.INTRODUCTION,news[i]);
            values.put(NewsProvider.CONTENT,"暂无内容，后面补充");
            values.put(NewsProvider.IMAGE,image);
            Uri uri = getContentResolver() // 执行插入操作
                    .insert(NewsProvider.CONTENT_URI, values);
        }
```
7. 将需要展示的数据从数据库中查询出来
```java
while(c.moveToNext()) {
            String introduction="";
            String content="";//此页面不展示此内容
            int image=0;
            introduction = c.getString(c.getColumnIndex(NewsProvider.INTRODUCTION));
            content = c.getString(c.getColumnIndex(NewsProvider.CONTENT));
            image = c.getInt(c.getColumnIndex(NewsProvider.IMAGE));
            Map<String, Object> map = new HashMap();
            map.put("introduction", introduction);
            map.put("image", image);
            list.add(map);
        }
```
8. 将数据和适配器SimpleAdapter关联起来
9. 运行显示结果

# 四、实验结果

![result](https://raw.githubusercontent.com/Playerlhh/android-labs-2020/master/students/net1814080903210/lab5_res.png)

# 五、实验心得

&#160; &#160; &#160; &#160;通过这次实验，我成功的将数据存储到数据库中，并将数据从数据库中查询和显示出来。在实验过程中，如果出现数据库已经存在的问题，我们可以通过修改数据库版本号或修改数据库名来解决。注意Provider需要在manifests.xml.中声明。
