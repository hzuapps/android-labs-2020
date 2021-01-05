# 实验六：Android网络编程

## 一、实验目标

1. 掌握Android网络访问方法；
2. 理解XML和JSON表示数据的方法；

## 二、实验要求

1. 从网络下载一个文件（图片、MP3、MP4）；
2. 保存到手机，在应用中使用文件；
3. 将应用运行结果截图。

## 三、实验步骤

1. 编写下载图片弹窗布局和代码文件dialog_download.xml与DownloadDialog.java；
2. 在页面布局xml内添加打开下载窗口的代码；
3. 查看效果。

## 四、实验结果

![UI](https://raw.githubusercontent.com/zhongzhitao/android-labs-2020/master/students/net1814080903211/lab6.png)
![dialog](https://raw.githubusercontent.com/zhongzhitao/android-labs-2020/master/students/net1814080903211/lab6-1.png)

## 五、实验心得

第六次实验从难度上来讲挺简单的，但是做的过程中出现了许多意料之外的问题，比如一开始用Picasso作为图片下载库的时候发现不能正常使用，但是没有报错信息来排查错误的问题，在找文档打开日志输出后却发现是HTTP 504错误，在看了相关问题后手动使用OkHttp写HTTPS下载器发现还是不能使用，在两天时间内仍然不能修复这个问题，随后更换为使用Glide才解决。
