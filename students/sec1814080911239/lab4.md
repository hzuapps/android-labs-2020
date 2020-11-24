# 实验四

## 一、 实验目标

1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。

## 二、 实验内容

1. 使用其中一种布局方式，设计所选题目的界面，建议用LinearLayout。

- LinearLayout, RelativeLayout, Adapter, ConstraintLayout (自学)

2. 通过控件ID获取界面对象，执行相关操作：

```
// XML
android:id="@+id/my_button"
// Java
findViewById(R.id.my_button);
```

3. 实现界面控件的事件处理，例如点击按钮

```
public class MainActivity extends Activity  implements OnClickListener {    
    // ......   
    @Override    
    public void onClick(View v) { 
    // ......
```

4. 操作之后，切换到你的第二个界面。

## 三、 实验步骤

1. activity_main.xml使用Linearlayout布局，设置各控件属性，调整控件大小、位置（代码以一个控件为例）

   ```java
   <Button
           android:layout_width="300dp"
           android:layout_height="50dp"
           android:layout_gravity="center_vertical"
           android:layout_marginStart="60dp"
           android:layout_marginLeft="60dp"
           android:layout_marginTop="250dp"
           android:background="@color/colorbackground"
           android:text="交流分享社区"
           android:textColor="@color/colortext"
           android:textStyle="bold"/>
   ```

   

2. activity_solve.xml嵌套布局，将Button和EditText放在合理的位置

   ```java
   <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
       ...>
   
       <RelativeLayout
           android:layout_width="match_parent"
           android:layout_height="wrap_content">
   
       <Button
           android:id="@+id/solve"
           android:layout_width="100dp"
           android:layout_height="110dp"
           android:layout_alignParentRight="true"
           android:layout_alignParentBottom="true"
           android:background="@drawable/solve" />
               
   	...
               
       </RelativeLayout>
   
       <EditText
           android:layout_width="match_parent"
           android:layout_height="wrap_content"
           android:hint="@string/search"
           android:inputType="none"
           ></EditText>
   
   </RelativeLayout>
   
   
   ```

   

3. 在activity_solve.xml添加EditView控件实现文本的输入

   ```java
   <EditText
           android:layout_width="match_parent"
           android:layout_height="wrap_content"
           android:hint="@string/search"
           android:inputType="none"
           ></EditText>
   ```

   

4. activity_knowledge.xml的布局和activity_solve.xml布局相同，直接用include引用布局

   ```java
   <include layout="@layout/activity_solve"/>  //引用相同布局
   ```

5. 在Sec1814080911239MainActivity.java将按钮上的文字打包，将其带到对应的页面并作为跳转页面的标题（代码以一个按钮为例）

   ```java
   		//找到文字	
   		TextView mTextView_share =(TextView)findViewById(R.id.button1);  
           //取出文字
           final String mstring_share = mTextView_share.getText().toString();
   
           findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   switch (view.getId()) {
                       case R.id.button1:
                           Intent intent = new Intent(Sec1814080911239MainActivity.this, ShareActivity.class);
                           intent.putExtra("mstring_share",mstring_share);
                           startActivity(intent);
                           break;
                   }
   
               }
           });
   ```

   

   

6. 在对应的跳转页面打开传送过来的文字

   ```java
    //接收文字
           Intent intent = getIntent();
           if(intent !=null){
               String string_share = intent.getStringExtra("mstring_share");
               setTitle(string_share);
           }
   ```

   

7. 在SplashActivity.java设置延缓作为启动页面时的加载

   ```java
   //调用postDelayed方法，设置延缓
       mHandler.postDelayed(new Runnable() {
           @Override
           public void run() {
               Intent intent = new Intent(SplashActivity.this,Sec1814080911239MainActivity.class);
               startActivity(intent);
           }
       },2000);    //延缓时间2s
   ```

## 四、 实验结果

![知识库](https://github.com/jalyn-1001/mytest/blob/master/sec1814080911239/KnowledgeActivity3.png)

图1. 知识库

![交流分享社区](https://github.com/jalyn-1001/mytest/blob/master/sec1814080911239/ShareActivity3.png)

图2. 交流分享社区

![疑难解答](https://github.com/jalyn-1001/mytest/blob/master/sec1814080911239/SolveActivity3.png)

图3. 疑难解答

![文本输入](https://github.com/jalyn-1001/mytest/blob/master/sec1814080911239/search.png)

图4. 文本输入

## 五、 实验心得体会

​	TextView控件的内容在程序运行时显示出来的东西是固定不能变的，EditView控件在程序运行时是可以输入文本的。

​	如果两个页面的布局相同的话，可以使用<include layout="...">  直接引用另一个页面的布局。

​	实现将文字从一个页面带到另一个页面，要在原先的页面对文字进行打包，之后在跳转的另一个页面打开传过来的包。
