# 实验四：Android界面设计编程

## 一、实验目标
1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。

##  二、实验内容
1. 使用其中一种布局方式，设计所选题目的界面，建议用LinearLayout。
LinearLayout, RelativeLayout, Adapter, ConstraintLayout (自学)
2. 通过控件ID获取界面对象，执行相关操作
3. 实现界面控件的事件处理，例如点击按钮

## 三、实验步骤
1. 在activity_net1814080903342.xml 、activity_search_id.xml , activity_search_id.xml主要做线性布局
2. 通过控件ID获取界面对象，执行相关操作：
 ```XML
android:id="@+id/my_button"
```
```Java
findViewById(R.id.my_button);
```
3. 添加Spinner控制，并配置其ID
```java
final Spinner spinner1 = findViewById(R.id.Spinner);
  ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this,R.array.date,R.layout.support_simple_spinner_dropdown_item);
  spinner1.setAdapter(adapter1);
    }
 ```

 ```xml
 android:id="@+id/Spinner"
```     

## 四、实验结果及截图
![主界面截图](https://raw.githubusercontent.com/momingyu1/android-labs-2020/master/students/net1814080903342/lab4-1.jpg)  
![查询账户功能界面截图](https://raw.githubusercontent.com/momingyu1/android-labs-2020/master/students/net1814080903342/lab4-2.jpg)  
![查询交易记录功能界面截图](https://raw.githubusercontent.com/momingyu1/android-labs-2020/master/students/net1814080903342/lab4-3.jpg)
## 五、实验心得
经过本次实验，学会了如何在界面设计布局和一些控制的使用，做起来有点难，主要是对几个布局不熟悉。
