# 一、实验报告

1. 创建2-3个与自己选题有关的Activity
2. 利用Intent实现Activity间的跳转

# 二、实验内容

1. 根据功能创建相应的Activity；
2. 编写Activity对应的布局文件；
3. 实现各个Activity之间的跳转;

# 三、实验步骤

1. 将创建的Activity注册到AndroidManifest.xml；

2. 在Net1814080903220MainActivity的layout文件视图中添加Button按钮用于跳转页面； 

3. 为按键添加事件处理；

   ```java
           Button navPersonalBtn1=(Button)findViewById(R.id.navPersonalBtn1);
           navPersonalBtn1.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent=new Intent();
                   intent.setClass(Net1814080903118WorkUnLendActivity.this,Net1814080903118PersonalActivity.class);
                   startActivity(intent);
               }
           });
   ```



4. 利用startActivity(intent)实现跳转；

# 四、实验结果

![实验截图](https://raw.githubusercontent.com/luo-2/android-labs-2020/master/students/net1814080903205/lab2.png)

# 五、实验心得

  这次的实验比较简单，只要是实现Activity之间的相互有序跳转。
