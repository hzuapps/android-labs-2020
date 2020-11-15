# 实验二
## 一、实验目标
1. 创建2-3个与自己选题有关的Activity；
2. 利用Intent实现Activity间的跳转；  
## 二、实验内容
1. 根据功能创建相应的Activity；
2. 编写Activity对应的布局文件；
3. 实现各个Activity之间的跳转; 
## 三、实验步骤
1. 将创建的Activity注册到AndroidManifest.xml；
```xml
<activity android:name=".Net1814080903333StudentsInformationActivity2"/> 
        <activity android:name=".Net814080903333TeacherHomeActivity" />  
        
```
2. 在Net1814080903220MainActivity的layout文件视图中添加Button按钮用于跳转页面； 

3. 为按键添加事件处理；
```java
Button navPersonalBtn1=(Button)findViewById(R.id.navPersonalBtn1);
navPersonalBtn1.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
               Intent intent=new Intent();
                intent.setClass(MainActivity.this,Net1814080903333TeacherHomeActivity.class);
                  startActivity(intent);
   }
   });
   ```
4. 利用startActivity(intent)实现跳转；  
## 四、实验结果
![图1实验二运行结果](https://github.com/yichouge/android-labs-2020/blob/master/students/net1814080903333/lab2.png?raw=true)
## 五、实验心得  
本次实验难度不大、学会如何创建activity、以及xml文件的配置、按钮事件的监听的处理以及实现activity之间的相互跳转、遇到的问题是xml文件命名用大写第一次编译运行能成功、第二次运行提示错误
修改成小写的命名之后就可以正常运行了。

