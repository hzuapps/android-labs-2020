# 实验一
## 实验目标
1. 搭建 Android（Android Studio）开发环境  
2. 熟悉并掌握Git与GitHub.com提交实验代码的方法   
## 实验内容
1. 搭建Android Studio环境，配置SDK；  
2. 创建一个名为Net学号Activity的java类；  
3. 安装git，熟悉git bash的命令；  
4. 上交实验相关文件  
## 实验步骤
1. 用 cd 命令切换到保存代码的路径上    
$ cd  /User/yaozhenbin  
2. 用 clone 命令将个人库的代码克隆到本地磁盘：  
$ git clone https://github.com/yichouge/android-labs-2020   
$ cd   /User/yaozhenbin/android-labs-2020   
3. 创建以学号命名的个人实验目录(在"/User/yaozhenbin/andriod-labs-2020"里创建):      
   students/net1814080903333   
4. 创建一个Java类:  
edu.hzuapps.androidlabs.net18140080903333.Net1814080903333Activity.java  
5. 提交代码  
提交代码的命令：  
$ cd /User/yaozhenbin/andriod-labs-2020/students    
$ git add net1814080903333/*  
$ git commit -m "#1 #72 第1次实验"  
$ git push   
## 实验结果
![图1andriod studio 虚拟机运行结果](https://github.com/yichouge/android-labs-2020/raw/master/students/net1814080903333/lab1.png?raw=true)
## 实验心得
本次实验我遇到的问题还是挺多的最大的问题是不知如何删除github上多余或不要的文件，在终端乱输命令，结果文件路劲少输入了一级删除了自己库里的student文件不得不把老师库里的student文件克隆岛自己的本地
磁盘上在进行操作，在寻求老师和同学们的帮助下我学会了如何用命令删除github上的文件。
