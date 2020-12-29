# 一、实验目标

1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。（不要做登录注册)

# 二、实验内容

1. 了解界面布局的几种类型：LinearLayout, RelativeLayout, Adapter, ConstraintLayout；
2. 使用上述其中一种布局进行选题各界面的设计；
3. 使用和选题各界面相关的控件；
4. 实现界面控件的事件处理

# 三、实验步骤

1. 使用其中一种布局方式，设计所选题目的界面，建议用LinearLayout。
2. 通过控件ID获取界面对象，执行相关操作：

```
//xml
<LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <Button
            android:id="@+id/net_con1"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="contact"
            android:textSize="20dp"
            android:layout_marginTop="550dp"
            />

        <Button
            android:id="@+id/net_dyn1"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_marginTop="550dp"
            android:layout_weight="1"
            android:text="dynamic"
            android:textSize="20dp" />
    </LinearLayout>
    
//java
findViewById(R.id.net_con1);
findViewById(R.id.net_dyn1);
```

3. 实现界面控件的事件处理，例如点击按钮：

```
Button btnCon = (Button) findViewById(R.id.net_con1);
Button btnDyn = (Button) findViewById(R.id.net_dyn1);
```

4. 操作之后，切换到你的第二个界面

```
btnCon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,ContactActivity.class);
                thisActivity.startActivity(intent);
            }
        });
 
btnDyn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(thisActivity,DynamicActivity.class);
                thisActivity.startActivity(intent1);
            }
        });
```

# 四、实验结果


# 五、实验心得
我在本次实验中学到了Android界面设计编程中的LinearLayout和RelativeLayout布局的使用，尤其熟悉了<Button/>组件的运用
