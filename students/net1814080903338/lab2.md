# 一、实验目标

1. 创建2-3个与自己选题有关的Activity
2. 利用Intent实现Activity间的跳转

# 二、实验内容

1. 根据功能创建相应的Activity
2. 编写AndroidManifest.xml
3. 编写Activity对应的布局文件
4. 编写Activity的Java代码
5. 使用Intent实现跳转

# 三、实验步骤

1. 将创建的Activity注册到AndroidManifest.xml
2. 在中activity_net1814080903338.xml创建3个Button并赋予ID
3. 通过ID获取Button
4. 为Button增加点击事件处理
5. 利用Intent绑定跳转类
6. 利用startActivity(intent)实现跳转到activity_read.xml、activity_write.xml、activity_revise.xml

# 四、实验结果

![主页面](https://github.com/guo02/android-labs-2020/blob/master/students/net1814080903338/2.PNG)

![写页面](https://github.com/guo02/android-labs-2020/blob/master/students/net1814080903338/3.PNG)

![读页面](https://github.com/guo02/android-labs-2020/blob/master/students/net1814080903338/4.PNG)

![修改页面](https://github.com/guo02/android-labs-2020/blob/master/students/net1814080903338/5.PNG)

# 五、实验心得
本次实验相对来说比较难，学习了button，Intent等。在实验过程中，一开始由于对Intent的错误应用导致APP出现闪退现象，终于在一系列的修改代码后，终于实现了页面间跳转功能。

