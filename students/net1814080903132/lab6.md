# 一、实验目标
1.了解基本的按钮格式   
2.了解返回上一个Activity的方法    
3.将应用运行结果截图  
 
# 二、实验内容
1.通过配置xml文件调整按钮格式   
2.通过配置java文件实现返回上一个Activity    
3.将应用运行结果截图  

# 三、实验步骤
1.配置按钮文件  
```
<TextView
        android:id="@+id/comment_sm"
        android:layout_width="match_parent"
        android:layout_height="10dp"
        android:text="#此为校园吐槽君开放式交流平台，此页面仅提供查看近期内容#"
        android:textColor="#607b8b"
        android:textStyle="italic"
        android:textSize="26sp"
        tools:ignore="InvalidId"
        android:layout_weight="1" />

    <ImageView
        android:id="@+id/image"
        android:layout_width="420dp"
        android:layout_height="280dp"
        android:scaleType="centerCrop"
        android:src="@drawable/hzu" />

    <EditText
        android:id="@+id/comment_nr"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:gravity="top"
        android:hint="展示内容" />

    <Button
        android:onClick="ReadBtn"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="@drawable/btn_shape_2"
        android:textColor="#607b8b"
        android:textSize="17sp"
        android:textStyle="bold"
        android:text="点击显示内容" />

    <Button
        android:onClick="Backbtn_1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="@drawable/btn_shape_3"
        android:textColor="#607b8b"
        android:textSize="17sp"
        android:textStyle="bold"
        android:text="返回上一级" />
```
2.实现返回上一个Activity。    
```
public void Backbtn_1(View w){
        finish();
    }
``` 

# 四、实验结果
![lab6_1](https://raw.githubusercontent.com/ccc2020916/android-labs-2020/master/students/net1814080903132/lab6_1.png)  
![lab6_2](https://github.com/ccc2020916/android-labs-2020/blob/master/students/net1814080903132/lab6_2.png)
# 五、实验心得
在本次实验中学习到关于部件方面的格式等方面的配置，通过对颜色、字体、范围、位置等属性进行增添、更改
