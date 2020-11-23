# 一、实验目标 #

1. 根据选题要求设计界面布局及控件使用
2. 布局xml及界面控制操作代码提交并截图
3. 将应用运行结果截图

# 二、实验内容 #

1. 使用其中一种布局方式设计所选题目的界面
2. 通过控件ID获取界面对象，执行相关操作
3. 将应用运行结果截图
4. 点击图片（或按钮）时，打开另一个界面

# 三、实验步骤 #

1. 首页采用相对布局，并在其中插入TextView、Button等组件
2. java文件通过通过findViewById(R.id.xxx)返回一个组件对象；xml文件通过android:id="@+id/xxx绑定组件对象，两者建立映射关系
3. 事件函数在java中写出，在xml中绑定，如函数send()要绑定到Button的Click事件，则可以在xml文件的Button组件中加入android:onClick="send"属性
4. 根据不同的需要对组件进行不同的绑定以及函数处理

# 四、实验结果 #

```xml
<Button
        android:id="@+id/but3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="钟表模式"
        android:textSize="30dp"
        android:layout_below="@id/but1"
        android:layout_centerHorizontal="true"
        android:onClick="send"
        />
```

```java
public void send(View view) {
        Intent intent = new Intent(m, Main1814080903225Clock.class);
        startActivity(intent);
    }
```

![result_1](https://raw.githubusercontent.com/ZYL618/android-labs-2020/master/students/net1814080903225/lab_4/result_1.png)

![result_2](https://raw.githubusercontent.com/ZYL618/android-labs-2020/master/students/net1814080903225/lab_4/result_2.png)

# 五、实验心得 #

本次实验需要初步实现自己的项目，需要对组件进行具体任务绑定，明确了xml和java的映射关系后，剩下的部分只需要用java代码进行实现即可。
