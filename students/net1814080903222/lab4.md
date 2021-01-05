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

1. 改为使用导航栏切换页面，需要使用Fragment显示页面而不是使用Activity，因此要将FolderActivity和SettingsAcitivity改写成BrowseFragment与SettingFragment，在官方指导文档里，提及最好情况下使用MVM模型，因此需要写相应的BrowseViewModel和SettingViewModel，以及新增HomeFragment与HomeViewModel显示主页；
2. 删除FolderActivity.java与SettingActivity.ava，及其对应布局layout_folder.xml与layout_setting.xml；
3. 攥写HomeFragment、BrowseFragment、SettingFragment的逻辑；
4. 提交文件。

## 四、实验结果

![home](https://raw.githubusercontent.com/zhongzhitao/android-labs-2020/master/students/net1814080903211/lab4-1.png)
![browse](https://raw.githubusercontent.com/zhongzhitao/android-labs-2020/master/students/net1814080903211/lab4-2.png)
![setting](https://raw.githubusercontent.com/zhongzhitao/android-labs-2020/master/students/net1814080903211/lab4-3.png)

## 五、实验心得

第四次实验有些难度，主要是需要重构之前已经写好的文件，在做的过程中接触了数据绑定，非常方便编写动态页面。
