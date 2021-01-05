# 一、实验目标
1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。（不要做登录注册！）
# 二、实验内容
1. 使用其中一种布局方式，设计所选题目的界面，建议用LinearLayout。
2. 通过控件ID获取界面对象，执行相关操作：
``` 
//xml
Android:id=”@+id/my_button”
//java
findViewById(R.id.my_button);

```
2. 实现界面控件的事件处理，例如点击按钮 
```
public class MainActivity extends Activity  implements OnClickListener {    
    // ......   
    @Override    
    public void onClick(View v) { 
    // ......
```

# 三、实验步骤
1. 利用LinearLayout布局在Net1814080903239Activity主页面添加两个按钮，分别为“查看房源”、“添加房源”
2. 点击“查看房源”进入showhouse.xml页面，此页面有3个房源，分别为3个按钮，点击任一个按钮可进入相应的房屋信息页面，比如点击“万科城”这个按钮，就会跳转到wankechen.xmly页面，这个页面有万科城这栋房子的基本信息，比如面积、地址、价格等，确定租房即点击“租房”按钮就会跳转到renthouse.xml,提示租房成功，不租则返回主页面。
3. 点击“添加房源”，跳转到addahouse.xml页面，利用LinearLayout布局设置5个编辑文档，输入相关信息（房名、地址、面积、价格、户型等），点击“添加”，即可添加房源。然后回到主页面
4. 以上的布局都是使用LinearLayout布局
# 四、实验结果
![截图1](https://raw.githubusercontent.com/Joanwjk/android-labs-2020/master/students/net1814080903239/sy4.1.png)  

![截图2](https://raw.githubusercontent.com/Joanwjk/android-labs-2020/master/students/net1814080903239/sy4.2.png)  

![截图3](https://raw.githubusercontent.com/Joanwjk/android-labs-2020/master/students/net1814080903239/sy4.3.png)

![截图4](https://raw.githubusercontent.com/Joanwjk/android-labs-2020/master/students/net1814080903239/sy4.4.png)

# 五、实验心得
这次实验主要是对完善自己的页面设计，大部分是通过点击按钮来达到各个页面的跳转，对LinearLayout布局的应用与之前相比也比较熟悉了，希望下次可以试试用更灵活的布局来实现相同的效果。
