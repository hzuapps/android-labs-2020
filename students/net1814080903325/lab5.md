
# 实验五
## 一、实验目标
1. 了解Android的存储手段；
2. 掌握Android的文件存储；
3. 掌握Android的数据库存储 

## 二、实验内容
1. 在Net1814080903325Activity.java中记录当前的播放状态

## 三、实验步骤
1.自定义文件名
```java
    private ImageView mImageView;
    private TextView mTextView;
    private String FileName = "play_state";
```
2. 在Net1814080903325Activity.java中编写init()函数给播放按钮添加点击事件用于存储当前的播放状态
```java
private void init() {
         mImageView = this.findViewById(R.id.detail_play_control);
         mTextView = this.findViewById(R.id.TextView);
         mImageView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 //修改当前的播放状态
                 mTextView.setText("正在播放");
                 //修改ui更新播放状态
                 mImageView.setImageResource(R.mipmap.pause_black_normal);
                 //获取当前的播放状态
                 String text = mTextView.getText().toString();
                 //将当前播放状态保存到sp里头去
                 FileOutputStream fileOutputStream = null;
                 try {
                     fileOutputStream = openFileOutput(FileName, Context.MODE_PRIVATE);
                     fileOutputStream.write(text.getBytes());
                     fileOutputStream.close();
                 } catch (Exception e) {
                     e.printStackTrace();
                 }


             }
         });
    }
```
3. 在OnCreate方法中调用
```java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903325);
        init();
    }
```

## 四、实验结果
![实验结果截图](https://raw.githubusercontent.com/HuaStarOS/android-labs-2020/master/students/net1814080903325/lab5.jpg)

## 五、实验心得
这次实验根据我自己APP的需求，我选择了文件存储。

