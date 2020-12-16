# 一、实验目标

 1.创建2-3个与自己选题有关的Activity；   
 2.利用Intent实现Activity间的跳转
 
# 二、实验内容
1.根据自己的选题功能，创建 2-3 个 Activity；    
2.在 Activity 上添加按钮、链接或导航栏，实现各个 Activity 的跳转；  
3.编写Activity对应的布局文件；  
4.在 Net123456Activity.java 添加按钮点击事件处理，实现跳转 

# 三、实验步骤
1.创建相应的Activity和xml文件；  
2.在AndroidManifest.xml配置相关的信息;
``` 
android:label="校园树洞"  
activity android:name=".PostActivity"   
activity android:name=".TreeholdActivity"  
``` 
3.在Net1814080903116Activity中添加跳转按钮的代码  
``` 
bindActivityButton(R.id.postButton, PostActivity.class);  
bindActivityButton(R.id.treeHoldButton, TreeholdActivity.class);  

Button button = (Button)findViewById(ButtonId);  
final Net1814080903116Activity thisActivity = this;  
button.setOnClickListener(new View.OnClickListener() {  
@Override  
public void onClick(View view) {  
Intent intent = new Intent(thisActivity,activity);  
thisActivity.startActivity(intent);  
}  
});  
``` 
![lab2.1](https://github.com/Dlmdp/android-labs-2020/blob/master/students/net1814080903116/src/main/2.1.PNG)

# 四、实验结果
![lab2](https://github.com/Dlmdp/android-labs-2020/blob/master/students/net1814080903116/src/main/lab2.PNG)
# 五、实验心得
学会了使用按钮来进行页面跳转的操作，在过程中遇到了如按钮无反应等问题，在查找相关的资料后发现是缺少跳转功能的部分代码。
