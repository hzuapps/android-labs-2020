# 一、实验目标
1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。

#  二、实验内容
1. 使用一种布局方式设计界面；
2. 通过控件ID获取界面对象，执行相关操作：
```
// XML
android:id="@+id/my_button"
// Java
findViewById(R.id.my_button);
```
3. 实现界面控件的事件处理;
4. 操作之后，切换到第二个界面。

# 三、实验步骤
1. 根据自己项目设置了GridView布局方式。
2. 在对应的activity（我的是GridViewActivity)根据自己的项目修改布局，比如九宫格或者四宫格；
3. 修改activity_main.xml，配置添加自己所加的Activity，注册相关组件；
4. 为所需显示的对象创建类（class 名字Adapter extends BaseAdapter）与适配器，加上自己所需项目对应的对象名，
```java
 public Integer[] mThumbIds = {
            R.drawable.tu1,
            R.drawable.tu2,
            R.drawable.tu3,
            R.drawable.tu4}；
```
# 四、实验结果
![实验截图](https://raw.githubusercontent.com/Lj-xinfei/android-labs-2020/044b6c7d13a9e6c6e5b2d3b66ca3404b1d972e31/students/net1814080903119/lab4.1.jpg)
![实验截图](https://raw.githubusercontent.com/Lj-xinfei/android-labs-2020/044b6c7d13a9e6c6e5b2d3b66ca3404b1d972e31/students/net1814080903119/lab4.2.jpg)
![实验截图](https://raw.githubusercontent.com/Lj-xinfei/android-labs-2020/044b6c7d13a9e6c6e5b2d3b66ca3404b1d972e31/students/net1814080903119/lab4.3.jpg)
![实验截图](https://raw.githubusercontent.com/Lj-xinfei/android-labs-2020/044b6c7d13a9e6c6e5b2d3b66ca3404b1d972e31/students/net1814080903119/lab4.4.jpg)

# 五、实验心得
了解各个布局的界面，依据项目需要选择了GridView布局，调试中遇到了图片大小问题，可在对应的layout修改格式或者在对应的Java文件解决并显示。
