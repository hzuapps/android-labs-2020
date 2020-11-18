# 一、实验目标

1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。

# 二、实验内容

1. 根据功能需求选择合适的布局方式设计界面；
2. 通过findViewById获取相关的控件；
3. 运行查看结果。

# 三、实验步骤

1. 主界面activity_net1814080903141.xml采用ConstraintLayout布局，主要设置了2个button，并使用OnClickListener事件监听器以及openActivity方法实现各界面的跳转。

   ```java
   <?xml version="1.0" encoding="utf-8"?>
   <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
   
       xmlns:app="http://schemas.android.com/apk/res-auto"
       xmlns:tools="http://schemas.android.com/tools"
       android:layout_width="match_parent"
       android:layout_height="match_parent"
       android:background="#FDE9D6"
       tools:context=".Net1814080903141Activity">
   
       <Button
           android:id="@+id/GameButton"
           android:layout_width="270dp"
           android:layout_height="48dp"
           android:layout_marginStart="73dp"
           android:layout_marginLeft="73dp"
           android:layout_marginTop="30dp"
           android:layout_marginEnd="72dp"
           android:layout_marginRight="72dp"
           android:layout_marginBottom="10dp"
           android:text="@string/game"
           android:textSize="18sp"
           app:layout_constraintBottom_toTopOf="@+id/RecordButton"
           app:layout_constraintEnd_toEndOf="parent"
           app:layout_constraintHorizontal_bias="1.0"
           app:layout_constraintStart_toStartOf="parent"
           app:layout_constraintTop_toBottomOf="@+id/imageView"
           tools:ignore="MissingConstraints" />
   
       <Button
           android:id="@+id/RecordButton"
           android:layout_width="270dp"
           android:layout_height="48dp"
           android:layout_marginStart="73dp"
           android:layout_marginLeft="73dp"
           android:layout_marginTop="10dp"
           android:layout_marginEnd="72dp"
           android:layout_marginRight="72dp"
           android:layout_marginBottom="227dp"
           android:text="@string/record"
           android:textSize="18sp"
           app:layout_constraintBottom_toBottomOf="parent"
           app:layout_constraintEnd_toEndOf="parent"
           app:layout_constraintStart_toStartOf="parent"
           app:layout_constraintTop_toBottomOf="@+id/GameButton"
           tools:ignore="MissingConstraints" />
   
       <ImageView
           android:id="@+id/imageView"
           android:layout_width="165dp"
           android:layout_height="149dp"
           android:layout_marginStart="123dp"
           android:layout_marginLeft="123dp"
           android:layout_marginTop="126dp"
           android:layout_marginEnd="123dp"
           android:layout_marginRight="123dp"
           android:layout_marginBottom="30dp"
           android:contentDescription="@string/todo"
           android:src="@drawable/logo"
           app:layout_constraintBottom_toTopOf="@+id/GameButton"
           app:layout_constraintEnd_toEndOf="parent"
           app:layout_constraintStart_toStartOf="parent"
           app:layout_constraintTop_toTopOf="parent"
           tools:ignore="MissingConstraints" />
   </androidx.constraintlayout.widget.ConstraintLayout>
   ```

   

2. 子界面activity_game.xml采用线性布局，添加所需的控件。

   ```java
   <?xml version="1.0" encoding="utf-8"?>
   <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
       xmlns:tools="http://schemas.android.com/tools"
       android:layout_width="match_parent"
       android:layout_height="match_parent"
       android:background="#FDE9D6"
       android:orientation="horizontal"
       tools:context=".GameActivity"
       >
       <ImageView
           android:id="@+id/imageView"
           android:layout_width="109dp"
           android:layout_height="97dp"
           android:layout_marginTop="32dp"
           android:background="#FDE9D6"
           android:contentDescription="@string/todo"
           android:src="@drawable/logo"
           tools:ignore="MissingConstraints" />
   
       <TextView
           android:id="@+id/textView2"
           android:layout_width="90dp"
           android:layout_height="78dp"
           android:layout_marginStart="30dp"
           android:layout_marginLeft="30dp"
           android:layout_marginTop="32dp"
           android:layout_marginEnd="32dp"
           android:layout_marginRight="32dp"
           android:layout_marginBottom="633dp"
           android:background="#FAE7D4"
           android:text="@string/score"
           android:textColor="#45665F"
           android:textIsSelectable="false"
           android:textSize="24sp"
           android:textStyle="bold" />
   
       <TextView
           android:id="@+id/textView"
           android:layout_width="90dp"
           android:layout_height="78dp"
           android:layout_marginStart="30dp"
           android:layout_marginLeft="30dp"
           android:layout_marginTop="32dp"
           android:layout_marginEnd="32dp"
           android:layout_marginRight="32dp"
           android:layout_marginBottom="633dp"
           android:text="@string/best"
           android:textColor="#45665F"
           android:textSize="24sp"
           android:textStyle="bold" />
   </LinearLayout>
   ```
   
   
   
3. 子界面activity_record.xml采用线性布局，添加所需的控件。

   ```java
   <?xml version="1.0" encoding="utf-8"?>
   <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
       xmlns:tools="http://schemas.android.com/tools"
       android:layout_width="match_parent"
       android:layout_height="match_parent"
       android:background="#FDE9D6"
       android:orientation="vertical"
       tools:context=".RecordActivity"
       >
   
       <TextView
           android:id="@+id/textView1"
           android:layout_width="wrap_content"
           android:layout_height="wrap_content"
           android:text="@string/history"
           android:layout_marginStart="150dp"
           android:layout_marginLeft="150dp"
           android:textColor="#61725E"
           android:textSize="24sp"
           android:textStyle="bold"
           />
   
       <TextView
           android:id="@+id/textView2"
           android:layout_width="match_parent"
           android:layout_height="714dp" />
   </LinearLayout>
   ```

# 四、实验结果

![lab4-1](D:\android-labs-2020\students\net1814080903141\实验结果截图\lab4-1.png)

![lab4-2](D:\android-labs-2020\students\net1814080903141\实验结果截图\lab4-2.png)

![lab4-3](D:\android-labs-2020\students\net1814080903141\实验结果截图\lab4-3.png)

# 五、实验心得

本次实验主要是实现界面的设计，实验过程需要花些时间思考。根据个人的项目需要，主界面选择约束布局，基本完成页面的设计和所需功能。子界面采用线性布局，后续还需要在界面中添加一些组件及点击后的功能完善。