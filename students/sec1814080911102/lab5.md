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

1. 首先在要存内容的xml中新建一个ListView，数据存在这里面;还有一个button用来打开输入内容的窗口。

> activity_list.xml
```xml

    <Button
        android:id="@+id/button_newitems"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="16dp"
        android:backgroundTint="@android:color/background_light"
        android:text="新建待办"
        android:layout_gravity="center"
        tools:ignore="MissingConstraints" />

    <ListView
        android:id="@+id/listview_newitems"
        android:layout_width="300dp"
        android:layout_height="wrap_content"
        android:layout_gravity="center" />

```

2. 定制ListView界面，主要步骤如下：
- 定义一个实体类 Fruit，作为 ListView 适配器的适配类型；
- 为 ListView 的子项指定一个我们自定义的布局 fruit_item.xml，我还加了两个按钮，后续可以通过按钮进行删除等操作；
- 创建一个自定义的适配器 FruitAdapter，这个适配器继承自 ArrayAdapter。重写构造方法和 getView 方法；
- 在ListActivity中编写initFruits方法，初始化水果数据。

> Fruit.java
```java

package edu.hzuapps.androidlabs.sec1814080911102.fruit;

public class Fruit {
    private final String text;
    public Fruit(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }
}

```

>fruit_item.xml
```xml

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="horizontal"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    >
    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="vertical">

        <TextView
            android:id="@+id/fruit_text"
            android:layout_width="190dp"
            android:layout_height="50dp"
            android:gravity="left"
            android:textSize="20dp"
            android:singleLine="false"
            android:lines="2"
            android:ellipsize="end"/>
    </LinearLayout>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:gravity="right">

        <Button
            android:id="@+id/button_item_done"
            android:layout_width="50dp"
            android:layout_height="50dp"
            android:layout_gravity="center"
            android:text="√"
            android:textSize="20dp"/>

        <Button
            android:id="@+id/button_item_delete"
            android:layout_width="50dp"
            android:layout_height="50dp"
            android:layout_gravity="center"
            android:text="×"
            android:textSize="20dp" />
    </LinearLayout>
</LinearLayout>

```

> FruitAdapter.java
```java

package edu.hzuapps.androidlabs.sec1814080911102.fruit;

public class FruitAdapter extends ArrayAdapter {
    private final int resourceId;

    public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fruit fruit = (Fruit) getItem(position); // 获取当前项的Fruit实例
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);//实例化一个对象
        TextView fruitName = (TextView) view.findViewById(R.id.fruit_text);//获取该布局内的文本视图
        fruitName.setText(fruit.getText());//为文本视图设置文本内容
        return view;
    }
}

```

>ListActivity.java
```java

    public void initFruits() {
        fileHelper = new FileHelper(getApplicationContext());
        String data = null;
        String[] fruits = {};
        try {
            data = fileHelper.read("itemdata");
            fruits = data.split("_");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String item:
                fruits) {
            Fruit apple = new Fruit(item);
            fruitList.add(apple);
        }
    }


```

3. 编写一个新的activity：NewItems，在按下ListActivity的button之后，弹出该activity，以达到弹出输入界面的效果。该activity被我做成了一个悬浮窗的样式，通过在styles.xml中写入悬浮窗样式，并在并在AndroidManifest中引用以达到该效果。

>activity_new_items.xml
```xml

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView
        android:id="@+id/textView3"
        android:layout_width="250dp"
        android:layout_height="wrap_content"
        android:layout_marginTop="15dp"
        android:text="新建待办"
        android:textSize="25sp"
        android:gravity="center"
        android:layout_gravity="center"
        tools:ignore="MissingConstraints" />

    <EditText
        android:id="@+id/newitems"
        android:layout_marginTop="10dp"
        android:layout_width="200dp"
        android:layout_height="100dp"
        android:layout_gravity="center"
        android:padding="5dp"
        android:gravity="top"
        android:background="@drawable/activity_list_newitems_bg"/>

    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:layout_gravity="right"
        android:layout_marginRight="15dp"
        android:layout_marginBottom="15dp"
        android:layout_marginTop="20dp">

        <Button
            android:id="@+id/button_new_close"
            android:text="取消"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"/>

        <Button
            android:id="@+id/button_new_ok"
            android:layout_marginLeft="5dp"
            android:text="确认"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"/>
    </LinearLayout>

</LinearLayout>

```

>styles.xml
```xml

<style name="OnePxActivityStyle" parent="Theme.AppCompat.Light.NoActionBar">
        <item name="android:windowTranslucentStatus">true</item><!--透明状态栏并占用状态栏位置 -->
        <item name="android:windowIsTranslucent">true</item><!-- 半透明 -->
        <item name="android:windowBackground">@color/white</item>
        <item name="android:backgroundDimEnabled">true</item>
        <item name="android:windowContentOverlay">@null</item>
        <item name="android:windowCloseOnTouchOutside">false</item>
        <item name="android:backgroundDimAmount">0.5</item><!-- 背景模糊的透明度 数值越小越透明-->
        <item name="android:windowIsFloating">true</item><!-- 浮现在Activity之上 -->
        <item name="windowNoTitle">true</item><!-- 无标题 -->
        <item name="android:windowAnimationStyle">@null</item><!-- 进入和退出动画 -->
    </style>

```

>AndroidManifest.xml
```xml

        <activity
            android:name=".NewItems"
            android:theme="@style/OnePxActivityStyle"></activity>

```

4. 新建一个类FileHelper，里面包含文件保存的方法和文件读取的方法。
>FileHelper.java
```java

public class FileHelper {

    private Context mContext;

    public FileHelper(Context mContext) {
        super();
        this.mContext = mContext;
    }

    /*
     * 这里定义的是一个文件保存的方法，写入到文件中，所以是输出流
     * */
    public void save(String filename, String filecontent) throws Exception {
        //这里我们使用私有模式,创建出来的文件只能被本应用访问
        FileOutputStream output = mContext.openFileOutput(filename, Context.MODE_APPEND);
        output.write(filecontent.getBytes());  //将String字符串以字节流的形式写入到输出流中
        output.close();         //关闭输出流
    }

    /*
     * 这里定义的是文件读取的方法
     * */
    public String read(String filename) throws IOException {
        //打开文件输入流
        FileInputStream input = mContext.openFileInput(filename);
        byte[] temp = new byte[1024];
        StringBuilder sb = new StringBuilder("");
        int len = 0;
        //读取文件内容:
        while ((len = input.read(temp)) > 0) {
            sb.append(new String(temp, 0, len));
        }
        //关闭输入流
        input.close();
        return sb.toString();
    }
}

```

5.当按下NewItemsActivity中确认按钮，将会自动调用FileHelper的方法获取TextView中的内容并保存在文件里，然后传回ListA的ListView中展示出来。
>NewItems.java
```java

public class NewItems extends AppCompatActivity {

    private FileHelper fileHelper;
    private List<Fruit> fruitList = new ArrayList<Fruit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_items);

        fileHelper = new FileHelper(getApplicationContext());
        Button ok = (Button) findViewById(R.id.button_new_ok);
        Button close = (Button) findViewById(R.id.button_new_close) ;
        final EditText edittext = (EditText) findViewById(R.id.newitems);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //这里加下划线是为了把每一次保存的内容隔开，在initFruit();方法中，识别到下划线，就知道是不同的内容
                String text = edittext.getText().toString() + "_";
                //在控制台输出内容，方便观察
                System.out.println("保存成功：" + text);
                if (text.isEmpty()) {
                    //防止保存空内容
                    Toast.makeText(getApplicationContext(), "内容不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        fileHelper.save("itemdata",text);
                        Toast.makeText(getApplicationContext(), "保存成功", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "保存失败", Toast.LENGTH_SHORT).show();
                    }
                    /*
                    这里想在保存数据后通过打开一个新的ListActivity的方式达到刷新页面的效果
                    但是这样之前的页面其实还在那里，所以如果添加了多次数据，那退出的时候也要退出很多次
                    太笨了，算是曲线救国的方法，但是还有更好的方法
                    Intent intent = new Intent(NewItems.this , ListActivity.class);
                    startActivity(intent);
                    */

//                    Intent data = new Intent();这里定义了个data，本来setResult可以带数据回去的，但是我不用，所以也就不需要了
                    //setResult(RESULT_OK, intent);intent为A传来的带有Bundle的intent，当然也可以自己定义新的Bundle
                    setResult(1);
                    //此处一定要调用finish()方法
                    finish();
                }
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

```

>ListActivity.java
```java

public class ListActivity extends AppCompatActivity {
    private FileHelper fileHelper;
    public List<Fruit> fruitList = new ArrayList<Fruit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        FruitAdapter adapter = new FruitAdapter(ListActivity.this, R.layout.fruit_item, fruitList);
        ListView listView = (ListView) findViewById(R.id.listview_newitems);
        listView.setAdapter(adapter);

        initFruits();

        final ListActivity thisActivity = this;
        Button listBtn = (Button) findViewById(R.id.button_newitems);
        listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, NewItems.class);
                /*
                startActivityForResult与startActivity的不同之处在于：
                1、startActivity( )
                仅仅是跳转到目标页面，若是想跳回当前页面，则必须再使用一次startActivity( )。
                2、startActivityForResult( )
                可 以一次性完成这项任务，当程序执行到这段代码的时候，假若从T1Activity跳转到下一个Text2Activity，
                而当这个 Text2Activity调用了finish()方法以后，程序会自动跳转回T1Activity，
                并调用前一个T1Activity中的 onActivityResult( )方法。
                参考文章：https://www.cnblogs.com/yaowen/p/5441728.html
                https://blog.csdn.net/hellobenji/article/details/79978701?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-3.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-3.control
                 */
                startActivityForResult(intent,1);
            }
        });
    }

    //和startActivityForResult配套使用，只要从NewItems回来就会调用这个方法。
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode == 1){
            refresh();
        }
    }

    private void refresh() {
        finish();
        //设置finish();的动画效果为淡入淡出
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        Intent intent = new Intent(ListActivity.this, ListActivity.class);
        startActivity(intent);
        /*设置startActivity();的动画效果为淡入淡出
        参考 https://www.cnblogs.com/dazuihou/p/3585303.html*/
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }

```

## 四、实验结果

![ListActivity](https://github.com/2587900/android-labs-2020/blob/master/students/sec1814080911102/screenshots/lab5ListActivity.PNG)

![NewItemsActivity](https://github.com/2587900/android-labs-2020/blob/master/students/sec1814080911102/screenshots/lab5NewItemsActivity.PNG)


## 五、实验心得

 此次实验，做的是存储功能，我选择的是文件存储，写了一个FileHelper类，通过调用该类的方法实现数据的存取。在实验的过程中遇到了许多问题，导致实验进度缓慢，索性最后都一一解决了。首先是存储方法的选择错误，我第一次参考其他同学的做法，想用`SharedPreferences` 基于XML文件存储 `key-value` 键值对数据，但是怎么怎么都无法成功，后来在舍友的帮助下才改用了选择的方法。
第一次做输入弹窗的时候我想用Dialog，但出现了许多问题，后面才老老实实新做了一个activity。还有一些特别的方法和有坑的地方，是我以前没有遇到过的，我都以注释的形式写在代码里了。这次实验虽然困难，但是让我学会了很多。

