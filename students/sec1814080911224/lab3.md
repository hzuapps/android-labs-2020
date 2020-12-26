# 实验三：Android资源使用编程

## 一、实验目标

1. 了解Android应用中各种资源的概念与使用方法；
2. 掌握在Android应用中使用图片等资源的方法。

## 二、实验要求

1. 在界面上显示至少一张图片（按照自己的题目添加）；
2. 提交res/drawable及图片使用的代码；
3. 提交res/values, res/layout等其他代码；
4. 将应用运行结果截图，放到实验报告中；
5. 点击图片（或按钮）时，打开另一个Activity。

## 三、实验步骤

将图片放到项目中的 src/main/res/drawable中。

在activity_draw.xml,添加TextView为项目添加图片，如下：

```xml
<TextView
        android:id="@+id/textview_01"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:="@drawable/drawable"
        android:paddingLeft="160dp"
        android:paddingTop="100dp"
        android:text="  洗牌" />
```

在 activity_shuffle.xml添加TextView为项目添加图片，如下：

```xml
<TextView
        android:id="@+id/textview_01"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:drawableTop="@drawable/shuffle"
        android:text="比大小"
        android:paddingLeft="160dp"
        android:paddingTop="100dp"/>
```

在 activity_sec1814080911224.xml,添加 background 为项目添加背景图，如下：

```
android:background="@drawable/background"
```

然后再在java代码中添加调整图片大小的代码

```java
Drawable drawable = getResources().getDrawable(R.drawable.Drawable);
        	drawable.setBounds(0,0,200,200);
       	TextView textview = (TextView) findViewById(R.id.textview_01);
       	textview.setCompoundDrawables(null,drawable,null,null);
    }
}
```

```java
Drawable drawable = getResources().getDrawable(R.drawable.shuffle);
        	drawable.setBounds(0,0,200,200);
        	TextView textview = (TextView) findViewById(R.id.textview_01);
        	textview.setCompoundDrawables(null,drawable,null,null);
    }
}
```

## 四、实验结果及截图

![tp1](https://github.com/ljjljjj/android-labs-2020/blob/master/students/sec1814080911224/lab2-1.PNG)


![tp2](https://github.com/ljjljjj/android-labs-2020/blob/master/students/sec1814080911224/lab2-2.PNG)


![tp3](https://github.com/ljjljjj/android-labs-2020/blob/master/students/sec1814080911224/lab2-3.PNG)

## 五、实验心得

成功在activity中插入图片，并成功运行，但是关于图片的大小并没有完全配置好，导致图片与模拟机没有达成一致，页面不好看，还需调整，本次实验学会了如何在模拟机中添加背景图。











