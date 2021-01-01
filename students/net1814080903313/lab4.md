# 一、实验目的
1.根据选题要求设计界面布局及控件使用  
2.布局xml及界面控制操作代码提交并截图  
3.将应用运行结果截图  
# 二、实验内容
1.使用一种布局方式设计界面  
2.通过控件ID获取界面对象，执行相关操作  
3.实现界面控件的事件处理  
4.操作之后，切换到第二个界面  
# 三、实验步骤
1.功能界面采用线性布局
activity_2.xml:
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".QueryFunction">

    <SearchView
        android:id="@+id/search"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:iconifiedByDefault="false"
        android:queryHint="搜索垃圾查看对应分类" />

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="horizontal">

        <LinearLayout
            android:layout_width="0dp"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:background="#D6D7D7"
            android:orientation="vertical">

            <Button
                android:id="@+id/button1"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"

                android:text="餐厨垃圾" />

            <Button
                android:id="@+id/button2"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="可回收物" />

            <Button
                android:id="@+id/button3"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="有害垃圾" />

            <Button
                android:id="@+id/button4"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="其他垃圾" />
        </LinearLayout>

        <LinearLayout
            android:layout_width="0dp"
            android:layout_height="match_parent"
            android:layout_weight="3"
            android:orientation="vertical">
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:orientation="vertical"
                android:background="#AEDADF">
                <ImageView
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:layout_gravity="center"
                    android:background="@drawable/img3" />

                <TextView
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:singleLine="true"
                    android:ellipsize="none"
                    android:maxLines="100"
                    android:scrollHorizontally="false"
                    android:text="      餐厨垃圾是指易腐的生物质废弃物。包括剩菜剩饭、瓜皮果核、花卉绿植、肉类碎骨、过期食品、餐厨垃圾等。"
                    android:textSize="20sp"
                    android:inputType="textMultiLine"
                    android:textColor="#FF000000" />
            </LinearLayout>
            <TextView
                android:id="@+id/tet_1"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:ellipsize="none"
                android:maxLines="12"
                android:scrollHorizontally="false"
                android:textSize="20dp"
                android:scrollbars="vertical"
                android:scrollbarSize="10dp"
                android:textColor="#000000"
                android:text="    姑娘果\n    冰激凌\n    QQ软糖\n    火腿\n    阿尔卑斯糖\n    阿华田巧克力酱\n    艾草\n    鹌鹑蛋\n    奥尔良鸡翅\n    奥尔良烤鸡\n    奥利奥饼干\n    奥利奥酸奶蛋糕\n    澳梅\n    澳洲牛肉\n    "/>
        </LinearLayout>
    </LinearLayout>
</LinearLayout>
```
2.主界面控制代码：
主界面播放启动动画，播放完后跳转到activity_2
package edu.hzuapps.androidlabs.net1814080903313;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

public class Net1814080903313Activity extends AppCompatActivity {
    private ImageView welcomeImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        welcomeImg=this.findViewById(R.id.img_1);
        AlphaAnimation anima =  new AlphaAnimation(0.3f, 1.0f);
        anima.setDuration(10000);// 设置动画显示时间
        welcomeImg.startAnimation(anima);
        anima.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
welcomeImg.setBackgroundResource(R.drawable.img1);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
skip();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }


    private void skip() {
        Intent intent = new Intent(this,QueryFunction.class);
        startActivity(intent);
        finish();
    }
}
# 四、实验结果
![主活动截图](https://github.com/rsdczhs/android-labs-2020/blob/master/students/net1814080903313/lab04image1.png)
![功能活动截图](https://github.com/rsdczhs/android-labs-2020/blob/master/students/net1814080903313/lab04img2.png)
# 五、实验心得
这次实验主要是学习使用布局，我在功能activity中选择了线性布局，而主活动作为一个启动动画，没有设置布局，在功能界面中设置了textview的滚动属性。
