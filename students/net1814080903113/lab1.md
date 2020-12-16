# 一、实验目标 #

1. 搭建 Android（Android Studio）开发环境
2. 熟悉并掌握Git与GitHub.com提交实验代码的方法

# 二、实验内容 #

1. 搭建Android开发环境
2. 创建项目
3. 创建名为Net1814080903113MainActivity的java类
4. 运行显示HelloWorld
5. 熟练Git常用命令

# 三、实验步骤 #

1. 搭建Android开发环境
2. 将项目Fork到自己的仓库
3. 将项目克隆到本地
```shell
$ cd D:\
$ git clone https://github.com/Miraiiiii/android-labs-2020/  
$ cd android-labs-2020 
```
4. 创建学号文件夹net1814080903113
5. 创建名为Net1814080903225Activity的java类

```java
public class Net1814080903113MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.net1814080903113main);
```
6. 提交代码并请求合并
```shell
$ git add D:\android-labs-2020\students\net1814080903113/Net1814080903113MainActivity.java
$ git commit -m "#1 #158 第1次实验"
$ git push
```
# 四、实验结果 #
![Forked](https://github.com/Miraiiiii/android-labs-2020/blob/master/students/net1814080903113/test1.png)

![Main程序](https://github.com/Miraiiiii/android-labs-2020/blob/master/students/net1814080903113/test1.1.png)

# 五、实验心得 #
第一次实验主要是学习怎么让本地库和github连接和使用git的指令，需要注意的是在输入地址路径或指令的时候，要善于使用Tab键，减少手打的错误。
