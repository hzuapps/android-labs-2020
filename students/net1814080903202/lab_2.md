# 一、实验目标
1. 在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2020/issues ；
2. 根据自选题目，编写一个或多个Activity（主窗口类带上学号前缀，放到自己的Java包下）；
3. 将标题设置为自己的学号+对应的功能或题目；
4. 根据自己选择的题目实现Activity中导航、调用等功能（选做）。  
# 二、实验内容
1. 选题，并根据功能创建对应Activity；
2. 编写layout布局文件，添加按钮;
3. 编写Activity类，实现Activity之间的跳转。  
# 三、实验步骤
1. 创建选题#71 https://github.com/hzuapps/android-labs-2020/issues/71
2. 创建四个功能Activity
- Net1814080903202Activity
- Moment1814080903202Activity
- Comment1814080903202Activity
- Scan1814080903202Activity
3. 在Net814080903202Activity的layout布局中加入三个Button按钮，并分别指定id;
4. 创建Button对象，并通过findViewById获取对应按钮。
5. 按钮添加点击事件，将Net814080903226Activity实现View.OnClickListener接口，重写onClick方法，switch判断id创建相应Intent对象。
6. startActivity传入相应的Intent对象，实现跳转。  
# 四、实验结果
![lab2](https://github.com/tillsunrise/android-labs-2020/blob/master/students/net1814080903202/lab2_1.png)
![lab2](https://github.com/tillsunrise/android-labs-2020/blob/master/students/net1814080903202/lab2_2.png)  
# 五、实验心得
通过这次实验，我学会了如何在layout布局文件添加按钮控件，在Java类中实现Activity跳转。一开始没有封装按钮代码，代码比较冗余，后来又通过实现View.OnClickListener接口，重写onClick方法改进了这一点。
