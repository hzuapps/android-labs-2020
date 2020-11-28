# 实验四：Android界面设计编程

## 一、实验目标

1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。**（不要做登录注册！）**

##  二、实验内容
1. 使用一种布局方式设计界面；
2. 通过控件ID获取界面对象，执行相关操作：

## 三、实验步骤

1. 在主界面 Net1814080903303Activity 中嵌入一个垂直的LinearLayout；
2. 将3个Button按钮嵌入垂直的LinearLayout；
3. 通过控件ID获取界面对象以class_button 为例

```XML
android:id="@+id/my_button"
```

```Java
findViewById(R.id.my_button);
```
4. 运用Spinner 控件，并配置其ID。

```java

final Spinner spinner1 = findViewById(R.id.spinner1);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this,R.array.class_name,R.layout.support_simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
 ```
 
 ```xml
  android:id="@+id/spinner1"
```
        
## 四、实验结果及截图
![spinner控件](https://raw.githubusercontent.com/tiamo669/android-labs-2020/master/students/net1814080903303/spinner.jpg)
![主界面LinearLayout布局下三个按钮](https://raw.githubusercontent.com/tiamo669/android-labs-2020/master/students/net1814080903303/button.jpg)
## 五、实验心得
本次实现主要是设计界面布局及控件使用，完善界面点击操作事件，同时我还添加了spinner控件，使界面更加丰富有趣。
