# 一、实验目标

1. 创建2-3个与自己选题有关的 Activity ；
2. 利用 Intent 实现 Activity 间的跳转。

# 二、实验内容

1. 根据项目功能创建相应的 Activity ；
2. 编写 AndroidManifest.xml ；
3. 编写 Activity 对应的布局文件；
4. 编写 Activity 的 JAVA 代码；
5. 使用 Intent 实现界面跳转功能。

# 三、实验步骤

1. 创建 MainActivity(主界面)、SetActivity(设置界面)、GameActivity(游戏界面)；
2. 将创建的 Activity 注册到 AndroidManifest.xml 中；
3. 在布局文件中创建 Button 组件；
4. 为 Button 添加点击事件处理；
5. 通过 startActivity(Intent) 实现界面跳转。

# 四、实验结果

![实验二结果](https://raw.githubusercontent.com/LookerSong/android-labs-2020/master/students/net1814080903230/E2.png)

# 五、实验心得体会

这次实验有一定难度，其中要注意的是除 MainActivity 之外的其他 Activity 都需要自己手动注册到 AndroidManifest.xml 中，否则会出现项目代码没有报错但无法启动应用的情况，这个地方需要留意。
