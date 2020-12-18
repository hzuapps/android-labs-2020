# 实验二



## 一、实验目标

1. 创建自己的选题
2. 编写相应的Activity（有n个功能就建立n+1个Activity）
3. 对应自己的选题的功能实现Activity中的功能



## 二、实验内容

1. 在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2020/issues ；
2. 根据自选题目，编写多个Activity，在主窗口类带上学号前缀，放到自己的Java包下；
3. 将标题设置为自己的学号+对应的功能或题目；
4. 根据自己选择的题目实现Activity中导航、调用等功能（选做）。


## 三、实验步骤

1.在github中创建自己创建自己的APP题目，列出APP功能（查询，转账，理财）
2.在android studio中创建自己的activity
FinancialActivity（理财功能）
InquireActivity（查询功能）
TransferActivity（转账功能）
Sec1814080911203Activity（主活动）
3. 分别在activity_main.xml上添加三个按钮（垂直排放，不然重叠在一起），在Sec1814080911203Activity.java添加按钮点击事件，跳转到对应界面


## 四、实验结果
启动界面：https://raw.githubusercontent.com/CYJ13824255375/android-labs-2020/master/students/sec1814080911203/lab2.PNG


## 五、实验心得与体会

这个实验其实并不难，但是对于刚学的来说，还是有些难度，因为并不是很懂。这个实验首先需要主要的地方是在activity_main.xml上添加按钮的时候，不仅需要设置它的宽度，高度，还需要设置三个按钮是如何摆放的（垂直或者水平），不然三个按钮就会重叠在一起，其次是按钮需要id，才能在主活动中进行绑定。           







