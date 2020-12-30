# 一、实验目标

1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。**（不要做登录注册！）**

# 二、实验内容

1. 使用其中一种布局方式，**设计所选题目的界面**，建议用LinearLayout。

- LinearLayout, RelativeLayout, Adapter, ConstraintLayout (自学)

2. 通过控件ID获取界面对象，执行相关操作：

```xml
// XML
android:id="@+id/my_button"
// Java
findViewById(R.id.my_button);
```

3. 实现界面控件的事件处理，例如点击按钮：

```java
public class MainActivity extends Activity  implements OnClickListener {    
    // ......   
    @Override    
    public void onClick(View v) { 
    // ......
```

4. 操作之后，切换到你的第二个界面。

# 三、实验步骤

1. 在主布局xml文件中设计布局：

   ```xml
   android:id="@+id/foundit_main_my_iv"
   ```

   这是跳转到个人页面的图标id，下图为布局效果。

   ![图片2](https://github.com/jaydjxing/android-labs-2020/blob/master/students/net1814080903317/lab2-1.png?raw=true)



2. 在java代码中找到控件，并设置为成员变量：

   ```java
   private ImageView myIv;
   ```

   ```java
   myIv = findViewById(R.id.foundit_main_my_iv);
   ```

3. 设置点击事件的监听器，完成跳转。

   ```java
   myIv.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           myStartActivity(Net1814080903317FoundItMainActivity.this,Net1814080903317FoundItMyActivity.class);
       }
   });
   ```

   ```java
   public void myStartActivity(Context context,Class _class){
       Intent intent=new Intent(context,_class);
       startActivity(intent);
   }
   ```

   因为其中不止只跳转一个页面，所以把相同的代码抽象出来。Intent对象的两个参数：arg1：本Activity的上下文对象；arg2：要跳转的Activity的class（类名.class）。实现跳转。



# 四、实验结果

   成功跳转到个人页面：

![图片3](https://github.com/jaydjxing/android-labs-2020/blob/master/students/net1814080903317/lab2-2.png?raw=true)

# 五、实验心得体会

这次的实验难度不大，主要是注意的是跳转的时候，如果没跳转，并且闪退了，一般是AndroidManifest.xml上面没有添加Activity，布局这些要得做好看，得需要一定的经验，所以多加练习，多看看网上别人的优秀的代码，java代码中，完成跳转的话需要理解Intent对象，还有使用Intent对象实现不同Activity之间的传值，使用intent.put()，或者bundle等封装数据，根据实际情况进行代码的设计以及编写。