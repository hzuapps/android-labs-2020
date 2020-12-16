# 实验二
## 一、实验目标		
1、在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2020/issues;  
2、根据自选题目，编写一个或多个Activity（主窗口类带上学号前缀，放到自己的Java包下）； 
3、将标题设置为自己的学号+对应的功能或题目；  
4、根据自己选择的题目实现Activity中导航、调用等功能（选做）。  
## 二、实验内容	
1. 创建2-3个Activity；	  
2. 在 Activity 上添加按钮、链接或导航栏，实现各个 Activity 的跳转；  
在 Net123456Activity.java 添加按钮点击事件处理，实现跳转。  
## 三、实验步骤	
1. 在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2020/issues ：#405 柚子笔记（记账本）
2. 编写三个功能Activity
3. 实现Activity中导航、调用等功能（选做）。
## 四、实验结果
1、创建2-3个Activity
Sec1814080911138Activity.java (首页、LAUNCHER、主活动)  
ChartActivity.java   折线图  
AboutActivity.java  帮助  
AndroidManifest.xml  配置文件  
2、通过创建项目时主界面右下角自带的fab按钮添加新账单
 FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
}
## 五、实验心得
 本次实验是本学期移动应用开发的第二堂实验课，初步学会了使用button按钮和实现页面间的跳转功能。
