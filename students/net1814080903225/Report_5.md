# 一、实验目标 #
1. 了解Andoid的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储
# 二、实验内容 #
1. 将应用产生的数据保存到文件存储中；
2. 说明使用的文件存储方式：内部 or 外部；
3. 将运行结果截图
# 三、实验步骤 #
1. 创建一个空activity文件，名字为activity_stock_test.xml
2. 在activity设置布局为LinearLayout，设置4个组件，分别是输入框、存储按钮、读出按钮、显示区
3. 为两个按钮根据不同ID分别绑定两个点击事件，用于存取和读出
   ```java
   @Override
       public void onClick(View v) {
           //当前组件对应的就是v
           switch (v.getId()) {
               case R.id.btn_write:
                   try {
                       //将文件数据写入到应用的内部存储
                       FileOutputStream fos = openFileOutput(name, Context.MODE_PRIVATE);
                       //封装文件输出流并设置编码方式为UTF8
                       OutputStreamWriter osw = new OutputStreamWriter(fos,"utf-8");
                       //获取输入的内容并写入文件中
                       osw.write(et.getText().toString());
                       //对两个流进行刷新清空
                       osw.flush();
                       fos.flush();
                       //关闭流
                       osw.close();
                       fos.close();
                       //提示弹框
                       Toast t=Toast.makeText(getApplicationContext(),"存储成功！",Toast.LENGTH_LONG);
                       t.setGravity(Gravity.CENTER_VERTICAL,40,0);
                       t.show();
                   } catch (Exception e) {
                       e.printStackTrace();
                   }
                   break;
               case R.id.btn_read:
                   try {
                       //将输入流与存储文件绑定
                       FileInputStream fis = openFileInput(name);
                       InputStreamReader isr = new InputStreamReader(fis,"utf-8");
                       //用char数组接收，大小通过available()确定
                       char input[] = new char[fis.available()];
                       //将文件读取到input中
                       isr.read(input);
                       //关闭流
                       isr.close();
                       fis.close();
                       String readed = new String(input);
                       //回显
                       tv.setText(readed);
                   } catch (Exception e) {
                       e.printStackTrace();
                   }
                   break;
           }
       }
   ```
# 四、实验结果 #
![result](https://raw.githubusercontent.com/ZYL618/android-labs-2020/master/students/net1814080903225/lab_5/result.png)

# 五、实验心得 #

本次实验主要是输入输出流的操作，在Java中有一定基础，因此理解起来不是很困难。本次实验中用到了```openFileOutput(name, Context.MODE_PRIVATE)```，这是安卓特有的部分；另外也启用了弹框功能```Toast t=Toast.makeText(getApplicationContext(),"存储成功！",Toast.LENGTH_LONG);```，类似于JavaScript中的alert窗口，起到提醒作用。

