# 实验四
## 一、实验目标

1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。（不要做登录注册！

## 二、实验内容

1. 使用其中一种布局方式，设计所选题目的界面(LinearLayout, RelativeLayout, Adapter, ConstraintLayout (自学))
2. 通过控件ID获取界面对象，执行相关操作：
3. 实现界面控件的事件处理，例如点击按钮：
4. 操作之后，切换到你的第二个界面。

## 三、实验步骤

1. 修改build.gradle，使用官方的Material Design风格控件构建底部导航栏 (Navigation)

在dependencies加入下列内容

```gradle
// Navigation
implementation 'androidx.navigation:navigation-fragment:2.3.1'
implementation 'androidx.navigation:navigation-ui:2.3.1'
// Feature module Support
implementation "androidx.navigation:navigation-dynamic-features-fragment:2.3.1"
implementation 'androidx.legacy:legacy-support-v4:1.0.0'
// Testing Navigation
androidTestImplementation "androidx.navigation:navigation-testing:2.3.1"
```

2. 在res中创建新文件夹 navigation，并在文件夹navigation中创建 Navigation Resource File，命名为nav_graph.xml

[![B7Pvbn.png](https://s1.ax1x.com/2020/11/09/B7Pvbn.png)](https://imgchr.com/i/B7Pvbn)

3. 在视图模式中创建新 destination

[![B7iEr9.png](https://s1.ax1x.com/2020/11/09/B7iEr9.png)](https://imgchr.com/i/B7iEr9)

4. 此处自动转为创建新Fragment，由于 navigation bar 的特殊性，其控制的页面需要使用Fragment实现

[![B7i3KH.png](https://s1.ax1x.com/2020/11/09/B7i3KH.png)](https://imgchr.com/i/B7i3KH)

5. 继续以创建，并把之前所做的实验的Activity删去

[![B7iIsJ.png](https://s1.ax1x.com/2020/11/09/B7iIsJ.png)](https://imgchr.com/i/B7iIsJ)

6. 在res中创建新文件夹 menu，并在文件夹menu中创建 Menu Resource File，命名为menu_bottom_nav.xml

[![B7FR0A.png](https://s1.ax1x.com/2020/11/09/B7FR0A.png)](https://imgchr.com/i/B7FR0A)

7. 修改menu_bottom_nav.xml，手动添加item项目，并注意item的id属性要与nav_graph.xml中的相匹配

[![B7AQ2T.png](https://s1.ax1x.com/2020/11/09/B7AQ2T.png)](https://imgchr.com/i/B7AQ2T)

8. 最后修改activity_main.xml，引入Bottom Navigation

[![B7AsqH.png](https://s1.ax1x.com/2020/11/09/B7AsqH.png)](https://imgchr.com/i/B7AsqH)

9. 注意修改主Activity，并注册相关组件

[![B7AoLQ.png](https://s1.ax1x.com/2020/11/09/B7AoLQ.png)](https://imgchr.com/i/B7AoLQ)

10. 设计fragment_submission的界面

[![B7AOJ0.png](https://s1.ax1x.com/2020/11/09/B7AOJ0.png)](https://imgchr.com/i/B7AOJ0)

11. 引入recyclerview，首先在build.gradle中引入最新版的recyclerview

```gradle
// RecyclerView
implementation "androidx.recyclerview:recyclerview:1.1.0"
```

12. 为recyclerview中所需显示的对象创建类与适配器

[![B7EtOg.png](https://s1.ax1x.com/2020/11/09/B7EtOg.png)](https://imgchr.com/i/B7EtOg)

13. 最后设计fragment_word_list的界面

[![B7EhkR.png](https://s1.ax1x.com/2020/11/09/B7EhkR.png)](https://imgchr.com/i/B7EhkR)

## 四、实验结果

[![B7Vn3V.png](https://s1.ax1x.com/2020/11/09/B7Vn3V.png)](https://imgchr.com/i/B7Vn3V)

[![B7VBHH.png](https://s1.ax1x.com/2020/11/09/B7VBHH.png)](https://imgchr.com/i/B7VBHH)

## 五、实验心得

　　本次实验主要使用了官方的Material Design风格控件构建底部导航栏，由于这个控件比较新，国内的教程还没有涉及到，于是经过查阅官方文档和一些国外的视频教程才成功配置了。而Recycleview就是常见的控件了，并不算难。总的来说还是比较顺利的。

