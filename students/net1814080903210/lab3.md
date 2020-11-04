# 一、实验目标

1. 了解Android应用中各种资源的概念与使用方法
2. 掌握在Android应用中使用图片等资源的方法
# 二、实验内容

1. 了解安卓应用各种资源的存放位置
2. 在Activity上显示图片

# 三、实验步骤

1. 将图片news.png放到drawable文件夹下
2. 在activity_main.xml下创建ImageView
3. ImageView通过src属性定位到news.png
4. 运行显示图片news.png
# 四、实验结果

![result](https://raw.githubusercontent.com/Playerlhh/android-labs-2020/master/students/net1814080903210/lab3_res.png)

# 五、实验心得

&#160; &#160; &#160; &#160;通过这次实验，我成功的在界面中显示图片，在安卓应用中，放在drawable文件夹下的图片都会被自动解析为资源，我们可以通过ImageView中的src属性或R.drawable.图片名的形式访问到图片。
