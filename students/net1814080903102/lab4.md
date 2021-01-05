# 实验四 Android界面设计编程

## 一、实验要求

- 根据选题要求设计界面布局及控件使用；
- 布局xml及界面控制操作代码提交并截图；
- 将应用运行结果截图；

## 二、实验内容

- 在所学的几种布局方式中自行选择设计界面；
- 通过findViewById获取界面对象，执行相关操作；
- 实现界面控件的事件处理；


## 三、实验步骤
- 添加Linearlayout布局，作为显示星期的容器
```xml
<LinearLayout
        android:id="@+id/weekLine"
        android:layout_width="match_parent"
        android:layout_height="20dp"
        android:background="#00000000"
        android:gravity="center"
        android:orientation="horizontal"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/weekTextView"
        tools:ignore="MissingConstraints">

        <TextView
            android:id="@+id/textView"
            android:layout_width="0dp"
            android:layout_height="match_parent"
            android:layout_weight="0.25"
            android:text="" />
    </LinearLayout>
```
- 在weekLine中添加星期
```java
    private void initWeekLine(){
        LinearLayout weekLine = (LinearLayout)findViewById(R.id.weekLine);    //找到weekLine
        for(int i=0;i<7;i++)
        {
            TextView day = new TextView(this);
            day.setText(getDayName(i));   //转换为星期
            day.setGravity(1);    //居中
            day.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT,1));   //设置宽高权重
            day.setBackgroundResource(R.drawable.shape);    //设置背景，形成边框
            weekLine.addView(day);    //加入布局
        }
```
- 添加ScrollView让课程显示
```xml
    <ScrollView
        android:id="@+id/scrollView"
        android:layout_width="match_parent"
        android:layout_height="610dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/weekLine">

        <LinearLayout
            android:id="@+id/classContent"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical">

        </LinearLayout>
    </ScrollView>
 ```
 - java代码动态添加课程
 ```java
         LinearLayout linearLayout = (LinearLayout)findViewById(R.id.classContent);
        for(int i=0;i<classArray.getMaxSection();i++){
            LinearLayout layout = new LinearLayout(this);
            layout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200));
            TextView blank = new TextView(this);
            blank.setText(String.valueOf(1+i));
            blank.setGravity(Gravity.CENTER_VERTICAL);
            blank.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT,0.25f));
            layout.addView(blank);
            for(int j=0;j<7;j++){
                TextView textView = new TextView(this);
                textView.setText(classArray.getCourseName(j,i));
                textView.setGravity(1);
                textView.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT,1));
                textView.setBackgroundResource(R.drawable.courseshape);
                textView.setGravity(Gravity.CENTER_VERTICAL);
                layout.addView(textView);
            }
            linearLayout.addView(layout);
        }
 ```
 - 设置界面
 ```xml
 <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent">

        <LinearLayout
            android:id="@+id/setStartWeek"
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:orientation="horizontal">

            <TextView
                android:layout_width="0dp"
                android:layout_height="match_parent"
                android:layout_weight="1"
                android:text="学期开始日期"
                android:layout_marginLeft="10dp"
                android:textStyle="bold"
                android:textSize="15dp"
                android:gravity="center_vertical"
                />

            <TextView
                android:id="@+id/showStartWeek"
                android:layout_width="0dp"
                android:layout_height="match_parent"
                android:layout_marginRight="10dp"
                android:layout_weight="1"
                android:text="TextView"
                android:textSize="13dp"
                android:gravity="center_vertical"
                android:textAlignment="textEnd"
                tools:ignore="RtlCompat" />
        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:orientation="horizontal">
            <TextView
                android:layout_width="0dp"
                android:layout_height="match_parent"
                android:text="一天节数"
                android:layout_weight="1"
                android:layout_marginLeft="10dp"
                android:textStyle="bold"
                android:textSize="15dp"
                android:gravity="center_vertical"
                tools:ignore="Suspicious0dp" />
            <TextView
                android:layout_width="0dp"
                android:layout_height="match_parent"
                android:layout_marginRight="10dp"
                android:layout_weight="1"
                android:text="TextView"
                android:textSize="13dp"
                android:gravity="center_vertical"
                android:textAlignment="textEnd"
                tools:ignore="RtlCompat" />
        </LinearLayout>
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:orientation="horizontal">
            <TextView
                android:layout_width="0dp"
                android:layout_height="match_parent"
                android:text="学期周初"
                android:layout_weight="1"
                android:layout_marginLeft="10dp"
                android:textStyle="bold"
                android:textSize="15dp"
                android:gravity="center_vertical"
                tools:ignore="Suspicious0dp" />
            <TextView
                android:layout_width="0dp"
                android:layout_height="match_parent"
                android:layout_marginRight="10dp"
                android:layout_weight="1"
                android:text="TextView"
                android:textSize="13dp"
                android:gravity="center_vertical"
                android:textAlignment="textEnd"
                tools:ignore="RtlCompat" />
        </LinearLayout>
    </LinearLayout>
 ```
 - 添加课程界面
 ```xml
 <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#FFFFFF"
    android:backgroundTint="#FFFFFF"
    android:orientation="vertical"
    android:paddingLeft="16dp"
    android:paddingRight="16dp">

    <EditText
        android:id="@+id/courseName"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:autofillHints=""
        android:hint="课程名" />

    <EditText
        android:id="@+id/courseRoom"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="教室" />

    <EditText
        android:id="@+id/courseNumber"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:autofillHints=""
        android:hint="上课节数" />

    <EditText
        android:id="@+id/startWeek"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="起始周" />

    <EditText
        android:id="@+id/endWeek"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="终止周" />

    <EditText
        android:id="@+id/isOddWeek"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="是否单双周" />

    <Button
        android:id="@+id/addCourse"
        android:layout_width="100dp"
        android:layout_height="wrap_content"
        android:layout_gravity="right"
        android:text="添加课程" />
</LinearLayout>
 ```
## 四、实验结果
- 主界面
![](https://raw.githubusercontent.com/Thisko/Figure-bed/master/img/mainActivity.jpg)
- 设置
![](https://raw.githubusercontent.com/Thisko/Figure-bed/master/img/generalSetting.jpg)
- 添加课程
![](https://raw.githubusercontent.com/Thisko/Figure-bed/master/img/addCourse.jpg)

## 五、实验心得
 本次使用是对app界面的设计，在我看来是对实现后面的功能搭建框架，在布局方面根据实际情况使用了较多的java代码来实现。
