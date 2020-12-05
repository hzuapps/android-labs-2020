# 实验二 Android组件编程

## 一、实验目标

1. 在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2020/issues；

2. 根据自选题目，编写一个或多个Activity（主窗口类带上学号前缀，放到自己的Java包下；

3. 将标题设置为自己的学号+对应的功能或题目；

4. 根据自己选择的题目实现Activity中导航、调用等功能（选做）。

## 二、实验内容

1. 创建自己的安卓项目选题：#37 音乐播放器；

2. 根据自选题在Android Studio中创建多个Activity；

3. 在 Sec1814080911113Activity.java 添加按钮点击事件处理，实现跳转；

4. 实现一个Activity与另一个Activity之间的跳转。

## 三、实验步骤
 
1. 在Sec1814080911238\app\src\main\java\edu\hzuapps\androidlabs\sec1814080911113下新建 6 个 Activity

+ 首页：Sec1814080911113Activity.java

+ 上一曲：LastActivity.java

+ 本地音乐：MyMusiActivityc.java

+ 暂停：PauseActivity.java

+ 分享：ShareActivity.java

2. 在Activity上添加按钮、实现各个Activity的跳转

在Sec1814080911113Activity.java添加点击事件处理，跳到以上4个Activity中，实现Activity之间的跳转

```
package edu.hzuapps.androidlabs.sec1814080911113;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;

public class Sec1814080911113Activity extends AppCompatActivity {
    private Button button;
    private View.OnClickListener onClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button1:
                        Intent intent = new Intent(Sec1814080911113Activity.this, MymusicActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.button2:
                        Intent intent1 = new Intent(Sec1814080911113Activity.this, ShareActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.button3:
                        break;
                    case R.id.button4:
                        break;
                }
            }
        };

        button =findViewById(R.id.button1);
        button.setOnClickListener(onClickListener);
        
        button =findViewById(R.id.button2);
        button.setOnClickListener(onClickListener);

        button =findViewById(R.id.button3);
        button.setOnClickListener(onClickListener);

        button =findViewById(R.id.button4);
        button.setOnClickListener(onClickListener);
    }
}
```

## 四、实验结果

<img src="https://github.com/BlaiseChin/android-labs-2020/blob/master/students/sec1814080911113/test2/main.PNG">
<img src="https://github.com/BlaiseChin/android-labs-2020/blob/master/students/sec1814080911113/test2/share.PNG">

## 五、实验结果

  本次实验是Android组件编程实验，在APP内实现页面之间的简单的跳转，根据开发文档来一步一步进行操作不难完成本次实验，但是自己觉得自己做的APP的页面布局和素材等等都还差点意思，希望以后学习到相关知识后可以改变这种情况。
