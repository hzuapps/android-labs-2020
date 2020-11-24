# 实验二

## 一、实验目标

1. 创建选题
2. 编写Activity
3. 实现Activity中的功能

## 二、实验内容

1. 在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2020/issues ；
2. 根据自选题目，编写一个或多个Activity；
3. 将标题设置为自己的学号+对应的功能或题目；
4. 根据自己选择的题目实现Activity中导航、调用等功能。

## 三、实验步骤

1. 在github的Issues中创建宠物app，列出功能

   + 交流分享社区
   + 养宠知识库
   + 养宠疑难解答

2. 在Android Studio创建Activity

   + Sec1814080911239MainActivity（首页）
   + KnowledgeActivity（养宠知识库）
   + ShareActivity（交流分享社区）
   + SolveActivity（养宠疑难解答）
   + SplashActivity（启动界面）

3. 在activity_main.xml上添加三个按钮，在Sec1814080911239MainActivity.java添加按钮点击事件，跳转到对应界面

   ```java
   myBtn_one = (Button)findViewById(R.id.button);
           myBtn_one.setOnClickListener(new View.OnClickListener(){
               @Override
               public void onClick(View view){
                   Intent intent = new Intent(thisActivity,ShareActivity.class);
                   thisActivity.startActivity(intent);
                   thisActivity.finish();
               }
           });
   ```

## 四、实验结果

![按钮](E:\Users\10489\Desktop\study\安卓开发\图\图\button.png)

图1. 按钮

![启动界面](E:\Users\10489\Desktop\study\安卓开发\图\图\SplashActivity.png)

图2. 启动界面

![](E:\Users\10489\Desktop\study\安卓开发\图\图\MainActivity.png)

图3. 首页

![交流分享社区](E:\Users\10489\Desktop\study\安卓开发\图\图\ShareActivity.png)

图4. 交流分享社区

![知识库](E:\Users\10489\Desktop\study\安卓开发\图\图\KnowledgeActivity.png)

图5. 知识库

![疑难解答](E:\Users\10489\Desktop\study\安卓开发\图\图\SolveActivity.png)

图6. 疑难解答

## 五、实验心得体会

​	本次实验主要是实验页面的跳转，点击按钮，跳转到相应的页面，因此要为每个按钮赋予id的属性，这样才能在Sec1814080911239MainActivity.java类里使用findViewById(R.id.button)方法找到对应的按钮，实现页面跳转。

​	一个Activity对应一个页面，因此所有Activity都要在AndroidMainfest.xml文件里，如：<activity android:name=".Sec1814080911239MainActivity" />，不然在跳转页面的时候会发生闪退。

​	AndroidMainfest.xml文件中的

```java
<activity android:name=".SplashActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
</activity>
```

表示将SplashActivity设置为启动时的第一个页面。