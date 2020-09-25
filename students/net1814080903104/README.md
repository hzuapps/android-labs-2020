# 移动应用开发实验库（2020春）   
实验要求：https://github.com/hzuapps/android-labs-2020/issues?q=is%3Aissue+is%3Aopen+label%3ALab

## Android中文教材
http://hukai.me/android-training-course-in-chinese/index.html  
https://www.gitbook.com/book/mobile100/android/details  

## Android英文教程
http://www.tutorialspoint.com/index.htm

## Android开发工具下载网址
https://developer.android.google.cn  
http://www.androiddevtools.cn/ 

## Android Studio汉化（某同学亲测成功）
http://jingyan.baidu.com/article/ff42efa93177c0c19e2202c3.html

## 配置代理的新方法

https://blog.vvzero.com/2018/04/08/set-proxy-for-newest-android-studio/  
https://blog.csdn.net/weixin_40849588/article/details/86559842  
http://www.voidcn.com/article/p-alndgxtc-bpx.html   

## Gradle 报错解决方法

Error：Could not Get 'https://dl.google.com/dl/android/maven2/com/android/tools/build/gradle/3.1.3/gradle-3.1.3.pom'. Received status code 400 from server: Bad Request
Enable Gradle 'offline mode' and sync project  

步骤1：file  ->> setting  ->> build，excution，->>gradle   ->>  android studio ->>  勾选Enable。。。  

https://blog.csdn.net/qq_41550842/article/details/81939479  

步骤2：编辑配置文件，注释掉所配置的代理（意思是下载插件要用代理，但是用了代理这里会报错，因此这里不有用代理）

```  
#systemProp.https.proxyPort=80
#systemProp.http.proxyHost=mirrors.neusoft.edu.cn
#systemProp.https.proxyHost=mirrors.neusoft.edu.cn
#systemProp.http.proxyPort=80
```  

https://blog.csdn.net/lqx_sunhan/article/details/82633275  

## Android版本6.0安装提示
在Android SDK Manager中，参考下面的截图配置和下载6.0版本的库。
![在Android SDK Manager中配置教育网下载代理](https://raw.githubusercontent.com/hzuapps/android-labs/master/screens/sdk-manager-proxy-edu.cn.png "配置教育网下载代理")
![在Android SDK Manager中选择6.0库](https://raw.githubusercontent.com/hzuapps/android-labs/master/screens/android-6-sdk.png "配置教育网下载代理")
![在Android SDK Manager中下载6.0库](https://raw.githubusercontent.com/hzuapps/android-labs/master/screens/android-6-sdk-download.png "配置教育网下载代理")

## Android应用架构
https://github.com/googlesamples/android-architecture 



