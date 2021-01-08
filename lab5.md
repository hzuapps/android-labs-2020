# 实验五：Android存储编程
## 一、实验目标
- 了解Andoid的存储手段
- 掌握Android的文件存储
- 掌握Android的数据库存储
## 二、实验内容
- 使用文件内部存储方式
- 在PersonalDetailsActivity中点击“确定”按钮后，存储EditText框中的值
- 保存完后在布局中读取存储后的数据
- 存储的数据在界面中显示出来
## 三、实验步骤
 
- 创建点击事件

```java
Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        saveButton = findViewById(R.id.main_save_button);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAndSaveFile();
            }
        });
```

- 方法

```java
 private void createAndSaveFile() {
        Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("text/plain");
        boolean value;
        intent.putExtra(Intent.EXTRA_TITLE,"textFileXXX.txt");
        startActivityForResult(intent, 1);

    }
```

- 文件的保存

```java
 protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                Uri uri =data.getData();

                try {


                    OutputStream outputStream = getContentResolver().openOutputStream(uri);

                    outputStream.write("xxx".getBytes());
                    outputStream.close();

                    Toast.makeText(this,"File is save successfully",Toast.LENGTH_SHORT).show();
                }catch (IOException e){
                    Toast.makeText(this,"Fail to write file",Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this,"File not saved",Toast.LENGTH_SHORT).show();
            }
        }
    }

```
## 四、实验结果
- 文件保存
![文件保存](https://github.com/book-ccr/android-labs-2020/blob/master/students/net1814080903334/sy5.png)

## 五、实验心得

这次是安卓课程的第五次实验，主要内容是在Android中实现文件的存储，看似很简单的问题因为对Android的不熟练导致编程特别困难，所以这次实验只进行了简单的文件创建及保存。
关于Android中实现存储在这次学习中我了解到三种存储方式，文件存储，轻量存储、SQLite数据库存储，这三种存储方式都各有优缺点适用也不同。
