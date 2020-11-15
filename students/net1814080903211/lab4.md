# 实验四：Android界面设计编程

## 一、实验目标

1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。

## 二、实验要求

1. 使用一种布局方式，设计所选题目的界面，建议使用LinearLayout。
2. 通过控件ID获取界面对象，执行相关操作。
3. 实现界面控件的事件处理，例如点击按钮。

## 三、实验步骤

1. 加入应用抽屉，由于应用抽屉使用Fragment显示页面而不是使用Activity，故需要将BrowseActivity和ProfileAcitivity改成SearchFragment与ProfileFragment，还需要写相应的SearchViewModel和ProfileViewModel，以及新增HomeFragment与HomeViewModel显示主页；
2. 删除BrowseActivity.java与ProfileActivity.ava，及其对应布局layout_browse.xml与layout_profile.xml；
3. 创建SearchFragment.java、SearchViewModel.java与对应布局fragment_search.xml，SearchFragment使用ConstraintLayout、CardView与RecyclerView完成搜索页面的显示，同时还有协助类SearchResult.java结构化搜索结果；
4. 创建ProfileFragment.java、ProfileViewModel.java与对应布局fragment_profile.xml，ProfileFragment使用GridLayout完成档案编辑页面的显示。
5. 创建HomeFragment.java、HomeViewModel.java与对应布局fragment_home.xml，HomeFragment是用ConstraintLayout、CardView与RecyclerView完成主页的显示，同时还有协助类ChatObject.java结构化聊天对象；
6. 创建mobile_navigation.xml指导抽屉进行页面跳转，activity_main_drawer.xml布局抽屉的内部组件；
7. 为了让RecyclerView显示列表更美观，需要一个ItemDecoration类用于设定列表内元素的间距，故创建协助类ListSeparator.java。
8. 提交文件。

## 四、实验结果

![home](https://raw.githubusercontent.com/Xterisk/android-labs-2020/master/students/net1814080903211/lab4-1.png)
![search](https://raw.githubusercontent.com/Xterisk/android-labs-2020/master/students/net1814080903211/lab4-2.png)
![profile](https://raw.githubusercontent.com/Xterisk/android-labs-2020/master/students/net1814080903211/lab4-3.png)
![drawer](https://raw.githubusercontent.com/Xterisk/android-labs-2020/master/students/net1814080903211/lab4-4.png)

## 五、实验心得

本次实验有些难度，但主要是在生成的文件结构里做一些修改，还有在做的过程中解除了一些xml数据绑定的用法，以及View Model的写法。
