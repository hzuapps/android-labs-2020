# 一、实验目标
1. 了解Android应用中各种资源的概念与使用方法；
2. 掌握在Android应用中使用图片等资源的方法。

# 二、实验要求
1. 在界面上显示至少一张图片（按照自己的题目添加）；
2. 提交res/drawable及图片使用的代码；
3. 提交res/values, res/layout等其他代码；
4. 将应用运行结果截图，放到实验报告中；
5. 点击图片（或按钮）时，打开另一个Activity。

# 三、实验步骤
1. 找到对应图片，修改为jpg格式，放在drawable目录下。
2. 在对应的activity里加图片的索引，int[] photos = {R.drawable.tu1, R.drawable.tu2, R.drawable.tu3, R.drawable.tu4}；
3. 利用点击事件public void onClick(View view) {
        switch (view.getId()) {
            case R.id.lastPhoto:
                
                if (photoIndex == 0) {
                    photoIndex = maxIndex;
                } else {
                    
                    photoIndex--;
                }break;
            case R.id.nextPhoto:
             
                if (photoIndex == maxIndex) {
                    photoIndex = 0;
                } else {
                    //否则改为下一张图片索引
                    photoIndex++;
                }break;
            default:break;
        }
        //显示图片
        displayPhoto.setImageResource(photos[photoIndex]);
    }

# 四、实验结果
![实验截图](https://raw.githubusercontent.com/Lj-xinfei/android-labs-2020/044b6c7d13a9e6c6e5b2d3b66ca3404b1d972e31/students/net1814080903119/lab3.jpg)

# 五、实验心得
学习了设置背景图片，修改图片格式，在layout（design）那可以对图片进行调整，也可以利用ImageView进行设置。
