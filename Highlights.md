# 课程知识点 （Markdown）

## 实验一：开发坏境

1.1 Android SDK （与Java SDK对比）  

1.2 Android Studio   
- 配置 aliyun.com 镜像
- 练习基本操作，特别是快捷键
- 创建 Android 项目   

1.3 GitHub 实验方法，特别是 Git-Bash

## 实验二：Android 组件

2.1 组件的概念   

2.2 创建 Activity    
- 配置文件 AndroidManifest.xml 
- Activity 生命周期

2.3 打开 Activity （Intent）
- 显式调用 startActivity （掌握） 
- 隐式调用 intent-filter （了解）

## 实验三：Android 资源

3.1 res/layout/

3.2 res/drawable/ 

3.3 R.

## 实验四：Android 界面  

4.1 概念  

- View（控件、可视化），ViewGroup（容器、布局）
- 设计界面的两种方法：res/layout/.xml（静态界面结构）、Java（动态操作界面控件）  
- 界面的基础属性：@+id/, width/height=match_parent/wrap_content，padding（内边距）  

4.2 常用的布局  

- LinearLayout 线性布局：orientation=v,h；weight=0,1+
- RelativeLayout 相对布局  
- AdapterView (Spinner, ListView, GridView)

4.3 用Markdown编写实验报告  

- 一级标题 (#, ##, ###)  
- 项目编号 (1. ) 
- 代码（``` ）  
- 图片（实验结果截图、图片要先Push到自己的库里、找到图片链接）



## 实验五：Android存储

5.1 文件存储  

- 内部存储：  
```  
context.getFilesDir()
```  
- File类的用法：  
```
new File(PATH, NAME)
```  
- 字节流：InputStream，OutputStream等  
```
context.openFileInput() 
context.openFileOutput()  
```
- 字符流：BufferedReader，BufferedWriter等  
```   
reader.readLine()  
writer.write(STRING)  
```  

5.2 首选项存储  

```  
SharedPreferences settings = context.getSharedPreferences()
SharedPreferences.Editor editor = settings.edit();
```  

5.3 数据库（SQLite） 

- ContentProviderActivity.java (使用 ContentProvider)
- ContentProviderOfBooks.java （定义 ContentProvider）
- activity_content_provider.xml （表单界面）
- AndroidManifest.xml (\<Provider\>)

## 实验六：Android网络

1. 设置使用网络的权限：INTERNET

2. 基本的网络连接类：HttpURLConnection 

- openConnection()
- connection()
- disconnect() 

3. 网络连接必须在独立线程里操作

- 方法一：new Thread()
- 方法二：runOnUiThread(): 更新界面  
- 方法三：AsyncTask.doInBackground() 

4. 下载文件 

- 多线程：（1）下载网络文件、（2）将文件写到磁盘  
- 下载的三个操作：error、progress、complete 

5. Android程序基本写法

- Activity可以作为Listener
- 成员变量加前缀，保存常用控件（Button、Input），统一初始化


## 实验七：Android设备

1. 拍照

- new Intent(MediaStore.ACTION_IMAGE_CAPTURE)  
- startActivityForResult(intent)  
- onActivityResult(..., intent)

## 实验八：综合实验

1. 完成选题的开发报告：Android.Final.docx 

2. 根据微信小程序“教学助理”的要求，按时发送Word版实验报告到老师邮箱。

- 微信小程序：教学助理
