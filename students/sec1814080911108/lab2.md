# 一、实验目标

1. 创建2-3个与自己选题有关的Activity
2. 利用Intent实现Activity间的跳转

# 二、实验内容

1. 根据功能创建相应的Activity；
2. 编写Activity对应的布局文件；
3. 实现各个Activity之间的跳转;

# 三、实验步骤

1. 将创建的Activity注册到AndroidManifest.xml；
2. 在Sec1814080911108Activity的layout文件视图中添加Button按钮用于跳转页面；
3. 为按键添加事件处理：

```java
// 按钮添加点击事件
ImageView btnBookmarks = (ImageView)findViewById(R.id.bookmarks);
btnBookmarks.setColorFilter(Color.parseColor("#ffffff"));
btnBookmarks.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        // 发出Toast
        Toast.makeText(Sec1814080911108Activity.this, "遇见爱情", Toast.LENGTH_SHORT).show();
        // 显式Intent
        Intent intent = new Intent(Sec1814080911108Activity.this,LoveListActivity.class);
        startActivity(intent);
    }
});
```

4. 创建相应功能的Activity名为'XXX'；
5. 利用startActivity(intent)实现跳转；



# 四、实验结果



![Sec1814080911108Activity](https://raw.githubusercontent.com/git-lanying/android-labs-2020/master/students/sec1814080911108/lab2.png)



点击输入框后跳转到另外一个Activity

![跳转Activity](https://raw.githubusercontent.com/git-lanying/android-labs-2020/master/students/sec1814080911108/lab2_target.png)



# 五、实验心得

描绘按钮外观：

在`res/drawable`文件夹下新建Drawable资源文件

root element 选 shape

```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle">
    <solid
        android:color="#e67e22" />
    <corners
        android:radius="5dp"/>
</shape>
```

通过findVidwById找到按钮，为按钮添加点击事件，通过Intent进行Activity之间的跳转。