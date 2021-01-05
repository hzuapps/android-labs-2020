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
1.界面按钮设置不同的内容，点击相应的内容，界面中的商品会改变
```
       shoes.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                if(v==shoes)
                {
                     iconname=context.getResources().getStringArray(R.array.shoes);
                    final int[] b=new int[iconname.length];
                    for(int i=0;i<4;i++)
                        b[i]=context.getResources().getIdentifier(iconname[i],"drawable",getPackageName());
                    imageView1.setImageResource(b[0]);
                    imageView2.setImageResource(b[1]);
                    imageView3.setImageResource(b[2]);
                    imageView4.setImageResource(b[3]);
                    textView1.setText("1299");
                    textView2.setText("1099");
                    textView3.setText("899");
                    textView4.setText("699");
                }
           }
       });
 ```
2.点击按钮之后会调用函数，把选取的内容存储到goods这个activity中，在点击购物车的查询按钮之后会将所有已选货物显示出来
```
  public void get_goods(Bitmap goods,String price)
    {
        for(int i=0;i<2;i++)
        {
           if(have_choose[i]==null && have_choose[i+1]!=null)
           {
               have_choose[i]=have_choose[i+1];
               have_choose[i+1]=null;
           }
           if(i<1 && have_choose[i]==null && have_choose[i+2]!=null)
           {
               have_choose[i]=have_choose[i+2];
               have_choose[i+2]=null;
           }
        }
 add_goods1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            goods goods=new goods();
            goods.get_goods(((BitmapDrawable)imageView1.getDrawable()).getBitmap(),textView1.getText().toString());
            }
        });
  check_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==check_now)
                {
                    goods goods=new goods();
                    Bitmap[] a=goods.show_goods();
                    String[] showprice=goods.show_price();
                    goods1.setImageBitmap(a[0]);
                    goods2.setImageBitmap(a[1]);
                    goods3.setImageBitmap(a[2]);
                    price1.setText(showprice[0]);
                    price2.setText(showprice[1]);
                    price3.setText(showprice[2]);
                }
            }
        });
```
3.点击购物车中的总价按钮会将页面中所有textview中内容读取之后转化为int类型之后相加，并显示在按钮后的文本框中        
```
 price_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                price=0;
                if(checkBox1.isChecked()==true)
                {
                    price=price+Integer.parseInt(price1.getText().toString());
                }
                if(checkBox2.isChecked()==true)
                {
                    price=price+Integer.parseInt(price2.getText().toString());
                }
                if(checkBox3.isChecked()==true)
                {
                    price=price+Integer.parseInt(price3.getText().toString());
                }
                final_price.setText(price+"元");
            }
        });
 ```
 ## 四、实验结果
 [第四次实验图片1](https://github.com/wjm20000603/android-labs-2020/tree/master/students/net1814080903206/testimage/t4(1).jpg)  
[第四次实验图片2](https://github.com/wjm20000603/android-labs-2020/tree/master/students/net1814080903206/testimage/t4(2).jpg)  
[第四次实验图片3](https://github.com/wjm20000603/android-labs-2020/tree/master/students/net1814080903206/testimage/t4(3).jpg)  

## 五、心得体会
这次的实验内容比较多，比较复杂，所有花费的时间很多。在这次实验中，已经将软件大部分的功能完成，不同商品的显示，商品的搜索，商品的选择，以及不同activity传递图片和参数
