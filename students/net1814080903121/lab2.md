# 一、实验目标 #

1. 创建2-3个与自己选题有关的Activity
2. 利用Intent实现Activity间的跳转

# 二、实验内容 #

1. 根据功能创建相应的Activity
2. 编写AndroidManifest.xml
3. 编写Activity对应的布局文件
4. 编写Activity的Java代码
5. 使用Intent实现跳转

# 三、实验步骤 #

1. 将创建的Activity注册到AndroidManifest.xml
2. 在布局文件中创建Button并赋予ID
3. 通过ID获取Button
4. 为Button增加点击事件处理
5. 利用Intent绑定跳转类
6. 利用startActivity(intent)实现跳转

# 四、实验结果 #

![按钮绑定事件 点击事件函数](https://raw.githubusercontent.com/15218047860/android-labs-2020/master/students/net1814080903121/lab2.png)

# 五、实验心得 #

本次实验要求实现界面的跳转，以及了解AndroidManifest.xml的一些配置信息，理清思路，从xml新建Button并赋予id 再到Activity关联xml的button资源（btn_return=findViewById(R.id.btn_return);）、
绑定并实现点击事件，理解过程后，实验是不难的。
