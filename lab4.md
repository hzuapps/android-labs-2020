# 实验四
## 一、实验目标
1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。

## 二、实验内容
1. 使用一种布局方式设计界面；
2. 通过控件ID获取界面对象，执行相关操作：
3. 实现界面控件的事件处理;
4. 操作之后，切换到第二个界面。

## 三、实验步骤
1. 主界面采用ConstraintLayout布局，主要设置了两个按钮；
2. 按钮添加事件监听器实现界面跳转；
3. 商品列表界面使用相对布局，购物车界面使用约束布局；
4. 在商品界面的XML文件中使用GridView来显示图片。
```java
class ImageAdapter extends BaseAdapter {
    private Context mContext;

    // Constructor
    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(400, 300));
            imageView.setScaleType(ImageView.ScaleType.FIT_START);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.h01,
            R.drawable.h02,
            R.drawable.h03,
            R.drawable.h04,
            R.drawable.h01,
            R.drawable.h02,
            R.drawable.h03,
            R.drawable.h04,
            R.drawable.h01,
            R.drawable.h02,
            R.drawable.h03,
            R.drawable.h04
    };
}
```
```xml
       <GridView
        android:id="@+id/grid_view"
        android:layout_width="fill_parent"
        android:layout_height="fill_parent"
        android:columnWidth="100dp"
        android:horizontalSpacing="10dp"
        android:numColumns="1"
        android:stretchMode="columnWidth"
        android:verticalSpacing="0dp"
        />
```
5. 在购物车界面的XML文件中使用ListView来显示购物记录。
```java
String[] mobileArray = { //
            "购物车", "商品1", "商品2", "商品3","商品4","商品5"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, //
                R.layout.activity_splist_view_item, mobileArray);

        ListView listView = (ListView) findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);

        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        };
        listView.setOnItemClickListener(listener);
    }
```
```xml
<ListView
    android:id="@+id/mobile_list"
    android:layout_width="match_parent"
    android:layout_height="wrap_content" >
</ListView>
```

## 四、实验结果
![ListView](https://github.com/czj-105/android-labs-2020/blob/master/students/net1814080903105/lab4_2.jpg)
![GridView](https://github.com/czj-105/android-labs-2020/blob/master/students/net1814080903105/lab4_3.jpg)

## 五、实验心得
本次实验主要是设计界面，使用了GridView，ListView，基本界面设计完成，但后续还需要对界面的设计进行改善并完善功能。
