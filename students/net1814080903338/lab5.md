# 一、实验目标
1.了解Andoid的存储手段用    
2.掌握Android的文件存储    
3.将应用运行结果截图   

# 二、实验内容
1. 将应用产生的数据存储到数据库中；
2. 将应用运行结果截图。 

# 三、实验步骤
1. 创建数据库操作接口类 UserDao.java、DBOpenHelper.java，用于创建数据库，连接数据库，操作数据库内容。
2. 修改类 WriteActivity.java，将activity_write.xml中EditText组件获取的数值插入数据库。
```java
buttonB1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String text = editTextB2.getText() + "";
                userDao.dbInsert(text);
                Toast.makeText(
                        WriteActivity.this,
                        "成功写入：" + text , Toast.LENGTH_SHORT)
                        .show();
                Intent intent = new Intent(WriteActivity.this,
                        ReadActivity.class);
                startActivity(intent);
            }
        });
```
3.修改ReadActivity.java，将数据库中内容显示在读页面
```java
textView = new TextView(this);
                textView.setTextSize(18);
                textView.setText(user.getText());
                tableRow.addView(textView);
```

# 四、实验结果
![详细页面](https://github.com/guo02/android-labs-2020/blob/master/students/net1814080903338/%E4%B8%BB%E9%A1%B5%E9%9D%A2.PNG?raw=true)  
![读页面](https://github.com/guo02/android-labs-2020/blob/master/students/net1814080903338/%E8%AF%BB%E9%A1%B5%E9%9D%A2.PNG?raw=true)
# 五、实验心得
这次实验我做的是数据库储存，难度很大。一开始连接数据库的时候，APP就会发生闪退，花了大量的时间，才解决了这个问题。
