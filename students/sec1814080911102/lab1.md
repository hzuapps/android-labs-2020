# 实验一 Android开发环境搭建

## 一、实验目标
1. 搭建 Android（Android Studio）开发环境；
2. 熟悉并掌握Git与GitHub.com提交实验代码的方法。

## 二、实验内容
1. 搭建Android开发环境
2. 创建项目
3. 创建名为Sec1814080911102的java类
4. 熟练Git常用命令

## 三、实验步骤
1. 搭建开发环境（Android Studio）
2. 加入Git项目（Fork），将项目克隆（Clone）到本地
```shell
cd E:\
git clone https://github.com/2587900/android-labs-2020.git
cd android-labs-2020 
```
3. 创建以学号命名的个人实验目录：students/sec1814080911102
4. 创建一个Java类
   edu.hzuapps.androidlabs.sec1814080911238.Sec1814080911102Activity.java
```java
package edu.hzuapps.androidlabs.sec1814080911102;
public class Sec181408091102 {
	public static void main(String args[]){
  System.out.println("Hello World!");
	}
}
```
5. 提交代码并发Pull Request
在android-labs-2020目录下进行如下操作
```shell
git add ./
git commit -m "#1 #39 第1次实验"
git push
```

## 四、实验结果
![lab1运行截图](https://github.com/2587900/android-labs-2020/blob/master/students/sec1814080911102/screenshots/lab1%E8%BF%90%E8%A1%8C%E6%88%AA%E5%9B%BE.PNG)

## 五、实验心得
　　 通过这次实验，我学会了Android Studio的安装和简单的使用操作，虽然在安装的过程中遇到了许多问题，比如环境的配置以及相关软件的下载问题，不过最后都是一一解决了。另外我还学会了如何运用GitHub这个强大的平台，比如fork库、clone库到本地、同步库等等。 
