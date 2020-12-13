# 实验一 Android开发环境搭建

## 一、实验目标
1. 搭建 Android（Android Studio）开发环境；
2. 熟悉并掌握Git与GitHub.com提交实验代码的方法。

## 二、实验内容
1. 搭建Android开发环境
2. 创建项目
3. 创建名为Net1814080903334的java类
4. 熟练Git常用命令

## 三、实验步骤
1. 搭建开发环境（Android Studio）
2. 加入Git项目（Fork），将项目克隆（Clone）到本地
```shell
cd E:\
git clone https://github.com/2587900/android-labs-2020.git
cd android-labs-2020 
```
3. 创建以学号命名的个人实验目录：students/Net1814080903334
4. 创建一个Java类
   edu.hzuapps.androidlabs.net1814080903334.Net1814080903334Activity.java
```java
package edu.hzuapps.androidlabs.net1814080903334;
public class Net1814080903334 {
	public static void main(String args[]){
  System.out.println("Hello World!");
	}
}
```
5. 提交代码并发Pull Request
在android-labs-2020目录下进行如下操作
```shell
git add ./
git commit -m "#1 #76 第1次实验"
git push
```

## 四、实验结果
![lab1运行截图](https://github.com/book-ccr/android-labs-2020/blob/master/students/net1814080903334/net1814080903334Activicity.png)

## 五、实验心得
　 这是安卓的第一次实验，学习了Android Studio的安装和简单的使用，其中虽然有很多问题但最后在同学的帮助下一一解决了。最后也成功把实验一的内容上传到GitHub上。总体来说实验一没有什么问题。
