# 一、实验目标

1. 根据选题要求设计界面布局及控件使用
2. 布局xml及界面控制操作代码提交并截图
3. 将应用运行结果截图
# 二、实验内容

1. 选择布局方式布局界面中的控件
2. 使用适配器将数据循环展示到界面上
3. 基本完善选题内容

# 三、实验步骤

1. 使用LinearLayout布局Net1814080903210Activity、CommendActivity、NewsInfoActivity
2. 使用LinearLayout的orientation属性实现水平和垂直排列的效果
3. 在activity_main.xml中创建ListView
4. 创建SimpleAdapter适配器
5. 为适配器准备数据，包括新闻标题数组和图片id
6. 创建activity_main_item.xml，其中包括TextView和ImageView
7. 通过SimpleAdapter建立数据与activity_main_item.xml中对应组件的连接
8. 运行显示结果
# 四、实验结果

![result](https://raw.githubusercontent.com/Playerlhh/android-labs-2020/master/students/net1814080903210/lab4_res.png)

# 五、实验心得

&#160; &#160; &#160; &#160;通过这次实验，我将需要重复展示的内容使用适配器循环显示出来，所以以后遇到需要重复的组件，不需要手动去复制代码，只需要通过适配器配置数据和组件的映射关系即可。
