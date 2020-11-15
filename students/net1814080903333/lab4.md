# 实验二
## 一、实验目标
1. 根据选题要求设计界面布局及控件使用； 
2. 布局xml及界面控制操作代码提交并截图； 
3. 将应用运行结果截图。 
## 二、实验内容
1. 使用一种布局方式设计界面； 
2. 通过控件ID获取界面对象，执行相关操作： 
3. 实现界面控件的事件处理; 
4. 操作之后，切换到第二个界面。  
## 三、实验步骤
 1. 主页面采用绝对布局，设置两个按钮，分别是查看学生课程信息，课时费管理。  
  2. 学生课程信息页面和课时费管理页面都采用线性布局和相对布局。  
  3. 查看学生课程信息页面组件和课时费管理页面组件采用了button TextView EditText、hint标签等等。  
  4. 在主界面使用OnClickListener事件监听器以及openActivity方法实现各界面的跳转。  
5. 利用startActivity(intent)实现跳转。    
## 四、实验结果
![图1主界面运行结果](https://github.com/yichouge/android-labs-2020/blob/master/students/net1814080903333/ExperimentalResult/lab3.png?raw=true)   图1主界面运行结果  
![图2学生课程信息页面运行结果](https://github.com/yichouge/android-labs-2020/blob/master/students/net1814080903333/ExperimentalResult/lab4.1.png?raw=true)  图2学生课程信息页面运行结果  
![图3课时费管理页面运行结果](https://github.com/yichouge/android-labs-2020/blob/master/students/net1814080903333/ExperimentalResult/lab4.2.png?raw=true)  图3课时费管理页面运行结果  
## 五、实验心得  
本次实验比前几次实验的难度明显增大、实验遇到的主要问题是一开始对相对布局不熟悉、不知如何摆放、第二是button和TextView、edittext有多个添加了相同的id导致运行可以成功只要一点按钮就程序提示错误闪退、
一开始以为是自己乱修改或者是界面哪些代码写错就把程序恢复为到原来状态发现按钮可以正常运行了、在添加自己设计的两个界面就又出现了刚刚的情况、于是我先添加一个界面发现可以正常运行、再添加就出错、出错的界面
然后与运行成功的界面一个一个比对发现有些组件的id设置重复了修改一下就成功了。

