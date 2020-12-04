# 一、实验目标
1. 了解Andoid的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储
# 二、实验内容
1. 将应用产生的数据保存到文件存储中；
2. 说明使用的文件存储方式：内部 or 外部；
3. 将运行结果截图。
# 三、实验步骤
1. 根据自己需要使用了文件存储方式中的内部存储
2. 向文件添加需要存储的文本
```java
public void WriteBtn(View v) {
        //向文件中添加文本
        try {
            FileOutputStream FileOut=openFileOutput("MyTextFile.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter=new OutputStreamWriter(FileOut);
            outputWriter.write(comment_nr.getText().toString());
            outputWriter.close();

            //显示文件保存消息
            Toast.makeText(getBaseContext(), "保存成功!",
                    Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
```
3. 从文本中读取已存储的文本
```java
public void ReadBtn(View v) {
        //从文件读取文本
        try {
            FileInputStream FileIn=openFileInput("MyTextFile.txt");
            InputStreamReader InputRead= new InputStreamReader(FileIn);

            char[] inputBuffer= new char[READ_BLOCK_SIZE];
            String s="";
            int charRead;

            while ((charRead=InputRead.read(inputBuffer))>0) {
                //转换
                String ReadString=String.copyValueOf(inputBuffer,0,charRead);
                s += ReadString;
            }

        InputRead.close();
        comment_nr.setText(s);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
```
# 四、实验结果
![lab5_1](https://raw.githubusercontent.com/ccc2020916/android-labs-2020/master/students/net1814080903132/lab5_1.png)
![lab5_2](https://raw.githubusercontent.com/ccc2020916/android-labs-2020/master/students/net1814080903132/lab5_2.png)
# 五、实验心得
本次实验一开始考虑使用数据库存储的，经过考虑后发现文件存储更适合我开发的这个app，因此转换为使用了内部存储，通过把需要存储的内容写入到文本中，再从文本中读取，从而实现了存储功能
