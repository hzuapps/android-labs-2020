# 实验四 
  ## 一、实验目标 
  1. 根据选题要求设计界面布局及控件使用； 
  2. 布局xml及界面控制操作代码提交并截图； 
  3. 将应用运行结果截图。 

   ## 二、实验内容 
  1. 使用一种布局方式设计界面； 
  2. 通过控件ID获取界面对象，执行相关操作： 
  3. 实现界面控件的事件处理; 
  4. 操作之后，切换到其它界面。 

   ## 三、实验步骤 
  1.主页面设计三个按钮和可编辑文本框。
  2.开始比赛/功能/技巧按钮，按钮点击实现跳转。
  3.功能/技巧页面采用线性布局和滚动布局结合，通过滑轮滚动查看下方的内容。
  ```xml
  <ScrollView
        android:id="@+id/scrollView2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="@+id/button14"
        tools:ignore="UnknownId">
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical">
             <TextView
                ……
                />
                ……
            </LinearLayout>
    </ScrollView>
  ```
   ## 四、实验结果 
  ![首页](https://raw.githubusercontent.com/Garfield-zheng/android-labs-2020/master/students/net1814080903328/lab01.PNG)
  ![规则界面布局](https://raw.githubusercontent.com/Garfield-zheng/android-labs-2020/master/students/net1814080903328/RuleLayout.PNG)
  ![技巧界面布局](https://raw.githubusercontent.com/Garfield-zheng/android-labs-2020/master/students/net1814080903328/SkillsLayout.PNG)

   ## 五、实验心得 
  本次布局设计实验相比之前的实验在难度上要大一些，我采用的是滚动布局（ScrollView）和线性布局（LinearView）结合来展示文本内容。
