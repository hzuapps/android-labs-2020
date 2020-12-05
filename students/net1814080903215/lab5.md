# 一、实验目的

1. 了解Andoid的存储手段
2. 掌握Android的文件存储
2. 掌握Android的数据库存储2. 

# 二、实验内容

1. 将应用产生的数据保存到文件存储中；
2. 使用内部存储将产生的数据保存到文件存储中；
3. 将运行结果截图。

# 三、实验步骤

1. 在相应XML文件中创建按钮控件两个，EditText用于输入数据，TextView用于显示数据

2. 在相应Activity中建立两个按钮Onclick事件,需要使用到相应文件输入输出流，文件为TXT文件需定义filename

```
Button btn5 = (Button)findViewById(R.id.button5);
        final PersonalHomeActivity thisActivity5 = this;
        btn5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                FileOutputStream fileOutputStream = null;
                try {
                    fileOutputStream = getApplicationContext().openFileOutput(filename, MODE_APPEND);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                PrintStream printStream = new PrintStream(fileOutputStream);
                printStream.println(edit.getText().toString());
            }
        });

        Button btn6 = (Button)findViewById(R.id.button6);
        final PersonalHomeActivity thisActivity6 = this;
        btn6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                FileInputStream fileInputStream = null;
                try {
                    fileInputStream = openFileInput(filename);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(fileInputStream));
                String temp="";
                text.setText("文件路径："+getApplicationContext().getFilesDir()+"\n");
                while (true){
                    try {
                        if (!((temp=bufferedReader.readLine())!=null)) break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    text.append("\n"+temp);
                }
            }
        });
        
  ```      
        

3. 显示文件存储路径

```

text.setText("文件路径："+getApplicationContext().getFilesDir()+"\n");

```
4. EditText用于输入数据，TextView用于显示数据

```

text = (TextView) findViewById(R.id.textView3);
edit = (EditText) findViewById(R.id.edit);

```

# 四、实验结果

![实验截图](https://raw.githubusercontent.com/Deng-dong555/android-labs-2020/master/students/net1814080903215/lab5_pic.png)

# 五、实验心得

这次实验涉及到了文件存储，是关于文本文档的存储和读取，在查看了相应的资料和教学视频后编写出来的功能，实现了存储然后在TextView中显示出来，
希望以后可以加入更多的功能。
