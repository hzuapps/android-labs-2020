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
        Button btn1 = (Button)findViewById(R.id.button);
     final MainActivity thisActivity = this;
     btn1.setOnClickListener(new View.OnClickListener(){
         public void onClick(View v){
             Intent intent = new Intent(thisActivity,PersonalHomeActivity.class);
             thisActivity.startActivity(intent);
         }
     });
```
# 四、实验结果
!

# 五、实验心得
这次实验主要学习如何点击事件跳转页面，首先建立对应的Activity界面，在相应的layout文件视图中添加按钮，并在java中实现转跳。初步学习了如何添加并使用事件，还要继续努力。
