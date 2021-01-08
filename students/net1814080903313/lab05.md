# 实验五：Android存储编程

## 一、实验目标

- 了解Andoid的存储手段
- 掌握Android的文件存储
- 掌握Android的数据库存储

## 二、实验内容

- 使用文件内部存储方式
- 在QueryFuntion中把textView的值输出到/data/user/0/edu.hzuapps.androidlabs.net1814080903313/files中

## 三、实验步骤

- 创建一个FileOutputStream对象，MODE_PRIVATE追加模式
- 将获取过来的值放入文件
- 关闭数据流

```java
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        final TextView textView1 = findViewById(R.id.tet_1);
        final TextView textView2 = findViewById(R.id.tet_2);
        final TextView textView3 = findViewById(R.id.tet_3);
        final TextView textView4 = findViewById(R.id.tet_4);

        final Button button1 = findViewById(R.id.button1);
        final Button button2 = findViewById(R.id.button2);
        final Button button3 = findViewById(R.id.button3);
        final Button button4 = findViewById(R.id.button4);

        final LinearLayout linearLayout1 = findViewById(R.id.line1);
        final LinearLayout linearLayout2 = findViewById(R.id.line2);
        final LinearLayout linearLayout3 = findViewById(R.id.line3);
        final LinearLayout linearLayout4 = findViewById(R.id.line4);

        //设置按钮点击事件
        final Button[] buttons = new Button[]{button1, button2, button3, button4};
        Button.OnClickListener onClickListener = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button1:
                        //初始化按钮颜色
                        initButtonColor(buttons);
                        button1.setBackgroundColor(Color.parseColor("#13BA09"));
                        hideView(linearLayout2);
                        hideView(linearLayout3);
                        hideView(linearLayout4);
                        linearLayout1.setVisibility(View.VISIBLE);
                        setTextViewScroll(textView1);
                        break;
                    case R.id.button2:
                        initButtonColor(buttons);
                        button2.setBackgroundColor(Color.parseColor("#0D8EFF"));
                        hideView(linearLayout1);
                        hideView(linearLayout3);
                        hideView(linearLayout4);
                        linearLayout2.setVisibility(View.VISIBLE);
                        setTextViewScroll(textView2);
                        break;
                    case R.id.button3:
                        initButtonColor(buttons);
                        button3.setBackgroundColor(Color.parseColor("#F13232"));
                        hideView(linearLayout2);
                        hideView(linearLayout1);
                        hideView(linearLayout4);
                        linearLayout3.setVisibility(View.VISIBLE);
                        setTextViewScroll(textView3);
                        break;
                    case R.id.button4:
                        initButtonColor(buttons);
                        button4.setBackgroundColor(Color.parseColor("#7B8587"));
                        hideView(linearLayout2);
                        hideView(linearLayout3);
                        hideView(linearLayout1);
                        linearLayout4.setVisibility(View.VISIBLE);
                        setTextViewScroll(textView4);
                        break;
                }

            }
        };
        button1.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);

        String t1 = textView1.getText().toString();
        System.out.println(t1);
        System.out.println(getFilesDir());
        File t1_file = new File(getFilesDir(),"t1File.txt");
        FileOutputStream fos;
        try {
            fos = openFileOutput("t1File.txt", Context.MODE_PRIVATE);
            fos.write(t1.getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
```

```xml
<TextView
                    android:id="@+id/tet_1"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:background="#ffffff"
                    android:ellipsize="none"
                    android:maxLines="12"
                    android:scrollbarSize="10dp"
                    android:scrollbars="vertical"
                    android:scrollHorizontally="false"
                    android:text="    姑娘果\n    冰激凌\n    QQ软糖\n    火腿\n    阿尔卑斯糖\n    阿华田巧克力酱\n    艾草\n    鹌鹑蛋\n    奥尔良鸡翅\n    奥尔良烤鸡\n    奥利奥饼干\n    奥利奥酸奶蛋糕\n    澳梅\n    澳洲牛肉\n    "
                    android:textColor="#000000"
                    android:textSize="20dp" />
```

## 四、实验结果
![lab5](https://github.com/rsdczhs/android-labs-2020/blob/master/students/net1814080903313/lab05img.png)

## 五、实验心得

本次实验是存储app运行时产生的数据，由于我的app不是很需要用到，所以做了个简单的保存方法，通过File t1_file = new File(getFilesDir(),"t1File.txt");获取当前文件的目录并新建一个txt文件，随后
openFileOutput("t1File.txt", Context.MODE_PRIVATE);向文件中加入内容，这样就能实现将textView中的数据保存到txt文件中了。
