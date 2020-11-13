# 实验二

## 一、实验目标

1. 创建2-3个与自己选题有关的Activity
2. 利用Intent实现Activity间的跳转

## 二、实验内容

1. 根据功能创建相应的Activity；
2. 编写Activity对应的布局文件；
3. 实现各个Activity之间的跳转;

## 三、实验步骤

1.将创建的Activity注册到AndroidManifest.xml

```xml
<activity android:name=".Net1814080903123Activity" />
<activity android:name=".NovelSearch" />
<activity android:name=".MyBookshelf" />
```

2.在布局文件中创建Button并赋予ID

```xml
<Button
    android:id="@+id/btn"
    android:layout_width="70dp"
    android:layout_height="70dp"
    android:layout_marginStart="70dp"
    android:layout_marginLeft="70dp"
    android:layout_marginTop="70dp"
    android:text="小说查询"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toTopOf="parent" />

<Button
    android:id="@+id/btn1"
    android:layout_width="70dp"
    android:layout_height="70dp"
    android:layout_marginTop="70dp"
    android:layout_marginEnd="70dp"
    android:layout_marginRight="70dp"
    android:text="我的书架"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintTop_toTopOf="parent" />
```

3.利用startActivity（intent）实现转型

```java
Button btn = findViewById(R.id.btn);
btn.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View v) {
                               Intent it = new Intent();
                               it.setClass(Net1814080903123Activity.this, NovelSearch.class);
                               Net1814080903123Activity.this.startActivity(it);
                           }    });

    Button btn1= findViewById(R.id.btn1);
btn1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it=new Intent();
            it.setClass( Net1814080903123Activity.this, MyBookshelf.class);
            Net1814080903123Activity.this.startActivity(it);
        }

});
```

## 四、实验结果

![2](2.png)

## 五、实验心得

本次实验主要是根据自己的issue创建相应的Activity以及对应的界面，难点在于实现界面的跳转。

