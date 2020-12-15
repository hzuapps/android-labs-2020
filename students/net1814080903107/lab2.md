# 一、实验目标

1. 创建2-3个与自己选题有关的Activity
2. 利用Intent实现Activity间的跳转

# 二、实验内容

1. 根据功能创建相应的Activity；
2. 编写Activity对应的布局文件；
3. 实现各个Activity之间的跳转;

# 三、实验步骤

1. 创建Activity和XML文件，在Activity链接XML文件

   ```
   setContentView(R.layout.activity_store);
   ```

   在AndroidManifest.xml里注册Activity，并且添加应用权限

   ```
   <uses-permission android:name="android.permission.INTERNET"/>
   <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
   ...
   <activity android:name=".StoreActivity" />
   ```

2. 在主Activity的View添加点击事件或添加监听器

   ```
   public void clickStore(View v){
           Intent newPage=new Intent(Net1814080903107Activity.this,StoreActivity.class);
           LinearLayout l1=(LinearLayout)v;
           LinearLayout l2=(LinearLayout)l1.getChildAt(1);
           CharSequence title=((TextView)(l2.getChildAt(0))).getText();
           newPage.putExtra("title",title);
           newPage.putExtra("id",((MyLinearLayout)(v)).getid());
           startActivity(newPage);
       }
   ```

# 四、实验结果

[![lab2_1](https://raw.githubusercontent.com/Howard-SSS/android-labs-2020/master/students/net1814080903107/screenshots/lab2_1.PNG)](https://raw.githubusercontent.com/Howard-SSS/android-labs-2020/master/students/net1814080903107/screenshots/lab2_1.PNG)

[![lab2_2](https://raw.githubusercontent.com/Howard-SSS/android-labs-2020/master/students/net1814080903107/screenshots/lab2_2.PNG)](https://raw.githubusercontent.com/Howard-SSS/android-labs-2020/master/students/net1814080903107/screenshots/lab2_2.PNG)

# 五、实验心得

本次实验用Intent实现页面之间跳转，并且用putExtra导入Intent，显现页面跳转传值；在Activity设置监听器，可以动态的设置页面新组件的事件，而XML设置点击属性，适用于静态页面。