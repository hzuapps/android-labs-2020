# 一、实验目的

1. 创建2-3个与自己选题有关的Activity

2. 利用Intent实现Activity间的跳转

# 二、实验内容

1. 根据功能创建相应的Activity

2. 编写Activity对应的布局文件

3. 实现各个Activity之间的跳转

# 三、实验步骤

1. 创建功能类-MainActivity、ViewActivity、NetAboutActivity、SettingsActivity

2. 将创建的Activity注册到AndroidManifest.xml

3. 在MainActivity的layout视图中添加Button按钮用于跳转页面

4. 为Button按扭添加Click点击事件实现跳转
   ```java
           Button btn1 = (Button)findViewById(R.id.button);
       final Net1814080903216MainActivity thisActivity = this;
        btn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(thisActivity,Net1814080903216ViewActivity.class);
                thisActivity.startActivity(intent);
            }
        });
   ```

# 四、实验结果

 ![实验截图](https://raw.githubusercontent.com/Xiaohuang-12/android-labs-2020/master/students/net1814080903216/lab2.png)

# 五、实验心得
这次实验主要是确定好自己要写的项目的功能，确定好功能之后创建类考虑怎么实现这些功能。这节课学到了怎么按钮跳转，这个功能基本上都需要用到，很实用。
