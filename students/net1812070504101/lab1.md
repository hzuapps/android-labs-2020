# 实验一
## 一.实验目标
1. 构建安卓开发环境
2. 熟悉git的操作与使用方法
  
## 二.实验内容
1. 搭建android开发环境
2. 创建运行测试java类
3. 使用git同步文件到github
  
## 三.实验步骤
1. 下载androidSDK  
2. 官网下载androidStdio,并且同时在androidstdio中下载androiAVD模拟器  
3. 运行测试Net1812070504101MainActivity的java类  
4. 显示hello world!  
5. 将项目克隆到本地

```
$ cd D:\  
$ git clone https://github.com/Miraiiiii/android-labs-2020/    
$ cd android-labs-2020 
```
6. 在androidStdio中编写Net1812070504101MainActivity的java类  

```public class Net1814080903113MainActivity extends AppCompatActivity{  
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.net1812070504101main);
 ```  
 
7. 提交代码并请求合并  
$ git add D:\android-labs-2020\students\net1814080903113/Net1812070504101MainActivity.java  
$ git commit -m "#1 #171 第1次实验"  
$ git push  
  
## 四.实验结果
Forked  
Main.java运行结果  
  
## 五.实验心得
本次实验是关于github与git的基本使用，同时也开始学习使用android的构建第一个最基本的项目，实验步骤不难，但是第一次接触会有一点不太适应
