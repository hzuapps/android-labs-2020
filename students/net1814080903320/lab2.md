# 实验二
## 一、实验目标
1. 创建2-3个与自己选题有关的Activity；
2. 利用Intent实现Activity间的跳转

## 二、实验内容
1. 根据功能创建相应的Activity；
2. 编写Activity对应的布局文件；
3. 实现各个Activity之间的跳转

## 三、实验步骤
1. 创建Net1814080903320Activity、FriendsActivity、RunActivity、TalkActivity和相应的XML文件；
2. 添加按钮；
3. 在Net1814080903320Activity.java添加按钮点击事件处理，实现跳转到其他Activity
```java
Button jumpBtn=this.findViewById(R.id.run_jump_btn);
        jumpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击之后的处理
                Intent intent=new Intent(Net1814080903320Activity.this, edu.hzuapps.androidlabs.net1814080903320.RunActivity.class);
                startActivity(intent);
            }
        });
        Button jumpBtn_1=this.findViewById(R.id.friends_jump_btn);
        jumpBtn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击之后的处理
                Intent intent=new Intent(Net1814080903320Activity.this, edu.hzuapps.androidlabs.net1814080903320.FriendsActivity.class);
                startActivity(intent);
            }
        });
        Button jumpBtn_2=this.findViewById(R.id.talk_jump_btn);
        jumpBtn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击之后的处理
                Intent intent=new Intent(Net1814080903320Activity.this, edu.hzuapps.androidlabs.net1814080903320.TalkActivity.class);
                startActivity(intent);
            }
        });
```

## 四、实验结果
![主页面](https://github.com/taoge183/android-labs-2020/blob/master/students/net1814080903320/主页面.jpg)
![跳转界面示例](https://github.com/taoge183/android-labs-2020/blob/master/students/net1814080903320/交友界面.jpg)

## 五、实验心得
实验二，创建了一个主页面，然后编写了3个Activity以及相应的界面，同时实现了按钮触发界面的跳转，总体来说并不难。
