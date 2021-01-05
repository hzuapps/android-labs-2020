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

    import androidx.appcompat.app.AppCompatActivity;
    
    import android.os.Bundle;
    import android.view.ViewGroup;
    import android.widget.Button;
    import android.widget.LinearLayout;
    import android.widget.TextView;
    
    public class GameActivity extends AppCompatActivity {
    TextView[][] lattices = new TextView[8][8];
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initBoard();
    }
    
    private void initBoard(){
       LinearLayout board = (LinearLayout)findViewById(R.id.board);
        for(int i=0;i<8;i++){
           LinearLayout row = new LinearLayout(this);
           row.setOrientation(LinearLayout.HORIZONTAL);
            row.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,0,1));
           for(int j=0;j<8;j++){
               lattices[i][j] = new TextView(this);
               lattices[i][j].setText(String.valueOf(i+":"+j));
               lattices[i][j].setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT,1));
               lattices[i][j].setBackgroundResource(R.drawable.sharp);
               row.addView(lattices[i][j]);
           }
           board.addView(row);
       }
    }
} 


     2  ...ents/net1814080903126/src/main/java/edu/hzuapps/androidlabs/Net1814080903126Activity.java 
    Viewed
    @@ -32,7 +32,7 @@ public void onClick(View v) {
            continueButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(thisActivity,ContinueGameActivity.class);
                    Intent intent = new Intent(thisActivity,GameActivity.class);
                    thisActivity.startActivity(intent);
                }
            });
     15  students/net1814080903126/src/main/res/drawable/sharp.xml 
    Viewed
    @@ -0,0 +1,15 @@
    
    <layer-list xmlns:android="http://schemas.android.com/apk/res/android" >
    <item android:right="0dp">
        <shape android:shape="rectangle" >
            <solid android:color="#e3dbbf" />
        </shape>
    </item>
    <item android:right="1dp" android:top="1dp" android:left="1dp" android:bottom="1dp">
        <shape android:shape="rectangle" >
            <solid android:color="#ecf0f1" />
        </shape>
    </item>



    </layer-list> 
     31  students/net1814080903126/src/main/res/layout/activity_game.xml 
    Viewed
    @@ -0,0 +1,31 @@
    <?xml version="1.0" encoding="utf-8"?>
    <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".GameActivity">
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
    
        <LinearLayout
            android:id="@+id/board"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_weight="0.75"
            android:orientation="vertical"></LinearLayout>
    
        <LinearLayout
            android:id="@+id/tool"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_weight="9"
            android:orientation="vertical">
    
        </LinearLayout>
    </LinearLayout>
    </androidx.constraintlayout.widget.ConstraintLayout> 
     9  students/net1814080903126/src/main/res/layout/activity_score.xml 
    Viewed
    @@ -0,0 +1,9 @@
    <?xml version="1.0" encoding="utf-8"?>
    <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".ScoreActivity">
    
    </androidx.constraintlayout.widget.ConstraintLayout> 



 ## 四、实验结果

![](D:\android-labs-2020\students\net1814080903126\image\4.png)


五、实验心得

本次实验是Android界面设计编程。为扫雷实现了8*8个button。

