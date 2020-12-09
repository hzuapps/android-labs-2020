# 实验五：Android存储编程

## 一、实验目标

- 了解Andoid的存储手段
- 掌握Android的文件存储
- 掌握Android的数据库存储

## 二、实验内容

- 将应用产生的数据保存到文件存储中；
- 说明使用的文件存储方式：内部 or 外部；
- 将运行结果截图。


## 三、实验步骤

1. 通过提交按钮进行监听，获取输入框中的内容，同时做了为空校验，但未输入时，提示“单纯中英文不能为空”。

>  InputActivity.java 文件

```java
...
    btnOpen3.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
            //获取两个输入框的内容
            String string01 = str01.getText ().toString ();
            String string02 = str02.getText ().toString ();

            if(string01.equals ("") || string02.equals ("")){           //输入框校验框验证
                Toast.makeText (InputActivity.this,"单纯中英文不能为空",Toast.LENGTH_LONG).show ();
            }else {         //入库处理
                ...
            }
        }
    });
...
```



2. 通过校验后，使用 `SharedPreferences` 进行存储， `SharedPreferences` 是基于XML文件存储 `key-value` 键值对数据，通常用来存储一些简单的配置信息。将单词和翻译存储位置在 `/data/data/edu.hzuapps.androidlabs.sec1814080911238/shared_prefs/localData.xml` 。同时为了保证每个单词 `key` 的唯一性（若key相同，则会覆盖原有的内容），使用 `sharedPreferences.contains` 和 `while` 循环来配合，确保key值的唯一性，最后进行入库处理。

> InputActivity .java 文件

```java
...
btnOpen3.setOnClickListener(new View.OnClickListener() {
    public void onClick(View view) {
        //获取两个输入框的内容
        String string01 = str01.getText ().toString ();
        String string02 = str02.getText ().toString ();
        //将信息存储到SharePreferences
        if(string01.equals ("") || string02.equals ("")){           //input框验证
            Toast.makeText (InputActivity.this,"单纯中英文不能为空",Toast.LENGTH_LONG).show ();
        }else {         //入库处理
            //获取SharePreferences(参数1：文件名，参数2：模式)
            SharedPreferences sharedPreferences = getSharedPreferences ("localData",MODE_PRIVATE);
            //获取Editor对象
            SharedPreferences.Editor editor = sharedPreferences.edit ();
            //找到localData中最后一条，在最后一条数据后面进行num编号添加
            boolean flag = true;
            while (flag) {
                if(sharedPreferences.contains("English" + num)) {
                    num ++;
                } else {
                    flag =false;
                }
            }
            //存储信息
            editor.putString ("English" + num,string01);
            editor.putString ("China" + num,string02);
            //提交
            editor.commit ();
            num++;
            str01.setText("");
            str02.setText("");
            Toast.makeText (InputActivity.this,"保存成功",Toast.LENGTH_SHORT).show ();
        }
    }
});
...
```

>  localData.xml 文件

```xml
<?xml version='1.0' encoding='utf-8' standalone='yes' ?>
<map>
    <string name="English4">AAA</string>
    <string name="China4">sss</string>
    <string name="China3">AA</string>
    <string name="English1">a</string>
    <string name="China2">B</string>
    <string name="English0">a</string>
    <string name="China1">A</string>
    <string name="China0">a</string>
    <string name="English3">a</string>
    <string name="English2">b</string>
</map>
```



3. 在 *开始背单词* 页面，对刚刚录入的单词进行查看，同时点击翻译时，再次根据单词在 `localData.xml` 中查询对应的翻译，将翻译Toast出来，实现单词的背诵功能。

> RememberActivity.java 文件

```java
...
    private void initFruits() {
        SharedPreferences sp = getSharedPreferences ("localData",MODE_PRIVATE);

        boolean flag = true;
        int num = 0;
        while (flag) {
            if(sp.contains("English" + num)) {      //判断localData中是否存在该数据，如何如果存在则通过Fruit渲染成列表
                System.out.println(sp.getString("English" + num,""));
                System.out.println( sp.getString("China" + num,""));
                Fruit apple = new Fruit(sp.getString("English" + num,""), sp.getString("China" + num,""));
                fruitList.add(apple);
                num ++;         //num++渲染下一个单词
            } else {
                flag =false;
            }
        }
    }
...
```

4. 在渲染过程中发现了新的问题，之前在编写列表时，列表是通过引用封装的 `list_item.xml` ，进行多次调用，所渲染出来的静态数据，如今是动态数据，因为得使用动态的渲染方式。经过不断的摸索，在项目中使用了在support库中的 `androidx.recyclerview:recyclerview` 。

> remember_activity.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical" android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/bg">
    <ScrollView
        android:id="@+id/vertical_scroll_view"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical">

            <androidx.recyclerview.widget.RecyclerView
                android:id="@+id/recycler_view"
                android:layout_width="match_parent"
                android:layout_height="match_parent"/>
        </LinearLayout>
    </ScrollView>
</LinearLayout>
```



5. 创建Fruit类，对单词数据进行抽象封装。

> Fruit.java

```java
package edu.hzuapps.androidlabs.sec1814080911238;

public class Fruit {
    private String name;
    private String imageId;
    public Fruit(String name, String imageId) {
        this.name = name;
        this.imageId = imageId;
    }
    public String getName() {
        return name;
    }
    public String getImageId() {
        return imageId;
    }
}
```



6. 封装fruitList类，将生成好的 `list_item.xml` 添加到 `androidx.recyclerview:recyclerview` 中进行渲染。

>fruitList.java

```java
package edu.hzuapps.androidlabs.sec1814080911238;

import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private List<Fruit> mFruitList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View fruitView;
        TextView fruitImage;
        TextView fruitName;
        Button deleteBtn;

        public ViewHolder(View view) {
            super(view);
            fruitView = view;
            fruitImage = view.findViewById(R.id.textView1);
            fruitName = view.findViewById(R.id.textView2);
            deleteBtn = view.findViewById(R.id.button);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);

        holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(view.getContext(), fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return holder;

    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);
        holder.fruitImage.setText(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());
    }
    @Override
    public int getItemCount() {
        return mFruitList.size();
    }
    public FruitAdapter(List<Fruit> fruitList) {
        mFruitList = fruitList;
    }
}
```



## 四、实验结果

![入库保存](https://github.com/Arlene238/android-labs-2020/blob/master/students/sec1814080911238/lab5-1.png?raw=true)

![查看保存数据](https://github.com/Arlene238/android-labs-2020/blob/master/students/sec1814080911238/lab5-2.png?raw=true)

![渲染保存数据](https://github.com/Arlene238/android-labs-2020/blob/master/students/sec1814080911238/lab5-3.png?raw=true)





## 五、实验心得

 此处实验，做的是存储功能，我选择了`SharedPreferences` 基于XML文件存储 `key-value` 键值对数据，`SharedPreferences`  的好处在于他体积小，方便本地存取，适合用来存放单词等文本类数据。在做的过程中也慢慢的发现了自己之前开发的不足，如列表方面，之前只是简单的静态数据的渲染，没有考虑到之后的动态渲染问题，在进过网上的资料查询和翻看教学资料，找到了使用 `androidx.recyclerview:recyclerview` 来动态渲染的解决方法。通过这次实验，个人的学习能力和开发能力得到了很好的锻炼和提升。
