# 实验四 Android界面设计编程 
## 一、实验目标
1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。（不要做登录注册！）
## 二、实验内容
1. 了解界面的几种布局：LinearLayout, RelativeLayout, Adapter, ConstraintLayout (自学）
2. 使用其中一种布局方式进行自己所选题目的界面的设计，建议用LinearLayout
3. 通过控件ID获取界面对象，执行相关操作：
``` // XML
android:id="@+id/my_button"
// Java
findViewById(R.id.my_button);
``` 
4. 实现界面控件的事件处理，例如点击按钮：
``` public class MainActivity extends Activity  implements OnClickListener {    
   // ......   
    @Override    
    public void onClick(View v) { 
    // ......
``` 
5. 操作之后，切换到你的第二个界面。
## 三、实验步骤
1. 选取LinearLayout布局方式，为选择题目的各个界面进行设计
2. 修改三个布局为LinearLayout，在应用开始主页中添加一个按钮“开始进入”，点击进入activity_record.xml界面，
3. 在activity_record.xml这个界面可以记录生日人的姓名、生日等相关信息，此界面中有两个按钮，分别是“确定添加”和“查看信息”，点击“确定添加”保存记录的信息，而点击“查看信息”则可以查看已经记录的信息，这里已经有了三天记录：张三，李芳和王五。
4. 在发出生日提醒中添加两个按钮，分别是“确定”，“稍后提醒”，点击分别是返回主页面
## 四、实验结果
## 五、实验心得体会
这次实验是对选题的需要界面的设计，原来只有三个界面，后来考虑到还需要有一个查看记录后的信息的界面，于是又添加多了一个information界面，后来在提交代码到GitHub上面出现了一个问题，总是登录不上去并且代码也还没有提交上去，后面我找到了解决方法再和后面的实验代码一起提交吧
