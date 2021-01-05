# 实验五

## 一、实验目标
- 了解Andoid的存储手段
- 掌握Android的文件存储
- 掌握Android的数据库存储
## 二、实验内容
- 将应用产生的数据保存到文件存储中
- 说明使用的文件存储方式：内部 or 外部
- 将运行结果截图
## 三、实验步骤
1. 首先确定所需要的存储方式，根据我的项目，不需要太多的数据存储，所以选择了内部存储
2. 确定完存储方式后则进行编程，以下是存储方式的核心代码
   ```java   
            btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File file = new File(thisActivity.getFilesDir(), "lab5.txt");
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    FileOutputStream fos = thisActivity.openFileOutput(file.getAbsolutePath(), Context.MODE_PRIVATE);
                    OutputStreamWriter osw = new OutputStreamWriter(fos);
                    BufferedWriter bw = new BufferedWriter(osw);
                    bw.write(inputText);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

3. 实现存储后要实现获取输入框的内容以及通过按钮实现信息存储，由以下代码实现：  按钮实现信息存储，将核心代码放入该代码段内。
   ```java  
        Button btnOpen = (Button) findViewById(R.id.yes);
        View view = findViewById(R.id.yes);
        assert btnOpen != null;
        assert btnOpen != null;
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            
        });
  
获取输入框的内容：
```java   
         EditText text = (EditText) findViewById(R.id.name);
        final String inputText = text.getText().toString(); 
```        
## 四、实验结果
![lab5](raw.githubusercontent.com/tangcongbaobing/android-labs-2020/master/students/sec1814080911210/lab5.PNG)
## 五、实验心得
本次实验是Android存储编程，安卓的存储方式有多种，根据我的项目我选择了在APP目录下存储我所需要的文件信息，实验过程中经常出现APP闪退的现象，通过网上查找资料以及同学的帮助后顺利解决。
文件存储对我来说还是有一定难度的，但在参考了老师给的代码后最终还是完成了本次实验。
