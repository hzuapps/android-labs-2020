# 一、实验目的

1.创建2-3个与自己选题有关的Activity  
2.利用Intent实现Activity间的跳转

# 二、实验内容

1.根据功能创建相应的Activity  
2.编写Activity对应的布局文件  
3.实现各个Activity之间的跳转

# 三、实验步骤

1.将创建的Activity注册到AndroidManifest.xml  
2.在MainActivity的layout视图中添加Button按钮用于跳转页面  
3.为Button按扭添加Click点击事件实现跳转
```
        Button button1 = (Button)findViewById(R.id.button);
     final Net1814080903330Activity thisActivity = this;
     button1.setOnClickListener(new View.OnClickListener(){
         public void onClick(View v){
             Intent intent = new Intent(thisActivity,Net1814080903330Activity.class);
             thisActivity.startActivity(intent);
         }
     });
```
# 四、实验结果
!

# 五、实验心得
本次实验一共填写了3个功能，主界面Net1814080903330.java、功能分别为CollectionActivity.java、PlayActivity.java、SearchActivity.java，功能实现跳转做起来也挺简单的。
