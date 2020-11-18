# 实验四：Android界面设计编程

## 一、实验目标

1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。**（不要做登录注册！）**

## 二、实验内容

1. 使用其中一种布局方式，**设计所选题目的界面**，建议用LinearLayout。

   * LinearLayout, RelativeLayout, Adapter, ConstraintLayout (自学)

## 三、实验步骤

1. 主界面使用listView+baseAdapter布局,XML文件如下

   ```xml
   <?xml version="1.0" encoding="utf-8"?>
   <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
       xmlns:app="http://schemas.android.com/apk/res-auto"
       xmlns:tools="http://schemas.android.com/tools"
       android:layout_width="match_parent"
       android:layout_height="match_parent"
       android:orientation="vertical"
       tools:context=".Net1814080903133Activity">
   
       <ListView
           android:id="@+id/listView"
           android:layout_width="match_parent"
           android:layout_height="675dp" />
   
       <LinearLayout
           android:layout_width="match_parent"
           android:layout_height="107dp"
           android:gravity="center_vertical"
           android:orientation="horizontal">
   
           <Button
               android:id="@+id/addBtn"
               android:layout_width="80dp"
               android:layout_height="50dp"
               android:layout_marginStart="20dp"
               android:layout_marginLeft="20dp"
               android:layout_marginEnd="20dp"
               android:layout_marginRight="20dp"
               android:layout_weight="1"
               android:background="@drawable/btn_style"
               android:text="添加" />
   
           <Button
               android:id="@+id/setBtn"
               android:layout_width="80dp"
               android:layout_height="50dp"
               android:layout_marginStart="20dp"
               android:layout_marginLeft="20dp"
               android:layout_marginEnd="20dp"
               android:layout_marginRight="20dp"
               android:layout_weight="1"
               android:background="@drawable/btn_style"
               android:fontFamily="@font/iconfont"
               android:text="@string/setBtn"
               android:textSize="30sp"
               app:layout_constraintBottom_toBottomOf="parent"
               app:layout_constraintEnd_toEndOf="parent"
               app:layout_constraintStart_toStartOf="parent"
               app:layout_constraintTop_toTopOf="parent" />
   
           <Button
               android:id="@+id/deleBtn"
               android:layout_width="wrap_content"
               android:layout_height="wrap_content"
               android:layout_marginStart="20dp"
               android:layout_marginLeft="20dp"
               android:layout_marginEnd="20dp"
               android:layout_marginRight="20dp"
               android:layout_weight="1"
               android:background="@drawable/btn_style"
               android:text="删除" />
       </LinearLayout>
   
   </LinearLayout>
   ```

   

   

2. 阅读界面使用viewPager2+Fragment布局,XML文件如下

   ```xml
   <?xml version="1.0" encoding="utf-8"?>
   <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
       xmlns:app="http://schemas.android.com/apk/res-auto"
       xmlns:tools="http://schemas.android.com/tools"
       android:layout_width="match_parent"
       android:layout_height="match_parent"
       android:layout_weight="10"
       android:orientation="vertical"
       tools:context=".myActivity.NovelReadActivity" >
   
       <androidx.viewpager2.widget.ViewPager2
           android:id="@+id/readViewpager"
           android:layout_width="match_parent"
           android:layout_height="match_parent"
           app:layout_constraintBottom_toBottomOf="parent"
           app:layout_constraintEnd_toEndOf="parent"
           app:layout_constraintStart_toStartOf="parent"
           app:layout_constraintTop_toTopOf="parent" />
   
   </androidx.constraintlayout.widget.ConstraintLayout>
   ```

   

3. 设置界面使用LineLayout布局,XML文件如下

   ```xml
   <?xml version="1.0" encoding="utf-8"?>
   <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
       xmlns:app="http://schemas.android.com/apk/res-auto"
       xmlns:tools="http://schemas.android.com/tools"
       android:layout_width="match_parent"
       android:layout_height="match_parent"
       android:orientation="vertical"
       android:weightSum="10"
       tools:context=".myActivity.SettingActivity">
   
       <androidx.cardview.widget.CardView
           android:layout_width="match_parent"
           android:layout_height="50dp"
           android:layout_marginTop="20dp">
   
           <Switch
               android:id="@+id/switch6"
               android:layout_width="match_parent"
               android:layout_height="match_parent"
               android:layout_marginStart="26dp"
               android:layout_marginLeft="26dp"
               android:layout_marginEnd="26dp"
               android:layout_marginRight="26dp"
               android:switchMinWidth="56dp"
               android:text="夜间模式"
               android:textColorHint="#FFFFFF"
               android:textSize="18sp"
               android:trackTint="@color/switch_color" />
   
       </androidx.cardview.widget.CardView>
   
       <androidx.cardview.widget.CardView
           android:layout_width="match_parent"
           android:layout_height="50dp">
   
           <TextView
               android:layout_width="wrap_content"
               android:layout_height="wrap_content"
               android:layout_gravity="center_vertical"
               android:layout_marginStart="25dp"
               android:layout_marginLeft="25dp"
               android:text="背景设置"
               android:textColor="@android:color/black"
               android:textSize="18sp" />
       </androidx.cardview.widget.CardView>
   
       <androidx.cardview.widget.CardView
           android:layout_width="match_parent"
           android:layout_height="50dp"
           android:layout_marginTop="20dp">
   
           <TextView
               android:layout_width="wrap_content"
               android:layout_height="wrap_content"
               android:layout_gravity="center_vertical"
               android:layout_marginStart="25dp"
               android:layout_marginLeft="25dp"
               android:text="添加书籍"
               android:textColor="@android:color/black"
               android:textSize="18sp" />
       </androidx.cardview.widget.CardView>
   
       <androidx.cardview.widget.CardView
           android:layout_width="match_parent"
           android:layout_height="50dp">
   
           <TextView
               android:layout_width="wrap_content"
               android:layout_height="wrap_content"
               android:layout_gravity="center_vertical"
               android:layout_marginStart="25dp"
               android:layout_marginLeft="25dp"
               android:text="删除书籍"
               android:textColor="@android:color/black"
               android:textSize="18sp" />
       </androidx.cardview.widget.CardView>
   
       <androidx.cardview.widget.CardView
           android:layout_width="match_parent"
           android:layout_height="50dp"
           android:layout_marginTop="20dp">
   
           <Switch
               android:id="@+id/switch7"
               android:layout_width="match_parent"
               android:layout_height="match_parent"
               android:layout_marginStart="26dp"
               android:layout_marginLeft="26dp"
               android:layout_marginEnd="26dp"
               android:layout_marginRight="26dp"
               android:switchMinWidth="56dp"
               android:text="自动播放"
               android:textColorHint="#FFFFFF"
               android:textSize="18sp"
               android:trackTint="@color/switch_color" />
       </androidx.cardview.widget.CardView>
   
       <androidx.cardview.widget.CardView
           android:layout_width="match_parent"
           android:layout_height="50dp">
   
           <TextView
               android:layout_width="wrap_content"
               android:layout_height="wrap_content"
               android:layout_gravity="center_vertical"
               android:layout_marginStart="25dp"
               android:layout_marginLeft="25dp"
               android:text="快捷键设置"
               android:textColor="@android:color/black"
               android:textSize="18sp" />
       </androidx.cardview.widget.CardView>
   
   </LinearLayout>
   ```

   4. 实现动态布局的Adapter已经在实验二给出。

## 四、实验结果及截图

主界面效果图

 <img src="https://raw.githubusercontent.com/xiaohei504/image/master/lab2(1).jpg" alt="主界面效果" style="zoom: 25%;" />

阅读界面效果图

<<img src="https://raw.githubusercontent.com/xiaohei504/image/master/lab2(2).jpg" alt="阅读界面效果" style="zoom:25%;" />

设置界面效果图

 <img src="https://raw.githubusercontent.com/xiaohei504/image/master/lab2(3).jpg" alt="设置界面效果" style="zoom:25%;" />



## 五、实验心得

这次实验由于我使用了listView，viewPager+adapter来实现动态布局，所以难度有点大，因为之前没使用过适配器的写法。花了很多时间去学习，找资料。在这段时间就深刻体会到了安卓变化之快，查找Viewpager2时发现国内网上只有五六年前的ViewPager1的技术，Viewpager2的资料很少很少，因为这个原因花了很长时间去学习，才把这个实验做出来。总结：作为一个程序员英语能力还是很重要的，很多资料是英文的，特别是最新的资料。学会看官方文档，官方文档是最权威的，不管是什么语言，一定是以官方文档为准，学会看官方文档能减少很多不必要的事情。