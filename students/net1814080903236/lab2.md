# 实验二 Android组件编程
## 一、实验目标
1. 学习了解Android组件
2. 学会在创建Activity并在其上面添加按钮、链接或导航，和实现各个Activity之间的跳转
## 二、实验内容
1. 选择自己要做的题目和功能并在issues中创建自己的选题：https://github.com/hzuapps/android-labs-2020/issues 
2. 根据自选题目，编写一个或多个Activity（主窗口类带上学号前缀，放到自己的Java包下）
3. 将标题设置为自己的学号+对应的功能或题目
4. 根据自己选择的题目实现Activity中导航、调用等功能（选做）
## 三、实验步骤
1. 选择自己的题目，生日提醒，并在issues中创建选题
2. 确定两个功能，记录生日信息，发出生日提醒
3. 设计三个Java类，MainActivity（应用开始主页），RecordActivity（记录生日信息），RemindActivity（发出生日提醒）
4. 将三个Activity添加到AndroidMainifest.xml中
```  <activity android:name=".RecordActivity"></activity>
        <activity android:name=".RemindActivity"></activity>
        <activity android:name=".MainActivity">
``` 
5. 在MainActivity中添加按钮，实现点击按钮进入应用跳转到记录信息界面
``` Button button = findViewById(R.id.button3);
        final MainActivity thisActivity1 = this;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity1, RecordActivity.class);
                MainActivity.this.startActivity(intent);
            }
        }
```
6. 在RecordActivity中添加按钮，实现点击按钮跳转到提醒界面
``` Button button = findViewById(R.id.button2);
        final RecordActivity thisActivity = this;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, RemindActivity.class);
                RecordActivity.this.startActivity(intent);
            }
        }
```
7. 利用Git相关命令提交代码并发Pull Request
## 四、实验结果
## 五、实验心得体会
这次实验完成的比较久，在目前还只是一个初步的设计，后面还会继续完善它，感觉通过所学的知识做了一点小小的东西很不错，以后还要继续好好学习！
