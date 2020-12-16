# 实验一 Android开发环境搭建

## 一、实验目标

1. 搭建 Android（Android Studio）开发环境；
2. 熟悉并掌握Git与GitHub.com提交实验代码的方法。

## 二、实验内容

1. 搭建Android开发环境
2. 创建项目
3. 创建名为Sec1814080911223的java类
4. 熟练Git常用命令

## 三、实验步骤

1. 搭建开发环境（Android Studio）
2. 加入Git项目（Fork），将项目克隆（Clone）到本地

```shell
cd C:\
git clone https://github.com/Arlene223/android-labs-2020.git
cd android-labs-2020 
```

3. 创建以学号命名的个人实验目录：students/sec1814080911223


4. 创建一个Java类

   edu.hzuapps.androidlabs.sec1814080911223.Sec1814080911223Activity.java
```java
package edu.hzuapps.androidlabs.sec1814080911223;
public class Sec1814080911223 {
	public static void main(String args[]){
		System.out.println("Hello Sec1814080911223!");
	}
}
```


5. 提交代码并发Pull Request
在android-labs-2020目录下进行如下操作
```shell
git add ./
git commit -m "#1 #47 第1次实验"
git push
```

## 四、实验结果
![实验结果](https://github.com/1814080911223/android-labs-2020/blob/master/students/sec1814080911223/%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE/lab1%E6%88%AA%E5%9B%BE.jpg)

## 五、实验心得

　　 在这次实验中，让我掌握了Android Studio的安装和简单的使用操作，虽然在安装的过程中遇到了许多问题，比如AVD虚拟机安装失败，补下载一些包等等，但在百度和同学的帮助下一一解决了。此次实验也让我掌握git工具上传文件的使用技能。

