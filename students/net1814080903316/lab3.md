# 实验三

## 1.实验目标
1. 了解Android应用中各种资源的概念与使用方法；
2. 掌握在Android应用中使用图片等资源的方法。

## 2.实验内容
1. 在界面上显示至少一张图片（按照自己的题目添加）；
2. 提交res/drawable及图片使用的代码；
3. 提交res/values, res/layout等其他代码；
4. 将应用运行结果截图，放到实验报告中；
5. 点击图片（或按钮）时，打开另一个Activity。

## 3.实验步骤
1. 在res/drawable目录中放入图片。
2. 对主界面net_1814080903316_activity.xml进行布局上的配置。
```
 <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".Net1814080903316Activity">
 </LinearLayout>
```
3. 通过TextView组件实现在主界面上展示图片,通过文件名直接引用drawable中的图片。
```
 <TextView
        android:id="@+id/textView4"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_weight="1"
        android:drawableTop="@drawable/school"
        android:gravity="center"
        android:paddingTop="50dp" />
```
4. 设计方法实现界面的跳转，然后在按钮上应用该方法。
```
        public void goImformation(View view){
            Intent intent=new Intent(this, ImformationActivity.class);
            startActivity(intent);
        }

        public void goTable(View view){
        Intent intent=new Intent(this, TableActivity.class);
        startActivity(intent);
       }
```


## 4.实验结果
![项目图片](https://raw.githubusercontent.com/alllovetaken/android-labs-2020/master/students/net1814080903316/lab2result.PNG)

## 5.实验心得
  这次的实验主要任务是在界面上添加图片，具有添加图片功能的组件有TextView与ImageView两个，其中TextView可以展示文字，所以选择使用该组件并在XML中进行相应的配置。
