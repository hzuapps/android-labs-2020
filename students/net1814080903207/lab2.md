# 一、实验目标 #

1. 创建2-3个与自己选题有关的Activity
2. 利用Intent实现Activity间的跳转

# 二、实验内容 #

1. 根据功能创建相应的Activity
2. 简单修改AndroidManifest.xml的配置
3. 编写Activity对应的布局文件
4. 编写Activity的Java代码
5. 使用Intent实现跳转

# 三、实验步骤 #

1. 创造了三个Activity,分别对应背单词功能的首页，背单词页面和错题页面
2. 将创建的Activity注册到AndroidManifest.xml
3. 在布局文件中创建Button并赋予ID
4. 为Button增加点击事件处理
5. 利用Intent intent = new Intent(address, Net1814080903207ReciteActivity.class);address.startActivity(intent);语句来完成页面跳转功能

# 四、实验结果 #

![jump_function](https://raw.githubusercontent.com/522090231/android-labs-2020/master/students/net1814080903207/lab2_answer1.png)
![jump_function](https://raw.githubusercontent.com/522090231/android-labs-2020/master/students/net1814080903207/lab2_answer2.png)

# 五、实验心得 #

本次实验主要创造了新的activity，我认为跳转界面功能在手机上随处可见，所以我认为这是一个很重要的函数，因此对于它的使用我的影响比较深刻。
