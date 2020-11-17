# 实验四      
## 一、实验目标  
1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。
## 二、实验内容  
1. 使用一种布局方式设计界面； 
2. 通过控件ID获取界面对象，执行相关操作：
```
//XML
android:id="@+id/my_button"
//java
findViewById(R.id.my_button);
```
3. 实现界面控件的事件处理;
4. 操作之后，切换到第二个界面。
## 三、实验步骤  
1. 在activity_main中实现线性布局，在activity_sell实现相对布局，并添加可编辑文本以及按钮，在activity_manage使用线性布局，添加Listview控件；
2.在ManageActivity中添加代码；
```
ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                ManageActivity.this,android.R.layout.simple_list_item_1,data);

        ListView listView=(ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
```
## 四、实验结果  
## 五、实验心得  
这个实验也还好
&#160; &#160;这个实验就是给界面添加资源，添加图片就好了，还是很简单的。
