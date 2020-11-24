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

2.3 打开 Activity  
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

- new Thread()
- runOnUiThread(): 更新界面  
- AsyncTask


## 实验七：Android设备


