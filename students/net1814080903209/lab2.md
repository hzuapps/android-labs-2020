# 一、实验目标
1. 创建2-3个与自己选题有关的Activity
2. 利用Intent实现Activity间的跳转

# 二、实验内容
1. 根据功能创建相应的Activity；
2. 编写Activity对应的布局文件；
3. 实现各个Activity之间的跳转;

# 三、实验步骤
1. 利用编辑器中自动创建三个页面Activity和xml文件，主页面和两个功能页面
2. 在AndroidManifest.xml自动添加了添加打开时所需要的权限，并根据自己的情况做了些更改
```xml
  <activity android:name=".CountActivity"></activity>
        <activity android:name=".ShowActivity" />
        <activity android:name=".Net1814080903209Activity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
```
3. 在Net1814080903209Activity中添加两个Activity跳转按钮的代码
```java
    final Net1814080903209Activity thisActivity = this;

        Button btn_count = findViewById(R.id.btn_count);
        btn_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, CountActivity.class);
                thisActivity.startActivity(intent);
            }
        });

        Button btn_show = findViewById(R.id.btn_show);
        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, ShowActivity.class);
                thisActivity.startActivity(intent);
            }
        });
```

# 四、实验结果
![](https://raw.githubusercontent.com/itgopan/android-labs-2020/master/students/net1814080903209/lab2_01.png)
---
![](https://raw.githubusercontent.com/itgopan/android-labs-2020/master/students/net1814080903209/lab2_02.png)

# 五、实验心得
实验主要是实现基本的页面跳转，通过编写Activity中的代码，添加按钮事件，实现利用Intent实现Activity间的跳转，实验比较基础简单。
