# 一、实验目标

1. 搭建 Android（Android Studio）开发环境；
2. 熟悉并掌握Git与GitHub.com提交实验代码的方法。

# 二、实验内容

1. 搭建 Android（Android Studio）开发环境；
2. 熟悉并掌握Git与GitHub.com提交实验代码的方法。

# 三、实验步骤

1. 搭建开发环境（Android Studio），运行（截图）；  
   ![图片1](https://github.com/jaydjxing/android-labs-2020/blob/master/students/net1814080903317/Android%20Studio4.0%E5%AE%89%E8%A3%85%E6%88%90%E5%8A%9F%E6%88%AA%E5%9B%BE.jpg?raw=true)
   *安装的时候要注意的是Android SDK和虚拟机的安装，可以选择推荐安装（会帮你自动搜索本机的jdk版本、推荐安装最新的SDK...），但是安装路径会默认为c盘，所以选推荐安装的话要注意更改安装路径，虚拟机的话，建议使用真机测试（安卓），因为虚拟机操作起来不方便，而且如果电脑配置比较低，会很卡，而且真机测试可以避免很多权限问题，例如相机权限。  
   *安装完sdk创建新项目时，AS会基于gradle自动构建项目，一般需要漫长的等待（10-20分钟也是正常），如果想快一点可以配置国内镜像代理；如果构建过程中关掉了，然后重新打开AS项目时没有自动构建，synchronized同步按钮也无法点击时，可以去C://用户:/个人电脑的用户名/  的目录下找到.gradle文件，把整个.gradle文件删除，然后重启AS就会重新构建。  
2. 加入Git项目（Fork），将项目克隆（Clone）到自己帐号下；    
   *Fork在页面的右上角的位置，点击Fork到自己账户下。
3. 创建以学号命名的个人实验目录(在"我的电脑"里创建)：其中，com开头表示计算机班，soft开头表示软件班，net为网络工程班，sec为网络安全班，数字为个人学号；  
   *在student目录下，使用mkdir创建目录net1814080903317，需要交的实验内容就放在net+学号这个目录下。
4. 创建一个Java类;  
   *使用AS创建一个Java类，直接新建一个java类即可。
5. 提交代码并发Pull Request，老师合并之后截图；  
   1）在gitbash中进入net1814080903317目录 git add 你要提交的文件名+后缀名  
   2）接着git commit -m "#1 #192 第一次实验" -m里面的内容是你要提交的附带信息，可以理解为注释，#1代表第一次四眼 #192是选题提交的那个号，第一次实验也是注释  
   3）最后git push，第一次git push时需要绑定用户信息，提交的时候需要告诉gitbash你的账户名和密码，等待即可。
# 四、实验结果
   *提交成功，然后再GitHub上面，在自己的目录下面 New pull request>Create pull request创建提交请求，然后提交即可，然后可在hzuapps/实验室下中的Pull requests下可以查看自己所提交的选项。

# 五、实验心得体会
   *这次的实验难度不大。主要是搭建AS环境和学会怎样使用gitbash，gitbash教程可以在网上百度得到，其实是linux的语法，然后编写实验报告的readme.md的语法百度即可。
