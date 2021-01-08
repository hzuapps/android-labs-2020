# 实验五
# 一、实验要求

- 了解Andoid的存储手段
- 掌握Android的文件存储
- 掌握Android的数据库存储

# 二、实验内容

- 将应用产生的数据保存到文件存储中；
- 说明使用的文件存储方式：内部；
- 将运行结果截图。


# 三、实验步骤

- 修改代码，将setting.xml中的EditText控件与Net1814080903204Activity.java联系，为其添加事件处理；
- 代码编写完毕后在虚拟机上运行，在EditText中随意输入数据，如“999”；
- 进入File Explorer标签页，找到/data/data/（你的包名）/files/，可以看到生成了一个文件；
- 将之导出到电脑上并用记事本打开验证是否与自己输入的数据一致；

```
       public void save(String text) {
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try {
            out = openFileOutput("data", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(text);
        } catch (IOException e) {
            // TODO Auto-generated catch block

            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
```

# 四、实验结果

 ![实验截图](https://github.com/Dwweryu/android-labs-2020/blob/master/students/net1814080903204/Lab5.png)

# 五、实验心得
本次实验是关于存储的实验，Android系统主要提供了三种方式用于简单地实现数据持久化功能，分别是文件存储、SharedPreferences存储以及数据库存储。在本实验中我选择了文件存储，这是Android中最基本的一种数据存储方式，它不对存储的内容进行任何的格式化处理，所有数据都是原封不动地保存在文件中的，因此比较适合用于存储一些简单的文本数据或者二进制数据。
