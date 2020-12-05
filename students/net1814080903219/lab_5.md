# 一、实验目标 #

1. 了解Andoid的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储

# 二、实验内容 #
1. 将应用产生的数据保存到文件存储中；
2. 使用内部存储将产生的数据保存到文件存储中；
3. 将运行结果截图

# 三、实验步骤 #
1. 创造一个新的布局文件命名为activity_file_store.xml
2. 在activity_file_store.xml中加入一个EditText、两个Button按钮（保存和显示），一个TextView
3. 新建Net1814080903219FileStoreActivity类
4. 在Net1814080903219FileStoreActivity类定义两个方法用于保存和显示信息
```java
private void save(String content){
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = openFileOutput("classpath:test.txt", MODE_PRIVATE);
            fileOutputStream.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
private String read(){
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = openFileInput("classpath:test.txt");
            byte[] buf = new byte[1024];
            StringBuilder sb = new StringBuilder("");
            int len = 0;
            while ((len = fileInputStream.read(buf)) > 0){
                sb.append(new String(buf, 0, len));
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_store);
        read_btn = findViewById(R.id.read_btn);
        write_btn = findViewById(R.id.write_btn);
        textView = findViewById(R.id.textview);
        editText = findViewById(R.id.edittext);
        read_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(read());
            }
        });
        write_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(editText.getText().toString());
                editText.setText("");
            }
        });

    } 
```

# 四、实验结果 #
![lab5_result](https://github.com/account-lin/android-labs-2020/blob/master/students/net1814080903219/lab5_result.png)

# 五、实验心得 #
  本次实验我使用的是内部存储，由于自己的选题不用使用存储，就新建了一个activity和java类来展示内部存储的功能。利用文件的输出输出流来完成存储操作，主要是要理解好两个流对象。
