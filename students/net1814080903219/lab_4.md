# 一、实验目标
1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。（不要做登陆注册！）
# 二、实验内容
1. 使用合适的布局对选题进行界面设计；
2. 使用和选题相关的控件；
3. 实现界面控件的事件处理
# 三、实验步骤
1. 使用LinearLayout布局对activity_main.xml进行设计
2. 设计自己的Toolbar，需要在styles.xml中添加一个style
```
<style name="myAppTheme" parent="Theme.AppCompat.Light.NoActionBar">
        <!-- Customize your theme here. -->
        <item name="colorPrimary">@color/colorPrimary</item>
        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
        <item name="colorAccent">@color/colorAccent</item>
</style>
```
3. 需要在AndroidManifest.xml中对三个activity引用自己的Toolbar
```
<activity android:name=".PhysicalScoreActivity"  android:theme="@style/myAppTheme"/>
    <activity android:name=".QueryScoreActivity"  android:theme="@style/myAppTheme"/>
    <activity android:name=".Net1814080903219Activity" android:theme="@style/myAppTheme">
    <intent-filter>
          <action android:name="android.intent.action.MAIN" />

          <category android:name="android.intent.category.LAUNCHER" />
     </intent-filter>
</activity>
```
4. 在activity_main.xml中添加Toolbar控件
```
<androidx.appcompat.widget.Toolbar
        android:id="@+id/toolbar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="#3E4CC9">

        <TextView
            android:id="@+id/tv"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:text="学生服务"
            android:textColor="#fff"
            android:textSize="20sp" />
    </androidx.appcompat.widget.Toolbar>
```
5. 在activity_query_score.xml中同样添加Toolbar，Toolbar包含有ImageButton、Button、TextView
```
<androidx.appcompat.widget.Toolbar
        android:id="@+id/toolbar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="#3E4CC9">
        
        <ImageButton
            android:id="@+id/imgbtn_return"
            android:layout_width="25dp"
            android:layout_height="25dp"
            android:background="#3E4CC9"
            android:src="@drawable/fanhui"/>

        <Button
            android:id="@+id/btn_return"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:gravity="left"
            android:background="#3E4CC9"
            android:text="返回"
            android:paddingTop="10dp"
            android:textColor="#FFFFFF"
            android:textSize="20sp"/>

        <TextView
            android:id="@+id/tv"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:text="学业成绩"
            android:textColor="#fff"
            android:textSize="20sp" />


    </androidx.appcompat.widget.Toolbar>
```
6. 在activity_query_score.xml中添加Spinner和ListView控件，分别用于排序条件的选择和成绩的列表展示。
7. 在QueryScoreActivity.java中对Spinner和ListView分别添加适配器
8. 在activity_physical_score.xml同样添加Toolbar，并加入一个ListView控件用于体测成绩的列表展示，并在PhysicalScoreActivity.java中对其添加适配器

# 四、实验结果
![result4-1](https://github.com/account-lin/android-labs-2020/blob/master/students/net1814080903219/lab4_result1.png)
![result4-2](https://github.com/account-lin/android-labs-2020/blob/master/students/net1814080903219/lab4_result2.png)
![result4-3](https://github.com/account-lin/android-labs-2020/blob/master/students/net1814080903219/lab4_result3.png)
![result4-4](https://github.com/account-lin/android-labs-2020/blob/master/students/net1814080903219/lab4_result4.png)
# 五、实验心得
本次实验是根据自己的选题，利用合适的布局对功能界面进行设计并实现功能，由于对布局及控件不太熟悉，在界面设计上花了比较多的时间，而且对于适配器的理解不够透彻，导致功能的实现上出现比较多的错误。通过
上网查找资料，观看视频讲解，才把问题解决。
