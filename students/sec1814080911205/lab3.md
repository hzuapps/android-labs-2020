# 一、实验目标
1. 了解Android应用中各种资源的概念与使用方法；
2. 掌握在Android应用中使用图片等资源的方法。

# 二、实验要求
1. 在界面上显示至少一张图片（按照自己的题目添加）；
2. 提交res/drawable及图片使用的代码；
3. 提交res/values, res/layout等其他代码；
4. 将应用运行结果截图，放到实验报告中；
5. 点击图片（或按钮）时，打开另一个Activity。

# 三、实验步骤
1. 找到相应的图片，放在drawable目录下，要注意图片名称要小写字母。
2. 在Sec1814080911205Activity.xml文件的LinearLayout中下添加代码

android:background="@drawable/index"

# 四、实验结果
![lab3](https://github.com/wuuuxj/android-labs-2020/tree/master/students/sec1814080911205/lab3.jpg)

# 五、实验心得
通过这次实验，学会了如何增加背景图片。一开始是利用<ImageView>来插入背景，但是效果不理想，后来换成在LinearLayout直接引入背景图片，效果就好很多了。
