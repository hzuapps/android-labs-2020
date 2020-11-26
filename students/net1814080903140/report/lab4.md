#实验四

##  一、实验目标

1.	根据选题要求设计界面布局及控件使用；
2.	布局xml及界面控制操作代码提交并截图；
3.	将应用运行结果截图。（不要做登录注册！）

## 二、实验内容

1.	使用其中一种布局方式，设计所选题目的界面（比如：LinearLayout, RelativeLayout, Adapter, ConstraintLayout）；
2.	通过控件ID获取界面对象，执行相关操作；
3.	实现界面控制的事件处理，例如点击按钮；
4.	操作之后，切换到第二个界面。

## 三、实验步骤

1. 建立一个名为“CityMangeActivity”的Activity,在res/layout目录下对应该Activity的activity_city_mange.xml文件进行布局设置；
 
2. 在activity_city_mange.xml总体采用相对布局的形式，在再这个大布局里面再嵌套一个相对布局（考虑到篇幅原因，这里代码只展示了前面有关布局设计的部分，详细代码请看实验四提交的.xml文件）；
```
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".CityMangeActivity">
    <RelativeLayout
        android:id="@+id/city_top_layout"
        android:layout_width="match_parent"
        android:layout_height="60dp"
        android:background="#F5F5F5">
```

3. 建立一个名为“SearchCityActivity”的Activity,在res/layout目录下对应该Activity的activity_search_city.xml文件进行布局设置；

4. 在ctivity_search_city.xml采用相对布局的形式进行页面设计考虑到篇幅原因，这里代码只展示了前面有关布局设计的部分，详细代码请看实验四提交的.xml文件）；
```
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".SearchCityActivity">
```

5. 在上面步骤新建的两个Activity中，用在XML文件中指定属性值让Android在TextView中显示图片；
![image](https://github.com/bowwran/android-labs-2020/blob/master/students/net1814080903140/reportphoto/4/451.png)
![image](https://github.com/bowwran/android-labs-2020/blob/master/students/net1814080903140/reportphoto/4/452.png)
![image](https://github.com/bowwran/android-labs-2020/blob/master/students/net1814080903140/reportphoto/4/453.png)
![image](https://github.com/bowwran/android-labs-2020/blob/master/students/net1814080903140/reportphoto/4/454.png)

6. 对文件activity_net1814080903140.xml进行相应的修改，并把此文件一起提交给老师。

## 四、实验结果

![image](https://github.com/bowwran/android-labs-2020/blob/master/students/net1814080903140/reportphoto/4/result1.PNG)

## 五、实验心得体会

   本次实验的重点是根据自己的选题对页面进行布局设置，布局的方式比较多，经过学习比对，我选择我认为比较适合我项目设计的相对布局对页面展开设计，实验3中主页面的设计我采取了线性布局和相对布局的方式，在这次实验中我采用的是相对布局。做完实验的体会就是，选择合适的布局才能让界面美观，设计起来也能够事半功倍。