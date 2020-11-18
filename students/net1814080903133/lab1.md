# 实验一：Android开发环境搭建

## 一、实验目标

1. 搭建 Android（Android Studio）开发环境；
2. 熟悉并掌握Git与GitHub.com提交实验代码的方法

## 二、实验内容

1. 搭建开发环境（Android Studio），运行（截图）；
2. 加入Git项目（Fork），将项目克隆（Clone）到自己帐号下；
3. 创建以学号命名的个人实验目录(在"我的电脑"里创建)；
4. 创建一个Java类。
5. 提交代码并发Pull Request，老师合并之后截图。

## 三、实验步骤

1. 安装Android Studio，SDK，配置实验环境；\
2. 将hzuapps/android-labs-2020的项目Fork到自己的github账号下；

3. 安装git bash用git clone命令将android-labs-2020项目克隆到本地；

   `git clone https://github.com/xiaohei504/android-labs-2020`

4. 创建一个名为Net1814080903133Activity 的java类；

   ```java
   package edu.hzuapps.androidlabs.net1814080903133
   public class Net1814080903133Activity{
   }
   ```

5. 在git bash提交Net1814080903133Activity 的java类

   ```
   git add android_labs-2020/*
   git commit -m "#1 #64第一次实验"
   git push
   ```

   



## 四、实验结果

Android studio配置成功

 <img src="https://raw.githubusercontent.com/xiaohei504/image/master/lab1(1).png" alt="Android studio配置完成" style="zoom:50%;" />

Fork项目到自己账号

 <img src="https://raw.githubusercontent.com/xiaohei504/image/master/lab1(2).png" alt="将项目Fork到自己的GitHub账号下" style="zoom:80%;" />

成功提交代码

 <img src="https://raw.githubusercontent.com/xiaohei504/image/master/lab1(3).png" alt="push成功" style="zoom:50%;" />

## 五、实验心得

本次实验学会了如何简单使用GitHub，主要是git clone ,git add,git commit和git push这几个命令的作用，全流程就是将代码从GitHub下载下来修改，重新上传到GitHub上。