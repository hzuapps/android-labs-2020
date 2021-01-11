# 实验六：Android网络编程

## 一、实验目标

1. 掌握Android网络访问方法；
2. 理解XML和JSON表示数据的方法。

```
注意：选择实现的功能，一定要跟你的选题相关！
```

## 二、实验内容

1. 在个人目录中创建一个表示数据的XML或JSON文件；
2. 数据文件代码提交之后从GitHub获取文件URL；
3. 在应用中通过网络编程访问GitHub的数据文件；
4. 在应用中解析并显示文件所包含的数据；
5. 将应用运行结果截图。

## 三、实验步骤

1. 在我的项目中没有用到网络访问，在本次实验中对项目的功能进行实现和完善。

2. 对activity_shift.xml界面进行完善。

![实验截图](https://github.com/hkx0505/android-labs-2020/blob/master/students/net1814080903129/TP/lab6(1).PNG)


3. 对“十进制”与“二进制”之间的相互转换的实现

（1）“十转二”的实现：

```java
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = editText.getText().toString().trim();
                if (!str.matches("^[0-9]+$")) {
                    resultText.setText("请输入正整数");//判断输入的整数且不带符号。
                    return;
                }
                else{
                    String two = Integer.toBinaryString(parseInt(str));//实现“十转二”。
                    resultText.setText(two);
                }
            }
        });
```

（2）“二转十”的实现：

```java
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String he = resultText.getText().toString();
                if (!he.matches("^[0-1]+$")) {
                    editText.setText("请输入数字0或1");//判断输入的是二进制数。
                    return;
                }
                else{
                    String ten = Integer.valueOf(he, 2).toString();//实现“二转十”。
                    editText.setText(ten);
                }
            }
        });
```



## 四、实验结果及截图

![实验6图片](https://github.com/hkx0505/android-labs-2020/blob/master/students/net1814080903129/TP/lab6(2).PNG)

![实验6图片](https://github.com/hkx0505/android-labs-2020/blob/master/students/net1814080903129/TP/lab6(3).PNG)

![实验6图片](https://github.com/hkx0505/android-labs-2020/blob/master/students/net1814080903129/TP/lab6(4).PNG)

## 五、实验心得

本次实验中，由于我的项目没有用到网络访问，所以只是在APP的功能上的实现和进一步的优化，本次实验是对进制转换的实现，通过Integer.toBinaryString（十转二）以及Integer.valueOf（二转十）来实现进制转换，也对相应的编程方法有了更好的掌握。
