# 实验五 Android存储编程 
## 一、实验目标
1. 了解Andoid的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储
## 二、实验内容
 根据选题要求使用文件存储
1. 将应用产生的数据保存到文件存储中；
2. 说明使用的文件存储方式：内部 or 外部；
3. 将运行结果截图。
## 三、实验步骤
1. 选择采用内部文件存储
2. 在之前设计的activity_Record.xml中添加EditText添加id，以便于在RecordActivity.java中的使用
3. 在RecordActivity.java中对输入数据数据的操作，点击按钮“确定添加”将数据存储到文件“record_file”中，存储成功提示“添加成功”，具体实现代码如下：
``` 
    Button button_record,button_information;
    EditText  editName,editSex,data;
    String fileName="record_file";

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        editName=findViewById(R.id.editName);
        editSex=findViewById(R.id.editSex);
        data=findViewById(R.id.data);
        button_record = findViewById(R.id.button2_1);
        button_information = findViewById(R.id.button2_2);

    }
    public void btn2_1Click(View view) throws IOException {
       String name=editName.getText().toString();
       String sex= editSex.getText().toString();
       String d=data.getText().toString();

        FileOutputStream fileOutputStream=openFileOutput(fileName, Context.MODE_APPEND);
        fileOutputStream.write((name+","+sex+","+d+"\n").getBytes());
        if(fileOutputStream!=null){
            fileOutputStream.close();
        }

        Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
    }
```
## 四、实验结果
![结果截图1](https://github.com/huangqiulian/android-labs-2020/blob/master/students/net1814080903236/sy5_1.png)   
![结果截图2](https://github.com/huangqiulian/android-labs-2020/blob/master/students/net1814080903236/sy5_2.png)
## 五、实验心得体会
这次实验学习数据的文件存储和数据库存储，我实验是采用的是文件存储中的内部存储功能，做实验遇到不懂的地方上网查阅资料弄懂了，觉得还挺简单的了，挺有趣的。
