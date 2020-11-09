# 一、实验报告

1. 根据选题要求设计界面布局及控件使用

2. 布局xml及界面控制操作代码提交并截图

3. 将应用运行结果截图

# 二、实验内容

1. 使用一种布局方式设计界面

2. 通过控件ID获取界面对象，执行相关操作

3. 实现界面控件的事件处理

4. 操作之后，切换到第二个界面

# 三、实验步骤

1. 创建`LinearLayout`布局的页面

2. 首页按钮布局
   ```
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <Button
            android:id="@+id/button"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="首页"
            />

        <Button
            android:id="@+id/button2"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="关于"
            />

        <Button
            android:id="@+id/button3"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="设置"
            />

    </LinearLayout>
    ```
3. 关于界面布局
```
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"

    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:paddingLeft="16dp"
    android:paddingRight="16dp"
    >


    <Button
        android:id="@+id/button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="关于作者"
        />

    <Button
        android:id="@+id/button2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="关于此视频播放器"
        />

    <Button
        android:id="@+id/button3"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="联系我们"
        />


    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">
        <Button
            android:layout_width="100dp"
            android:layout_height="wrap_content"
            android:layout_gravity="right"
            android:layout_weight="1"
            android:text="返回上一级"/>
        
    </LinearLayout>
    ```
 4. view界面布局
 ```
 <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"

    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:paddingLeft="16dp"
    android:paddingRight="16dp"
    >


    <Button
        android:id="@+id/button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="播放视频"
        />

    <Button
        android:id="@+id/button2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="在线视频"
        />

    <Button
        android:id="@+id/button3"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="本地视频"
        />


    <LinearLayout
    ```
    等等
# 四、实验结果

![实验截图](https://raw.githubusercontent.com/Xiaohuang-12/android-labs-2020/master/students/net1814080903216/lab4-01.png)
![实验截图](https://raw.githubusercontent.com/Xiaohuang-12/android-labs-2020/master/students/net1814080903216/lab4-02.png)
![实验截图](https://raw.githubusercontent.com/Xiaohuang-12/android-labs-2020/master/students/net1814080903216/lab4-03.png)

# 五、实验心得
这次实验主要是学会了线性布局LinearLayout的配置，只是学会简单的一点配置，难的还是难的。还有其他布局方式，学会布局，让自己的的界面看起来很整洁好看一点。让自己的项目有更好观感。
