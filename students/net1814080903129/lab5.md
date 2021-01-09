# 实验五 Android存储编程 

## 一、实验目标

1. 了解Andoid的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储

## 二、实验内容

应用数据存储可采用数据库存储。

1. 将应用产生的数据存储到数据库中；
2. 将应用运行结果截图。

## 三、实验步骤
1. 在我的项目中没有用到数据存储，在本次实验中对项目的功能进行实现和完善。

2. 对activity_operation.xml页面显示进行完善。

![实验截图](https://github.com/hkx0505/android-labs-2020/blob/master/students/net1814080903129/TP/lab5(1).PNG)

3. 对“+、-”的运算实现以及报错显示。

 ```java
    public void onClick(View view) {
                String str = editText.getText().toString().trim();
                int result = 0;
                if (str.endsWith("=")) {
                    str = str.substring(0, str.length() - 1);
                }
                if (str.contains("=")) {
                    resultText.setText("请正确输入");
                    return;
                }
                if (!str.matches("^[0-9\\+\\-]+$")) {
                    resultText.setText("只能做加减法");
                    return;
                }
                if (str.contains("+") && !str.contains("-")) {
                    String[] strs = str.split("\\+");
                    for (int i = 0; i < strs.length; i++) {
                        if (!strs[i].isEmpty()) {
                            result += Integer.valueOf(strs[i]);
                        }

                    }
                }
                else if (str.contains("-") && !str.contains("+")) {
                    String[] strs = str.split("-");
                    for (int i = 0; i < strs.length; i++) {
                        if (strs[i].isEmpty()) {
                            continue;
                        }
                        if (i == 0) {
                            result += Integer.valueOf(strs[i]);
                        } else {
                            result -= Integer.valueOf(strs[i]);
                        }
                    }
                } else {
                    String[] strs = str.split("\\+");
                    for (String s1 : strs) {
                        if (s1.contains("-")) {
                            String[] strs2 = s1.split("\\-");
                            int count = 0;
                            for (String s : strs2) {
                                if (!s.isEmpty()) {
                                    if (count == 0) {
                                        result += Integer.valueOf(s);
                                    } else {
                                        result -= Integer.valueOf(s);
                                    }
                                }
                                count++;
                            }
                        } else {
                            if (!s1.isEmpty()) {
                                result += +Integer.valueOf(s1);
                            }
                        }
                    }
                }
                resultText.setText(str + "=" + result);
            }
        });
    }
}
```

4. 清除按钮的实现。

```java
private Button button1;
    button1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
          resultText.setText("");
          editText.setText("");
          }
    });
```

## 四、实验结果
![实验截图](https://github.com/hkx0505/android-labs-2020/blob/master/students/net1814080903129/TP/lab5(2).PNG)

![实验截图](https://github.com/hkx0505/android-labs-2020/blob/master/students/net1814080903129/TP/lab5(3).PNG)

![实验截图](https://github.com/hkx0505/android-labs-2020/blob/master/students/net1814080903129/TP/lab5(4).PNG)


## 五、实验心得
本次实验中，由于我的项目没有用到数据存储，所以只是在APP的功能上的实现和进一步的优化，对相应的编程有了更加深刻的理解。
