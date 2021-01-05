#实验六 Android网络编程

##  一、实验目标

1.	掌握Android网络访问方法；
2.	理解XML和JSON表示数据的方法。

## 二、实验内容

1.	结合项目，编写关于下载的类；
2.	对下载类对应的.xml进行界面设计；
3.	在下载类中完善相关的方法。


## 三、实验步骤

1. 建立关于下载的类FileDownloader.java文件和HttpClientActivity.java文件，根据所学知识编写代码；

2. 在第一个步骤的基础上，在其对应的.xml文件中进行界面设计，添加按钮以及其他操作，设面设计结果如图6.1和图6.2所示；
![image](https://github.com/bowwran/android-labs-2020/blob/master/students/net1814080903140/reportphoto/6/6.1.png)
![image](https://github.com/bowwran/android-labs-2020/blob/master/students/net1814080903140/reportphoto/6/6.2.png)

3. 完善关于下载的具体操作方法，其中包括设置存储目录、检查网络状态、创建下载器、添加按钮事件等等，以下附上关于检查网络的关键代码。
```
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_check) {
            checkNetworkState(); // 检查网络
        } else if (view.getId() == R.id.button_download_image) {
            downloadImages(); // 下载图片
        } else if (view.getId() == R.id.button_download_web) {
            downloadWebPage(); // 下载网页
        }
    }
```

## 四、实验结果

![image](https://github.com/bowwran/android-labs-2020/blob/master/students/net1814080903140/reportphoto/6/result.png)

## 五、实验心得体会

   这是这门课的第六次实验，主要是对于Android网络编程的学习，通过本次实践，我学会了如何利用网络编程在设计Android项目的时候进行下载的具体操作和方法。