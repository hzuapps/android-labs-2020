# 实验五：Android存储编程

## 一、实验目标

- 了解Andoid的存储手段
- 掌握Android的文件存储
- 掌握Android的数据库存储

## 二、实验内容

- 使用文件内部存储方式
- 在PersonalDetailsActivity中点击“确定”按钮后，存储EditText框中的值
- 保存完后在布局中读取存储后的数据
- 存储的数据在界面中显示出来

## 三、实验步骤

- 创建一个FileOutputStream对象，MODE_PRIVATE追加模式
- 将获取过来的值放入文件
- 关闭数据流
- 创建一个FileInputStream对象，传入文件

```java
    public void save(View view) {

        if(!TextUtils.isEmpty(etName.getText()) && !TextUtils.isEmpty(etPnum.getText()) && !TextUtils.isEmpty(etAddress.getText())){
            FileOutputStream fos = null;
            try {
                fos = openFileOutput("data", Context.MODE_PRIVATE);
                String str = etName.getText().toString().trim() + "#" + etPnum.getText().toString().trim() + "#" + etAddress.getText().toString().trim();
                fos.write(str.getBytes());
                Toast.makeText(getApplicationContext(), "点单成功", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else{
            Toast.makeText(getApplicationContext(), "请完善信息", Toast.LENGTH_SHORT).show();
        }
    }

    private void read() {
        try{
            FileInputStream data = openFileInput("data");
            BufferedReader reader = new BufferedReader(new InputStreamReader(data));
            String line = reader.readLine();
            String[] split = line.split("#");
            etName.setText(split[0]);
            etPnum.setText(split[1]);
            etAddress.setText(split[2]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
```

- 创建3个EditText框用来输入信息
- 创建一个“确定”按钮Button，声明事件onClick="save"

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="edu.hzuapp.androidlabs.net1814080903321.PersonalDetailsActivity">

    <TextView
        android:id="@+id/head2"
        android:layout_width="411dp"
        android:layout_height="46dp"
        android:background="#55B0ED"
        android:gravity="center"
        android:text="易速达"
        android:textAllCaps="false"
        android:textColor="#FFFFFF"
        android:textColorHighlight="#323232"
        android:textColorHint="#600000"
        android:textSize="36sp"
        android:textStyle="italic"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/textView3"
        android:layout_width="411dp"
        android:layout_height="30dp"
        android:background="#C6C4C4"
        android:gravity="center"
        android:text="请完善订单信息"
        android:textColor="#FFFFFF"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/head2" />

    <EditText
        android:id="@+id/et_name"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="56dp"
        android:hint="姓名"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView3" />

    <EditText
        android:id="@+id/et_pnum"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="52dp"
        android:hint="手机号"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/et_name" />

    <EditText
        android:id="@+id/et_address"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="52dp"
        android:hint="配送地址"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/et_pnum" />

    <Button
        android:layout_width="200dp"
        android:layout_height="63dp"
        android:layout_marginStart="104dp"
        android:layout_marginLeft="104dp"
        android:layout_marginTop="48dp"
        android:onClick="save"
        android:text="确定"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/et_address" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

## 四、实验结果

![个人信息页面](https://github.com/Classic-Z/android-labs-2020/blob/master/students/net1814080903321/5.jpg)  
图1.应用运行结果：提示完善信息

![个人信息页面_1](https://github.com/Classic-Z/android-labs-2020/blob/master/students/net1814080903321/5_1.jpg)  
图2.应用运行结果：提示已完善信息，点单成功

## 五、实验心得

本次实验学会了如何在Android中实现存储数据，了解到有三种方式：一是文件存储，二是轻量存储、三是SQLite数据库存储，三种存储方式各有各的优势，文件存储和轻量存储比较适合存储简单量少的数据，而SQLlite适合存储比较复杂的结构性数据。在易速达APP中，使用文件存储方式就够了，实现方式也很简单。
