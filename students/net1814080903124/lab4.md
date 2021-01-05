# 实验四
## 一、实验目标
1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。

## 二、实验内容
1. 使用一种布局方式设计界面；
2. 通过控件ID获取界面对象，执行相关操作：
3. 实现界面控件的事件处理;
4. 操作之后，切换到第二个界面。

## 三、实验步骤
1. 主界面采用ConstraintLayout布局，主要设置了3个button，并使用OnClickListener事件监听器以及openActivity方法实现各界面的跳转
```java
       openActivity(Activity activity, Class activityClass) {
        Intent intent = new Intent(activity, activityClass);
        activity.startActivity(intent);
    }
```
2. 子界面均采用相对布局，并使用自定义适配器ImageAdapter，并设置OnClickListener来实现点击后的后续功能。
3. 在子界面的XML文件中使用GridView来实现将图片指定大小排列在界面中。
```xml
<GridView
    android:id="@+id/grid_view"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    android:columnWidth="100dp"
    android:gravity="center"
    android:horizontalSpacing="10dp"
    android:numColumns="auto_fit"
    android:stretchMode="columnWidth"
    android:verticalSpacing="10dp"
    android:alpha="0.9"
    >
</GridView>
```



## 四、实验结果
![适配器](https://github.com/SJ4real/android-labs-2020/blob/master/students/net1814080903124/lab4_1.png)
![运行截图](https://github.com/SJ4real/android-labs-2020/blob/master/students/net1814080903124/lab4_2.png)
![GridView](https://github.com/SJ4real/android-labs-2020/blob/master/students/net1814080903124/lab4_3.png)

## 五、实验心得
本次实验主要是实现了界面的设计，使用了GridView把项目的基本界面设计完成，后续还需要在界面中添加一些组件以及将点击后的功能完善。
