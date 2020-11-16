# 实验一 Android开发环境搭建

## 一、实验目标

1. 搭建 Android（Android Studio）开发环境；
2. 熟悉并掌握Git与GitHub.com提交实验代码的方法。

## 二、实验内容

1. 搭建Android开发环境
2. 创建项目
3. 创建名为Sec1814080911238的java类
4. 熟练Git常用命令

## 三、实验步骤

1. 搭建开发环境（Android Studio）
2. 加入Git项目（Fork），将项目克隆（Clone）到本地

```shell
cd E:\
git clone https://github.com/Arlene238/android-labs-2020.git
cd android-labs-2020 
```

3. 创建以学号命名的个人实验目录：students/sec1814080911238


4. 创建一个Java类

   edu.hzuapps.androidlabs.sec1814080911238.Sec1814080911238Activity.java
```java
package edu.hzuapps.androidlabs.sec1814080911238;

public class Sec1814080911238 {
	public static void main(String args[]){
		System.out.println("Hello Sec1814080911238!");
	}
}
```


5. 提交代码并发Pull Request
在android-labs-2020目录下进行如下操作
```shell
git add ./
git commit -m "#1 #613 第1次实验"
git push
```

## 四、实验结果
![结果](https://github.com/Arlene238/android-labs-2020/blob/master/students/sec1814080911238/lab1-1.png?raw=true)



## 五、实验心得

　　 此次实验，让我掌握了Android Studio的安装和简单的使用操作，虽然在安装的过程中遇到了许多问题，比如AVD虚拟机的安装失败，Gradle无法下载问题，最终通过老师给的资料和网上大神的指点，
   一步一步的解决问题，完成Android项目的安装和运行；同时也使我更加熟练的掌握git工具上传文件的使用技能，在编写md文件的过程中，直接在本地编写一部分，然后上传到github中，分别体验不同编写md文件的过程。
