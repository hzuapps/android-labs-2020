# 实验五 Android存储编程

# 一、实验目标

1.了解Andoid的存储手段用    
2.掌握Android的文件存储    
3.将应用运行结果截图   

# 二、实验内容
1.将应用产生的数据保存到文件存储中    
2.说明使用的文件存储方式：内部 or 外部    
3.将运行结果截图  


# 三、实验步骤
1.创建 FileActivity，并编写存储数据函数 save (String content）和读取数据的函数read()
```java
 // 存储数据

        private void save (String content){
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = openFileOutput(mFileName, MODE_PRIVATE);
                fileOutputStream.write(content.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }


        // 读取数据
        private String read(){
            FileInputStream fileInputStream = null;

            try {
                fileInputStream = openFileInput(mFileName);
                byte[] buff = new byte[1024];
                StringBuilder sb = new StringBuilder(" ");
                int len = 0;
                while ((len = fileInputStream.read(buff)) > 0) {
                    sb.append(new String(buff, 0, len));
                }
                return sb.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

```
2.获得按钮控件。    
```
        mEtName = (EditText) findViewById(R.id.et_name);
        mBtnSave = (Button) findViewById(R.id.btn_save);
        mBtnShow = (Button) findViewById(R.id.btn_show);
        mTvContent = (TextView) findViewById(R.id.tv_content);
```
3.调用方法。    
```
        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(mEtName.getText().toString());
            }
        });

        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  mTvContent.setText(read());
            }
        });
```

# 四、实验结果
![lab5](https://github.com/2950743175/android-labs-2020/blob/1d3e3915ea68bd29e73e6821e2d2e587eac4993c/students/net1814080903329/lab5.PNG)  

# 五、实验心得
  本次实验主要是文件存储的内容，一开始做的时候感觉难以入手，所以在网上找了一些学习资料，在一边做一边学习的过程中也初步了解到了Android文件存储的运行基础知识，
