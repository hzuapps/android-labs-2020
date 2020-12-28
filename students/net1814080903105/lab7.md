# 实验七
## 一、实验目标（选做）
理解Android相机、蓝牙、传感器等设备编程方法。
理解Android设备编程与前面所学组件、存储、网络及界面开发的知识点关系。

## 二、实验内容
1. 选择一个跟选题相关的设备功能；
（1）拍照显示、录视频；
（2）控制和检测网络；
（3）获取用户位置信息；
（4）判断屏幕方向并提示用户旋转手机（小游戏）；
（5）摇一摇手机。
2. 编程实现设备使用。

## 三、实验步骤
1. 把商品信息图片数组封装起来；
2. 创建商品信息CommodityInfoActivity和相应的xml文件，用来显示商品信息；
```java
        DataArray dataArray = new DataArray();
        Intent intent = getIntent();
        final Integer position = intent.getIntExtra("id",0);

        ImageView imageView = findViewById(R.id.commodity_picture);
        imageView.setImageResource(dataArray.Picture[position]);
        TextView textView = null;
        textView = findViewById(R.id.commodity_name);
        textView.setText(dataArray.Name[position]);
        textView = findViewById(R.id.commodity_series);
        textView.setText(dataArray.Series[position]);
```
3. 添加“加入购物车”按钮，将数据传到购物车ShoppingActivity；
```java
public void onClick(View v) {
                TextView textView=(TextView) findViewById(R.id.commodity_name);
                String inputText=textView.getText().toString();
                Intent intent=new Intent(CommodityInfoActivity.this,ShoppingActivity.class);
                intent.putExtra("data",inputText);
                startActivity(intent);
            }
```
4. 修改主界面页面跳转相关代码。

## 四、实验结果
![商品信息](https://github.com/czj-105/android-labs-2020/blob/master/students/net1814080903105/lab7.jpg)

## 五、实验心得
没有用到设备，增加了商品信息activity，商品信息图片数组封装方便操作，修改了主界面页面跳转相关代码。