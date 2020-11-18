# 实验四：Android界面设计编程

 ## 一、实验目标

 1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。

 ## 二、实验要求

 1. 使用一种布局方式，设计所选题目的界面，建议使用LinearLayout。
2. 通过控件ID获取界面对象，执行相关操作。
3. 实现界面控件的事件处理，例如点击按钮。

 ## 三、实验步骤

 1. import androidx.appcompat.app.AppCompatActivity;


     import android.os.Bundle;	import android.os.Bundle;
    import android.widget.LinearLayout;
    import android.widget.TextView;


     public class RankActivity extends AppCompatActivity {	public class RankActivity extends AppCompatActivity {


         @Override	    @Override
        protected void onCreate(Bundle savedInstanceState) {	    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);	        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_rank);	        setContentView(R.layout.activity_rank);
            initRankTable();
        }
        
         private void initRankTable(){
            LinearLayout rankTable = (LinearLayout)findViewById(R.id.rankTable);
            for(int i=0;i<10;i++){
                LinearLayout rankItem = new LinearLayout(this);
                rankItem.setOrientation(LinearLayout.HORIZONTAL);
                TextView textView = new TextView(this);
                textView.setText("第"+(i+1)+"名");
                rankItem.addView(textView);
                rankTable.addView(rankItem);
            }
        }	    }
    } 	} 

    <?xml version="1.0" encoding="utf-8"?>
    <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".GameActivity">

         <Button
            android:id="@+id/restart"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="重新开始"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.049"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            app:layout_constraintVertical_bias="0.023" />
        
         <ImageView
            android:id="@+id/imageView3"
            android:layout_width="197dp"
            android:layout_height="232dp"
            android:layout_marginTop="68dp"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            app:srcCompat="@drawable/zhipai" />
        
         <ImageView
            android:id="@+id/imageView4"
            android:layout_width="170dp"
            android:layout_height="225dp"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            app:layout_constraintVertical_bias="0.841"
            app:srcCompat="@drawable/zhipai" />
        
         <Button
            android:id="@+id/button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="开始抽牌"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.498"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            app:layout_constraintVertical_bias="0.486" />
        
         <Button
            android:id="@+id/button2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="开始抽牌"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.498"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            app:layout_constraintVertical_bias="0.976" />

     </androidx.constraintlayout.widget.ConstraintLayout> 

 2. <?xml version="1.0" encoding="utf-8"?>
    <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".Net1814080903112Activity">

         <Button
            android:id="@+id/rankButton"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="20dp"
            android:text="分数排行"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/gameButton" />
        
         <Button
            android:id="@+id/gameButton"
            android:layout_width="92dp"
            android:layout_height="57dp"
            android:layout_marginTop="20dp"
            android:text="开始游戏"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/imageView" />
        
         <ImageView
            android:id="@+id/imageView"
            android:layout_width="291dp"
            android:layout_height="328dp"
            android:layout_marginTop="100dp"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            app:srcCompat="@drawable/poker" />
    </androidx.constraintlayout.widget.ConstraintLayout>

 ## 四、实验结果

 ![home](D:\android-labs-2020\students\image\4.png)


五、实验心得

本次实验是Android界面设计编程。难度较大花费了较多的时间。第一次交的时候少了个界面后面又花费了一些时间才完成。