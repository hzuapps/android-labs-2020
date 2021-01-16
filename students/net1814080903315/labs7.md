# 实验七：Android设备编程

## 一、实验目标

1.理解Android相机、蓝牙、传感器等设备编程方法。
2.理解Android设备编程与前面所学组件、存储、网络及界面开发的知识点关系。

## 二、实验内容
1.选择一个跟选题相关的设备功能；
（1）拍照显示、录视频；
（2）控制和检测网络；
（3）获取用户位置信息；
（4）判断屏幕方向并提示用户旋转手机（小游戏）；
（5）摇一摇手机。

2.编程实现设备使用。

## 三、实验步骤
由于所作APP未使用到设备编程，在原来的APP代码上修改增添

1. 进入界面activity_chose.xml；
2. 建立一个选择的按钮，来进行选择图片的操作。


activity_chose如下：

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".ChoseActivity">



    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        tools:context=".ChoseActivity">

        <ImageView
            android:id="@+id/image"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"/>

        <Button
            android:id="@+id/chose"
            android:layout_width="wrap_content"

            android:layout_height="wrap_content"
            android:text="选择图片" />

    </LinearLayout>
</androidx.constraintlayout.widget.ConstraintLayout>
```
3. 进入界面activity_enlarge.xml；
4. 设置一个GirdView来显示图片

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".EnlargeActivity">


    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        tools:context=".ChoseActivity">

        <GridView
            android:id="@+id/gridView"
            android:numColumns="4"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"/>

    </LinearLayout>

</androidx.constraintlayout.widget.ConstraintLayout>
```
5. 进入ChoseActivity.java和EnlargeActivity.java
6. 建立数组存放图片，同时用适配器为照片设置数据源
7. 然后在gridView的选项点击事件监听器中，获取选中照片的索引并通过Bundle对象的putInt和intent对象的putExtras将数据进行返回。然后调用 setResult(200,intent);将结果进行返回，这里的请求结果码也
设置为200。

ChoseActivity.java如下：

```java
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
public class ChoseActivity extends AppCompatActivity {
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==200 && resultCode == 200)
        {
            Bundle bundle = data.getExtras();
            int imageId = bundle.getInt("imageId");
            ImageView imageView = (ImageView) findViewById(R.id.image);
            imageView.setImageResource(imageId);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose);
        Button button = (Button)findViewById(R.id.chose);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChoseActivity.this,EnlargeActivity.class);
                startActivityForResult(intent,200);
            }
        });
    }
}
```
EnlargeActivity.java如下：

```java

public class EnlargeActivity extends AppCompatActivity {
 private int[] imageId = new int[]{
            R.drawable.a,R.drawable.b, R.drawable.c,R.drawable.f, R.drawable.e
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {  GridView gridView = (GridView) findViewById(R.id.gridView);
        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return imageId.length;
            }
            @Override
            public Object getItem(int position) {
                return null;
            }
            @Override
            public long getItemId(int position) {
                return 0;
            }
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView imageView;
                if(convertView ==null)
                {
                    imageView = new ImageView(EnlargeActivity.this);
                    imageView.setAdjustViewBounds(true);
                    imageView.setMaxWidth(158);
                    imageView.setMaxHeight(150);
                    imageView.setPadding(5, 5, 5, 5);
                }else
                {
                    imageView = (ImageView) convertView;
                }
                imageView.setImageResource(imageId[position]);
                return imageView;
            }
        };
        gridView.setAdapter(adapter);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enlarge);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = getIntent();
                Bundle bundle = new Bundle();
                bundle.putInt("imageId",imageId[position]);
                intent.putExtras(bundle);
                setResult(200,intent);
                finish();
            }
        });
    }
}

```
## 四、实验结果及截图

![avatar](https://raw.githubusercontent.com/WeiCzai/android-labs-2020/master/students/net1814080903315/labs7.png)

## 五、实验心得

这次实验没用到设备编程，但是又一次的完善了我的功能，由于所想的分类功能非常的难实现，经过一系列的尝试，达不到我想要的效果，所以把它改成了选择功能。
