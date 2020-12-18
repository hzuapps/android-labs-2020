# 一、实验目标

1. 在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2020/issues ；
2. 根据自选题目，编写一个或多个Activity（主窗口类带上学号前缀，放到自己的Java包下）；
3. 将标题设置为自己的学号+对应的功能或题目；
4. 根据自己选择的题目实现Activity中导航、调用等功能（选做）。

# 二、实验内容

1. 根据自己的选题功能，创建 2-3 个 Activity（界面可以尝试设计）；

- Net123456Activity.java (首页、LAUNCHER、主活动)
- 功能1Activity.java
- 功能2Activity.java
- AndroidManifest.xml

1. 在 Activity 上添加按钮、链接或导航栏，实现各个 Activity 的跳转。

- 在 Net123456Activity.java 添加按钮点击事件处理，实现跳转

# 三、实验步骤

​	1.新建三个Activity，分别对应失物招领的主页、个人页面、发布页面，以及对应的xml文件；

​	![图片1](https://github.com/jaydjxing/android-labs-2020/blob/master/students/net1814080903317/%E7%9B%AE%E5%BD%95%E7%BB%93%E6%9E%84.jpg?raw=true)



​	2.编写xml语法，设计布局，添加跳转图标，然后在AndroidManifest.xml上添加Activity。

![图片2](https://github.com/jaydjxing/android-labs-2020/blob/master/students/net1814080903317/lab2-1.png?raw=true)



```xml
<activity android:name=".controller.activity.foundIt.Net1814080903317FoundItAddActivity" />
<activity android:name=".controller.activity.foundIt.Net1814080903317FoundItMainActivity">
    <intent-filter>
        <action android:name="android.intent.action.MAIN" />

        <category android:name="android.intent.category.LAUNCHER" />
    </intent-filter>
</activity>
<activity android:name=".controller.activity.foundIt.Net1814080903317FoundItMyActivity" />
```

​	3.在主页的Activity上添加跳转按钮，跳转到个人页面，然后在个人页面上添加发布的点击事件，跳转到发布页面。

```java
myIv.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        myStartActivity(Net1814080903317FoundItMainActivity.this,Net1814080903317FoundItMyActivity.class);
    }
});
```

# 四、实验结果

   成功跳转到个人页面：

![图片3](https://github.com/jaydjxing/android-labs-2020/blob/master/students/net1814080903317/lab2-2.png?raw=true)

# 五、实验心得体会

这次的实验难度不大，主要是注意的是跳转的时候，如果没跳转，并且闪退了，一般是AndroidManifest.xml上面没有添加Activity，布局这些要得做好看，得需要一定的经验，所以多加练习，多看看网上别人的优秀的代码。