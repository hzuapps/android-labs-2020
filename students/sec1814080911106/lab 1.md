# 实验一 Android开发环境搭建

## 一、实验目标

1. 搭建 Android（Android Studio）开发环境；
2. 熟悉并掌握Git与GitHub.com提交实验代码的方法。


## 二、实验内容
1. 搭建Android开发环境
2. 创建项目
3. 创建名为Sec1814080911106Activity的java类
4. 熟练Git常用命令


## 三、实验步骤
1. 搭建开发环境（Android Studio）
![Android Studio欢迎界面](https://github.com/18cs06/android-labs-2020/blob/master/students/sec1814080911106/Android%20%E5%BC%80%E5%8F%91%E7%8E%AF%E5%A2%83.png)

2. 加入Git项目（Fork），将项目克隆（Clone）到本地
cd D:\
git clone https://github.com/Thisko/android-labs-2020/
cd android-labs-2020 

3. 创建以学号命名的个人实验目录：students/sec1814080911106
![实验目录](https://github.com/18cs06/android-labs-2020/blob/master/students/sec1814080911106/%E5%AE%9E%E9%AA%8C%E7%9B%AE%E5%BD%95.png)

4. 创建一个Java类

edu.hzuapps.androidlabs.sec1814080911106.Sec1814080911106Activity.java
```java
package edu.hzuapps.androidlabs.sec1814080911106;
public class Sec1814080911106Activity
	public static void main(String args[]){
		System.out.println("Hello World!");	
	}
	}
```

5. 提交代码并发Pull Request
```shell
git add sec1814080911106/Sec1814080911106Activity.java
git commit -m "#4 #50 第1次实验"
git push	git push
```


## 四、实验结果
![结果](https://github.com/18cs06/android-labs-2020/blob/master/students/sec1814080911106/%E5%AE%9E%E9%AA%8C1%E6%88%AA%E5%9B%BE.png)


## 五、实验心得
　　通过本次实验，我学习了搭建 Android开发环境，并学会了使用Git命令上传代码。在实验过程中，因为首次接触git，对相关命令的使用十分不熟悉，经过相关的学习后，使我对git命令的理解有了很大的提高。
