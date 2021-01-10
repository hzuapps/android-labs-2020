# 实验二：Android组件编程
## 一、实验目标
1.	在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2020/issues
2.	创建2-3个与自己的选题功能相关的Activity

## 二、实验内容
1.	创建自己的Android项目选题，且将项目命名为net+学号
2.	根据自选题在Android Studio中创建多个Activity
3.	实现各个Activity之间的跳转（显式或隐式）

## 三、实验步骤
1.	创建选题#107，编写想要实现的功能：https://github.com/hzuapps/android-labs-2020/issues/107
2.	创建与选题相应的Activity，然后分别添加各个Activity的.xml文件
- Net1814080903240Activity（主界面）
- BindingActivity（绑定家电界面）
- InstallActivity（填写安装家电信息界面）
- EvaluateActivity（评价界面）
3.	将新建的Activity添加到AndroidManifest.xml中
```
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="edu.hzuapps.androidlabs.net1814080903240">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".BindingActivity"/>
        <activity android:name=".InstallActivity"/>
        <activity android:name=".EvaluateActivity"/>
        <activity android:name=".Net1814080903240Activity">

            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```
4.	在build.gradle目录下添加阿里云镜像
```
allprojects {
    repositories {
        google()
        maven{url 'http://maven.aliyun.com/nexus/content/groups/public/'}
    }
}
```
5.	在各个Activity.xml上添加Button等组件，点击事件处理，通过 startActivity(intent)方法实现各个Activity之间的跳转，查看运行效果
6.	在Git Bash上提交实验代码

## 四、实验结果
![创建选题](https://github.com/Clever2app/android-labs-2020/blob/master/students/net1814080903240/lab2_1.png)

![实验结果](https://github.com/Clever2app/android-labs-2020/blob/master/students/net1814080903240/lab2_2.png)

## 五、实验心得
本次实验的内容是Android组件编程，主要学习如何在项目中添加Button等组件，点击事件处理，实现各个Activity之间的跳转。本次实验难度较低，但由于.java文件命名的首字母没有大写被打回，重新修改后顺利完成实验。
