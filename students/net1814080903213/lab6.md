# 实验六
## 一、实验目标

1. 掌握Android网络访问方法；
2. 理解XML和JSON表示数据的方法。

## 二、实验内容

2. 在个人目录中创建一个表示数据的XML或JSON文件；
2. 数据文件代码提交之后从GitHub获取文件URL；
3. 在应用中通过网络编程访问GitHub的数据文件；
4. 在应用中解析并显示文件所包含的数据；
5. 将应用运行结果截图。

## 三、实验步骤

1. 修改build.gradle，打算使用官方的 Volley 组件来发送 http 请求

在dependencies加入下列内容

```gradle
// Volley
implementation 'com.android.volley:volley:1.1.1'
```

2. 在 Fastjson 的 [Github 页面](https://github.com/alibaba/fastjson)下载最新版的 Fastjson，并将 jar 包复制到项目的 app/libs 文件夹中，最后修改build.gradle文件。Fastjson 用于在项目中进行对 JsonString 与 JavaBean 的序列化与反序列化

[![Ddgf8e.png](https://s3.ax1x.com/2020/11/25/Ddgf8e.png)](https://imgchr.com/i/Ddgf8e)

```gradle
// fastjson
implementation files('libs/fastjson-1.2.75.jar')
```

3. 新建一个新 Activity：SubmitResultActivity，用于接收 http 请求返回的数据

[![Dd2PaV.png](https://s3.ax1x.com/2020/11/25/Dd2PaV.png)](https://imgchr.com/i/Dd2PaV)

4. 简单设计 SubmitResultActivity 的界面，使用 TextView 使其能够显示 http 请求返回的数据

[![Dd2tsA.png](https://s3.ax1x.com/2020/11/25/Dd2tsA.png)](https://imgchr.com/i/Dd2tsA)

5. 在 SubmissionFragment 中创建 Intent 对象，并将输入框中的内容、需要进行 http 请求的 Url 通过 Intent 传值到新创建的 Activity (SubmitResultActivity) 中

[![Dd2oz4.png](https://s3.ax1x.com/2020/11/25/Dd2oz4.png)](https://imgchr.com/i/Dd2oz4)

6. 在 SubmitResultActivity 中接收 Intent 的传值内容

[![DdRulQ.png](https://s3.ax1x.com/2020/11/25/DdRulQ.png)](https://imgchr.com/i/DdRulQ)

7. 实现 http 请求并将返回数据进行 JsonString 到 JavaBean 的序列化，最终显示到页面上

[![DdRB01.png](https://s3.ax1x.com/2020/11/25/DdRB01.png)](https://imgchr.com/i/DdRB01)

## 四、实验结果

输入框输入内容后：

[![DdROXj.png](https://s3.ax1x.com/2020/11/25/DdROXj.png)](https://imgchr.com/i/DdROXj)

点击 Submit 后跳转到结果页：

[![DdRq1g.png](https://s3.ax1x.com/2020/11/25/DdRq1g.png)](https://imgchr.com/i/DdRq1g)

## 五、实验心得

　　本次实验主要使用了官方推荐的 Volley 组件来进行简单 http 访问请求，没有使用老师课上所讲的方法。但是总体上来说按照官方教程来配置还是比较顺利的。本次的问题主要出现在 Fastjson 的使用上不够熟练所导致的，也有一部分是 Fastjson 本身的问题，不过最后还是完成了相应的功能。由于当前 Fastjson 项目的维护不够好，文档支持不够好，这次 Fastjson 的尝试让我更坚定了：以后不再会选择它在生产环境中使用了。

