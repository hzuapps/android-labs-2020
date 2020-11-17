# 实验二  
## 一、实验目标  
1. 在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2020/issues ；
2. 根据自选题目，编写一个或多个Activity（主窗口类带上学号前缀，放到自己的Java包下）；
3. 将标题设置为自己的学号+对应的功能或题目；
4. 根据自己选择的题目实现Activity中导航、调用等功能（选做）。
## 二、实验内容  
1. 在Issues上创建选题，确定要做的功能； 
2. 在Android studio创建项目； 
3. 创建三个以功能命名的java类以及各自的xml文件； 
4. 编写跳转代码，把几个页面链接起来；    
5. 提交代码并合并请求。 
## 三、实验步骤  
1. 创建主界面MainActivity、管理闲置界面ManageActivity、发布闲置界面SellActivity以及各自的布局界面activity_main.xml、activity_manage.xml、activity_sell.xml；
2. 在activity_main.xml只添加button1（管理闲置）、button2（发布闲置）；
3. 在MainActivity中添加代码实现跳转;
```
Button button_manage = (Button) findViewById(R.id.button1);
        final MainActivity thisActivity1 = this;
        button_manage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent1 = new Intent(thisActivity1,ManageActivity.class);
                MainActivity.this.startActivity(intent1);
            }
        });
```
```
 Button button_sell = (Button) findViewById(R.id.button2);
        final MainActivity thisActivity2 = this;
        button_sell.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent2 = new Intent(thisActivity2,SellActivity.class);
                MainActivity.this.startActivity(intent2);
            }
        });
```
4. 在activity_manage.xml、activity_sell.xml中添加TextView文本来表明是哪一个按钮的跳转页面。
## 四、实验结果  
## 五、实验心得  
&#160; &#160;这个实验不是很难，只要理解了跳转代码怎么实现就好了，但是我做了很久，因为一直跳转不成功，开始还以为是界面的布局不妥当导致的秒退，结果是AndroidManifest.xml缺了代码。
