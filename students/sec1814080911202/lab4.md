# 一、实验目标

根据选题要求设计界面布局及控件使用；
布局xml及界面控制操作代码提交并截图；
将应用运行结果截图。

# 二、实验内容

1. 使用一种布局方式设计界面,用LinearLayout。
2. 通过控件ID获取界面对象，执行相关操作：
```xml
// xml
android:id="@+id/boot_show"
```

```java
// java
mImage = findViewById(R.id.boot_show);
```

3. 实现界面控件的事件处理;
4. 操作之后，切换到第二个界面。

# 三、实验步骤
`BorrowActivity`:
```java
private void bookText() {
        title =new String[] {"内网安全攻防","web安全攻防","SQL注入攻击与防御","从0到1：CTFer成长之路","逆向工程"};
        images =new int[] {R.drawable.lan_sec_awd,R.drawable.web_sec_awd,R.drawable.sqli_awd,R.drawable.from_0_to_1,R.drawable.reverse};

        mImage.setImageResource(images[0]);
        mText.setText(title[0]);

        num = title.length;
        index = 0;
    }

    private void bookShow() {
        mImage = findViewById(R.id.boot_show);
        mText = findViewById(R.id.book_text);
        findViewById(R.id.btn_left).setOnClickListener(this);
        findViewById(R.id.btn_right).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_left:
                if (index == 0) {
                    index = title.length - 1;
                }else {
                    index--;
                }
                break;
            case R.id.btn_right:
                if (index == 4) {
                    index = 0;
                }else {
                    index++;
                }
                break;
        }
        updateImageAndTitle();
    }


    private void updateImageAndTitle() {
        mImage.setImageResource(images[index]);
        mText.setText(title[index]);
    }
```

`activity_borrow.xml`:
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".BorrowActivity">

    <!-- 顶部栏 惠州学院图书馆字样图片 -->
    <ImageView
        android:id="@+id/imageview_hzu_library1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@drawable/hzu_library1"/>

    <ImageView
        android:id="@+id/boot_show"
        android:layout_width="400dp"
        android:layout_height="350dp"
        android:layout_weight="1"
        android:background="@android:color/white"
        android:layout_marginLeft="5dp"/>

    <TextView
        android:id="@+id/book_text"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:padding="10dp"/>

    <Button
        android:id="@+id/btn_left"
        android:layout_width="217dp"
        android:layout_height="wrap_content"
        android:layout_gravity="bottom"
        android:layout_marginLeft="100dp"
        android:layout_weight="3"

        android:text="上一本"
        tools:ignore="MissingConstraints" />

    <Button
        android:id="@+id/btn_func"
        android:layout_width="217dp"
        android:layout_height="wrap_content"
        android:layout_gravity="bottom"
        android:layout_marginLeft="100dp"
        android:layout_weight="3"
        android:text="借阅"
        tools:ignore="MissingConstraints" />

    <Button
        android:id="@+id/btn_right"
        android:layout_width="217dp"
        android:layout_height="wrap_content"
        android:layout_marginLeft="100dp"
        android:layout_weight="3"

        android:text="下一本"
        tools:ignore="MissingConstraints" />

</LinearLayout>
```

# 四、实验结果


![lab4](https://raw.githubusercontent.com/L1nzSec/android-labs-2020/master/students/sec1814080911202/lab4.png)


# 五、实验心得

本次实验用LinearLayout进行页面布局，通过上课老师所讲，以及百度查阅资料学会了很多东西并对项目进行了改进，增加了一些图书的图片，并在图书借阅activity中获取控件id增加事件对图书进行展示，图书管理的界面暂时大致和图书借阅一样，等加上数据库增删再改进。
