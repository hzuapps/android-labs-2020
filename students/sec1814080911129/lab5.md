# 实验五
## 1.实验目标
1. 了解Andoid的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储
## 2.实验内容
1. 将应用产生的数据保存到本地文件中；
2. 下次运行读取本地文件；
3. 将运行结果截图。
## 3.实验步骤
1. 在tax.xml上设置组件用于显示与输入信息，分别是文字框、输入框、按钮。
```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <ImageView
        android:id="@+id/imageView2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginEnd="4dp"
        android:layout_marginBottom="4dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:srcCompat="@drawable/q20201122173515" />

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="身高(cm)"
        android:id="@+id/txt1"/>
    <EditText
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/edX"/>
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="体重(kg)"
        android:id="@+id/txt2"/>
    <EditText
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/edY"/>
    <RadioGroup
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:id="@+id/rg">
        <RadioButton
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="男"
            android:id="@+id/rb1"
            android:layout_marginRight="30dp"
            android:checked="true"/>
        <RadioButton
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="女"
            android:id="@+id/rb2"

            />
    </RadioGroup>
    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/btn"
        android:text="计算BMI值"/>
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/tvResult"/>

    </LinearLayout>

</androidx.constraintlayout.widget.ConstraintLayout>
```

２. 进行计算
```
public void onClick(View v) {
        double x = Double.parseDouble(txt1.getText().toString());//身高
        double y = Double.parseDouble(txt2.getText().toString());//体重//体重除以身高的平方
        double res;
        String str = "Your BMI is";
        String str2 = "Your last BMI is";

        if(x<=0 || y<=0) {
            tvResult.setText("值异常，不计算");
            return ;
        }
        x = x/100;
        res = y / (x*x);
        String str1 = String.format("%.2f",res);
        str = str + str1;

        if(rb1.isChecked())
            res -= 1;//以女性为标准进行比较
        //仅以女性作为评价标准
        str +=   "体型:";
        if(res < 19)
            str += "过轻";
        else if(res < 24)
            str += "适中";
        else if(res<29)
            str += "超重";
        else if(res<34)
            str += "肥胖";
        else
            str += "严重肥胖";
        tvResult.setText(str);}
```

３. 储存输入数据
```
 SharedPreferences.Editor editor=getSharedPreferences("data",MODE_PRIVATE).edit();//定义一个data文件来进行数据储存
        editor.putString("体重",txt1.getText().toString());
        editor.putString("身高",txt2.getText().toString());
        editor.apply();
}
```

4. 读取历史数据
```
private void onClick() {SharedPreferences preferences=getSharedPreferences("data",MODE_PRIVATE);//从data文件中进行数据读取
        txt2.setText(preferences.getString("身高",""));
        txt1.setText(preferences.getString("体重",""));
}
```


## 4.实验结果
![第一次打开界面进行运算](https://github.com/wolkenthrut7/android-labs-2020/blob/master/students/sec1814080911129/lab5-1.png)
![再次打开界面](https://github.com/wolkenthrut7/android-labs-2020/blob/master/students/sec1814080911129/lab5.png)
## 5.实验心得
    这次实验的重点是实现前端与后端的交互。选择了比较简单的本地储存文件，不另外引入数据库和网络储存，可以较为快速地实现目标，不必进行过多的交互从而导致出现其他未知错误。
