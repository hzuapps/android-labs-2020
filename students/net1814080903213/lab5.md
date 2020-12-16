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

1. 修改build.gradle，打算使用官方的 Room 组件将数据保存到本地数据库

在dependencies加入下列内容

```gradle
// Room
def room_version = "2.2.5"
implementation "androidx.room:room-runtime:$room_version"
annotationProcessor "androidx.room:room-compiler:$room_version"
```

2. 创建关于 Word 的 Dao 实体，相当于创建一个 Word 的数据库表，用于存储相应的数据

[![DdrmrV.png](https://s3.ax1x.com/2020/11/25/DdrmrV.png)](https://imgchr.com/i/DdrmrV)

3. 针对以上 Word 实体，需要定义一个 Dao 接口文件才能完成对实体的访问，接口中也包含相应的查询、插入等数据库操作方法

[![DdrdaD.png](https://s3.ax1x.com/2020/11/25/DdrdaD.png)](https://imgchr.com/i/DdrdaD)

4. 定义完实体和 Dao 之后，需要进行数据库的初始化

[![DdrzW9.png](https://s3.ax1x.com/2020/11/25/DdrzW9.png)](https://imgchr.com/i/DdrzW9)

5. 最后在 Activity 或 Fragment 的 onCreate 中获取之前创建过的数据库对象

[![DdsUln.png](https://s3.ax1x.com/2020/11/25/DdsUln.png)](https://imgchr.com/i/DdsUln)

6. 将 WordListFragment 中之前的显示假数据更改为从数据库中获取数据

[![Dds7fH.png](https://s3.ax1x.com/2020/11/25/Dds7fH.png)](https://imgchr.com/i/Dds7fH)

## 四、实验结果

[![DdyU4e.png](https://s3.ax1x.com/2020/11/25/DdyU4e.png)](https://imgchr.com/i/DdyU4e)

## 五、实验心得

　　本次实验主要使用了官方推荐的 Room 组件来进行本地数据库存储交互，和老师上课所讲的 SQLite 完全不同。但是总体上来说 Room 更加先进，更加抽象好用，所以按照官方教程来配置还是比较顺利的。最后遇到一些空指针的报错，也通过查阅 StackOverflow 等网站成功解决了。

