# 实验一 Android开发环境搭建

## 一、实验目标

1. 搭建 Android（Android Studio）开发环境；
2. 熟悉并掌握Git与GitHub.com提交实验代码的方法。

## 二、实验内容

1. 搭建Android开发环境
2. 创建项目
3. 创建名为Net1814080903102Activity的java类
4. 熟练Git常用命令

## 三、实验步骤

1. 搭建开发环境（Android Studio）
![Android Studio欢迎界面](https://raw.githubusercontent.com/Thisko/Figure-bed/master/img/20201111085613.png)

2. 加入Git项目（Fork），将项目克隆（Clone）到本地

```shell
cd D:\
git clone https://github.com/Thisko/android-labs-2020/
cd android-labs-2020 
```

3. 创建以学号命名的个人实验目录：students/net1814080903102
![实验目录](https://raw.githubusercontent.com/Thisko/Figure-bed/master/img/20201111090603.png)


4. 创建一个Java类

   edu.hzuapps.androidlabs.net1814080903102.Net1814080903102Activity.java
```java
package edu.hzuapps.androidlabs.net1814080903102;

public class Net1814080903102Activity {
	public static void main(String args[]){
		System.out.println("Hello World!");
	}
	}
```


5. 提交代码并发Pull Request

```shell
git add net1814080903102/Net1814080903102Activity.java
git commit -m "#1 #23 第1次实验"
git push
```

## 四、实验结果
![结果](https://raw.githubusercontent.com/Thisko/Figure-bed/master/img/20201111090742.png)



## 五、实验心得

　　在实验过程中因为网络问题略有不顺，但跟着上面的步骤一步一步操作还是很容易完成实验的。
