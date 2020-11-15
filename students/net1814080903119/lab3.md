# 一、实验目标
1. 了解Android应用中各种资源的概念与使用方法；
2. 掌握在Android应用中使用图片等资源的方法。

# 二、实验要求
1. 在界面上显示至少一张图片（按照自己的题目添加）；
2. 提交res/drawable及图片使用的代码；
3. 提交res/values, res/layout等其他代码；
4. 将应用运行结果截图，放到实验报告中；
5. 点击图片（或按钮）时，打开另一个Activity。

# 三、实验步骤
1. 找到对应图片，修改为jpg格式，放在drawable目录下。
![实验截图](https://raw.githubusercontent.com/Lj-xinfei/android-labs-2020/0ab644b3cda2c438afc9d8acd516c9e1b45f178e/students/net1814080903119/lab3.1.jpg)
2. 在对应的activity里加图片的索引，
```java
int[] photos = {R.drawable.tu1, R.drawable.tu2, R.drawable.tu3, R.drawable.tu4}；
```
![实验截图](https://raw.githubusercontent.com/Lj-xinfei/android-labs-2020/0ab644b3cda2c438afc9d8acd516c9e1b45f178e/students/net1814080903119/lab3.2.jpg)
3. 利用点击事件实现不同图片的轮流展示。
![实验截图](https://raw.githubusercontent.com/Lj-xinfei/android-labs-2020/0ab644b3cda2c438afc9d8acd516c9e1b45f178e/students/net1814080903119/lab3.3.jpg)
# 四、实验结果
![实验截图](https://raw.githubusercontent.com/Lj-xinfei/android-labs-2020/0ab644b3cda2c438afc9d8acd516c9e1b45f178e/students/net1814080903119/lab3.3.jpg)
# 五、实验心得
学习了设置背景图片，修改图片格式，在layout（design）那可以对图片进行调整，也可以利用ImageView进行设置。
