# 一、实验报告

1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。

# 二、实验内容

1. 使用一种布局方式设计界面；
2. 通过控件ID获取界面对象，执行相关操作：
3. 实现界面控件的事件处理;
4. 操作之后，切换到第二个界面。

# 三、实验步骤

1. 所有页面均采用`constraintlayout`布局，插入自己要用的控件；

2. 在Net1814080903205WorkUnLendActivity的layout文件视图中使用`IMageView`用于跳转页面； 

3. 为按键添加事件处理；

   ```java
   ImageView lendMap=(ImageView)findViewById(R.id.scanWin);
           lendMap.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   String lendid= LendFunction.getbinarynumber();//扫描二维码的函数，返回二维码中存储的充电宝编号
                   //初始化Lend标志
                   SharedPreferences sharedPreferences = getSharedPreferences("status", Context.MODE_PRIVATE);
                   SharedPreferences.Editor editor = sharedPreferences.edit();//获取编辑器
                   editor.putString("lendid", lendid);
                   editor.commit();//提交修改
   
                   Intent intent=new Intent();
                   intent.setClass(Net1814080903118WorkUnLendActivity.this,Net1814080903118LendAckActivity.class);
                   startActivity(intent);
               }
           });
   ```

# 四、实验结果

![实验截图](https://raw.githubusercontent.com/luo-2/android-labs-2020/master/students/net1814080903205/lab4.png)

# 五、实验心得

  本次的实验比较简单，主要是为了让我们能够熟练的为`View`对象提交触发事件。
