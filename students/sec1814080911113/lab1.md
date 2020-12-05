#实验一 Android开发环境搭建

##一、实验目标

1.搭建 Android（Android Studio）开发环境；

2.熟悉并掌握Git与GitHub.com提交实验代码的方法。

##二、实验内容

1.搭建Android开发环境

2.创建项目

3.创建名为Sec1814080911113Activity的java类

4.熟练Git常用命令

##三、实验步骤

1.搭建开发环境（Android Studio）

2.加入Git项目（Fork），将项目克隆（Clone）到本地

```
cd D:

git clone https://github.com/BlaiseChin/android-labs-2020.git

cd android-labs-2020
```

3.创建以学号命名的个人实验目录：students/sec1814080911113

4.创建一个Java类

edu.hzuapps.androidlabs.sec1814080911113.Sec1814080911113Activity.java

```
package edu.hzuapps.androidlabs.sec1814080911113;

public class Sec1814080911113Activity{
	public static void main(String args[]){
		
	}
}
```

5.提交代码并发Pull Request 在android-labs-2020目录下进行如下操作

```
git add ./
git commit -m "#1 #37 第1次实验"
git push
```
##四.实验结果

<img src="https://github.com/BlaiseChin/android-labs-2020/blob/master/students/sec1814080911113/pic.PNG" width="50%">

##五.实验心得

    通过本次实验，我学会了Android开发环境的搭建，Android Studio的基本使用方法，在搭建Android环境的时候遇到很多问题，比如代理没配好导致加载时间过长的一系列问题，但是最后都成功解决掉了。通过实验一我还学会了如何通过git命令提交代码到GitHub仓库中。通过makedown写实验报告又学会了一种脚本语言。
