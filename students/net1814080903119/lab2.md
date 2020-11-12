# 一、实验目标
1. 创建2-3个与自己选题有关的Activity
2. 利用Intent实现Activity间的跳转
# 二、实验内容
1. 根据功能创建相应的Activity；
2. 编写Activity对应的布局文件；
3. 实现各个Activity之间的跳转;
# 三、实验步骤
1. 创建三个Activity（名字自取）；
Net1814080903119Activity.java。
功能1Activity.java：.Activity.java。
功能2Activity.java：.Activity.java。
AndroidManifest.xml。
2. 在AndroidManifest.xml添加虚拟机打开时所需权限，添加所创三个activity的配置代码；如：<activity android:name=".activity名字"></activity>
3. 在各个activity借用Intent方法添加点击事件，实现跳转；
button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(_this, 功能1Activity.class);
                _this.startActivity(intent);
            }
        });

# 四、实验结果
![activity建立](https://raw.githubusercontent.com/Lj-xinfei/android-labs-2020/044b6c7d13a9e6c6e5b2d3b66ca3404b1d972e31/students/net1814080903119/lab2.1.jpg)
![跳转](https://raw.githubusercontent.com/Lj-xinfei/android-labs-2020/044b6c7d13a9e6c6e5b2d3b66ca3404b1d972e31/students/net1814080903119/lab2.2.jpg)
# 五、实验心得
学会利用点击事件进行页面跳转。
