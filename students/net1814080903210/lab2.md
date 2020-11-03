
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

1. 创建Net1814080903210Activity、Comment1814080903210Activity、NewsInfo1814080903210Activity
2. 将创建的3个Activity注册到AndroidManifest.xml
3. 在activity_main.xml中创建Button并赋予名为btn的id
4.  在Net1814080903210Activity中通过findViewById方法获取Button
5. 为Button增加点击事件处理
6. 通过Intent实现从Net1814080903210Activity到NewsInfo1814080903210Activity的跳转

# 四、实验结果

![result](https://raw.githubusercontent.com/Playerlhh/android-labs-2020/master/students/net1814080903210/lab2_res.png)

# 五、实验心得

&#160; &#160; &#160; &#160;这次实验，我创建了3个与新闻资讯有关的Activity，需要注意的是除了主Activity以外的Activity都需要手动注册到AndroidManifest.xml，除非利用Android Studio自动创建。如果想要获取组件，需要为组件分配唯一ID。在按钮上增加点击事件处理，再利用Intent便可实现Activity间的跳转。
