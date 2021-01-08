#实验三
##一、实验目标
1、了解Android应用中各种资源的概念与使用方法；
2、了解并且掌握在Android插入图片的方法。
##二、实验要求
1、在界面上显示至少一张图片；
2、提交res/drawable及图片使用的代码；
3、提交res/values, res/layout等其他代码；
4、将应用运行结果截图，放到实验报告中；
##三、实验步骤
1、将图片放在D:\android-labs-2020\students\net1814080903241\app\src\main\res\drawable目录下；
2、打开Android studio，在res/drawable下添加导入目录的图片，调整图片位置；
<ImageView
    android:id="@+id/imageView"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:srcCompat="@drawable/zmiaomiao"
    tools:layout_editor_absoluteX="25dp"
    tools:layout_editor_absoluteY="0dp" />
3、在gitbash上依次提交drawble目录下的xml文件以及jpg图片，上传至github上，git push结束。
实验代码为：
cd d:
cd android-labs-2020/students/net1814080903241/app/src/main/res/drawable
git add zmiaomiao.jpg
git add ic_launcher_background.xml
git commit -m "#3 #565 第3次实验"
git push

##四、实验结果
##五、实验心得 
   这次实验相较于实验二是比较简单的，学会并且掌握了在android studio上插入图片，并且了解到了Android应用中各种资源的概念与使用方法。
