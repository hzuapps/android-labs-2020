# 实验二
## 一、实验目标
1. 创建2-3个与自己选题有关的Activity；
2. 利用Intent实现Activity间的跳转

## 二、实验内容
1. 根据功能创建相应的Activity；
2. 编写Activity对应的布局文件；
3. 实现各个Activity之间的跳转

## 三、实验步骤
1. 创建Net1814080903125Activity、PasswordActivity、AddDiaryActivity和相应的XML文件；
2. 添加按钮；
3. 在Net1814080903125Activity.java添加按钮点击事件处理，实现跳转到其他Activity
```java
        Button add_btn = (Button)findViewById(R.id.add_btn);
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1814080903125Activity.this, AddDiaryActivity.class);
                Net1814080903125Activity.this.startActivity(intent);
            }
        });

        Button pwd_btn = (Button)findViewById(R.id.pwd_btn);
        pwd_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1814080903125Activity.this, PasswordActivity.class);
                Net1814080903125Activity.this.startActivity(intent);
            }
        });
```

## 四、实验结果
![按钮](https://github.com/zkw55/android-labs-2020/blob/master/students/net1814080903125/lab1(1).png)
![跳转界面1](https://github.com/zkw55/android-labs-2020/blob/master/students/net1814080903125/lab2(1).png)
![跳转界面2](https://github.com/zkw55/android-labs-2020/blob/master/students/net1814080903125/lab2(2).png)

## 五、实验心得
本次实验创建了与所选题目功能相关的Activity，学习到如何利用按钮在Activity之间跳转。
