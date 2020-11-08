# 一、实验目标
1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。

#  二、实验内容
1. 使用一种布局方式设计界面；
2. 通过控件ID获取界面对象，执行相关操作：
```
// XML
android:id="@+id/my_button"
// Java
findViewById(R.id.my_button);
```
3. 实现界面控件的事件处理;
4. 操作之后，切换到第二个界面。

# 三、实验步骤
1. 根据自己项目设置了GridView布局方式。
2. 在对应的activity（我的是GridViewActivity)根据自己的项目修改布局，比如九宫格或者四宫格；
public class GridViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        GridView gridview = (GridView) findViewById(R.id.grid_view);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // 这里可以添加点击图片后的显示处理
                //Intent intent = new Intent(getApplicationContext(), GridViewOneActivity.class);
                // Pass image index
                //intent.putExtra("id", position);
                //startActivity(intent);
            }
        });
    }
}

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
            imageView.setLayoutParams(new GridView.LayoutParams(560, 450));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }
    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.tu1,
            R.drawable.tu2,
            R.drawable.tu3,
            R.drawable.tu4,
            R.drawable.tu1,
            R.drawable.tu2,
            R.drawable.tu3,
            R.drawable.tu4,
            R.drawable.tu1,
            R.drawable.tu2,
            R.drawable.tu3,
            R.drawable.tu4,
    };
}

# 四、实验结果
![lab4](https://raw.githubusercontent.com/xyl123580/android-labs-2020/master/students/net1814080903110/lab4.png)

# 五、实验心得
了解各个布局的界面，依据项目需要选择了GridView布局，调试中遇到了图片大小问题，可在对应的layout修改格式或者在对应的Java文件解决并显示。
