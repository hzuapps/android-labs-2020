# 实验六：Android网络编程

## 一、实验目标
1. 掌握Android网络访问方法
2. 理解XML和JOSN表示数据的方法

## 二、实验内容
1. 从网络下载一个文件（图片、MP3、MP4）；
2. 保存到手机，在应用中使用文件；
3. 将应用运行结果截图。


## 三、实验步骤
由于所作APP未使用到网络编程，在原来的APP代码上修改增添

1. 进入界面activity_add_seek.xml；
2. 新建各个文本框和imageview并赋值好属性；
3. 在string内写好各个id对于的字符；
4. 建立上一张按钮和下一张按钮。

activity_add_seek.xml如下：

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".AddSeekActivity">


    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        >

        <Button
            android:id="@+id/back"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="7dp"
            android:layout_marginEnd="16dp"
            android:layout_marginRight="16dp"
            android:text="@string/imageView01"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintTop_toTopOf="parent" />
        <ImageView
            android:id="@+id/picture_show"
            android:layout_width="match_parent"
            android:layout_weight="1"
            android:layout_height="50dp"
            android:contentDescription="TODO"
            tools:layout_editor_absoluteX="0dp"
            tools:layout_editor_absoluteY="80dp"
            android:background="@color/cardview_dark_background"/>

        <TextView
            android:layout_width="match_parent"
            android:id="@+id/tv_show"
            android:layout_height="wrap_content"
            android:gravity="center"
            android:padding="10dp"
            android:text="图片信息  " />

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:orientation="horizontal">

            <Button
                android:id="@+id/picture_previous"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:text="上一张" />

            <Button
                android:id="@+id/picture_next"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:text="下一张" />
        </LinearLayout>


    </LinearLayout>


</androidx.constraintlayout.widget.ConstraintLayout>
```
5. 进入AddSeekActivity.java
6. 编写initView函数初始化控件和initDate函数来初始化数据
7. 在点击事件里面实现切换张数的功能。

AddSeekActivit如下：
```java
public class AddSeekActivity extends AppCompatActivity implements View.OnClickListener {
private ImageView mImage;
private  TextView mText;
    private int num;
    private int index;
    private String[] title;
    private int[] images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_seek);
        initView();
        initDate();




    }

    private void initDate() {
        title =new String[]{"第一张图片","第二张图片","第三张图片","第四张图片","第五张图片","第六张图片","第七张图片","第八张图片","第九张图片",};
        images =new int[]{R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i};
        mImage.setImageResource(images[0]);
        mText.setText(title[0]);
        num = title.length;//图片张数
         index =0;
    }

    private void initView(){
        mImage = findViewById(R.id.picture_show);
        mText = findViewById(R.id.tv_show);
        findViewById(R.id.picture_previous).setOnClickListener(this);
        findViewById(R.id.picture_next).setOnClickListener(this);
        }
        @Override
    public void onClick(View view) {
            final AddSeekActivity thisActivity = this;
            switch (view.getId()) {
                case R.id.back:
                    Intent intent = new Intent(thisActivity, Net1814080903315MainActivity.class);//实现第一个跳转
                    startActivity(intent);
                    break;
                case R.id.picture_previous:
                    //上一张图片
                    if (index == 0) {

                        index = title.length - 1;
                    } else {

                        index--;
                    }

                    break;
                case R.id.picture_next:
                    //下一张图片
                    if (index == 8) {

                        index = 0;
                    } else {

                        index++;
                    }

                    break;
            }
            updateImageTitle();
        }
        private void updateImageTitle(){
        mImage.setImageResource(images[index]);
        mText.setText(title[index]);
        }



}
```
## 四、实验结果及截图

![avatar](https://raw.githubusercontent.com/WeiCzai/android-labs-2020/master/students/net1814080903315/labs6.png)

## 五、实验心得
本次实验主要完成了查看功能，完善修改了一下页面和功能的完善。
