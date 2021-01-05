# 一、实验报告 

1. 了解Android应用中各种资源的概念与使用方法

2. 掌握在Android应用中使用图片等资源的方法

# 二、实验内容

1. 在界面上显示至少一张图片（按照自己的题目添加）

2. 提交res/drawable及图片使用的代码

3. 提交res/values, res/layout等其他代码

4. 将应用运行结果截图，放到实验报告中

5. 点击图片（或按钮）时，打开另一个Activity

# 三、实验步骤

1. 将目标图片保存到本地Android studio的 res/drawable路径中

2. 在相应layout的xml文件中设置TextView属性实现导入图片，代码如下
   ```
   <TextView
        android:id="@+id/textview_01"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:drawableTop="@drawable/bg"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        tools:ignore="MissingConstraints" />
   ```
3. 打开另外一个Activity
   ```
   btn2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(thisActivity,NetAboutActivity.class);
                thisActivity.startActivity(intent);
            }
        });
   ```
# 四、实验结果

 ![实验截图](https://raw.githubusercontent.com/Xiaohuang-12/android-labs-2020/master/students/net1814080903216/lab3-01.png)
 ![实验截图](https://raw.githubusercontent.com/Xiaohuang-12/android-labs-2020/master/students/net1814080903216/lab3-02.png)
# 五、实验心得
这次实验主要是学到了添加图片到界面上，让界面更有个性化。学会了配置图片属性。

