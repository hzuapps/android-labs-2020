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
super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.btn_button);
        button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Net1814080903314Activity.this , ButtonActivity.class);
            startActivity(intent);
    }
});
```
# 四、实验结果
![实验截图](https://github.com/AzStartie/android-labs-2020/blob/master/students/net1814080903314/Exp02.png)

# 五、实验心得
这次实验主要学习了如何添加并使用事件，通过使用Button类和配置相应的xml来完成按钮的页面跳转，需要新建页面，从主页面跳转到第二个页面，实验完成度还行，仍需继续努力。
