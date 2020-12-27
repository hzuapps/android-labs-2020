# 实验六 Android网络编程 

## 一、实验目标

1.掌握Android网络访问方法；
2.理解XML和JSON表示数据的方法

## 二、实验内容
1.在个人目录中创建一个表示数据的XML或JSON文件；
2.数据文件代码提交之后从GitHub获取文件URL；
3.在应用中通过网络编程访问GitHub的数据文件；
4.在应用中解析并显示文件所包含的数据；
5.将应用运行结果截图。

## 三、实验步骤
1.设置输入倒计时和显示倒计时的文本框
2. 添加三个功能按钮，获取倒计时时间、开始计时、停止计时
3. 使用handler实例获取倒计时结束信息
```
private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            tv_time.setText(time + "");
            switch (msg.what) {
                case MSG_WHAT:
                    if (time > 0) {
                        time--;
                    } else {
                        Toast.makeText(Net1814080903221CountDownActivity.this, "倒计时结束", Toast.LENGTH_SHORT).show();
                        if (timer != null) {
                            timer.cancel();
                            timer = null;
                        }
                    }
                    break;

                default:
                    break;
            }
        }

        ;
    };
```

## 四、实验结果
![实验截图](https://github.com/TiAmo825/android-labs-2020/blob/master/students/net1814080903221/lab6.png)

## 五、实验心得
实验没有用到网络编程，完善了倒计时功能，获取了倒计时时间后可开启计时，计时结束会显示倒计时结束。
