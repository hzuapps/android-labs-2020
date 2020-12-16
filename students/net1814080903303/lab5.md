# 实验五

## 一、实验目标

1. 了解Andoid的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储

## 二、实验内容

应用数据存储可采用数据库存储。

1. 将应用产生的数据存储到数据库中；
2. 将应用运行结果截图。

## 三、实验步骤

1. 在StudentActivity中运用运用偏好设置创建setview方法实现数据保存

```java
public void setview(View view){
           EditText editText = (EditText) findViewById(R.id.stu_editText1);
           editText.getText();
           String string = editText.getText().toString();
           SharedPreferences settings = this.getSharedPreferences(
                   "MY_SETTINGS", // 设置的标识、APP可以有多的偏好设置
                   Context.MODE_PRIVATE); //
           //SharedPreferences settings = this.getSharedPreferences(
           //        Context.MODE_PRIVATE); // 不指定ID、使用默认偏好设置（只有一个）
           SharedPreferences.Editor editor = settings.edit(); // 开始编辑设置
           editor.putString(ID,string);     // 字符串值
           editor.commit(); // 保存
       }
```
2.在StudentActivity中运用运用偏好设置创建backview方法实现数据撤销
```java
       public void backview (View view){
           SharedPreferences settings = this.getSharedPreferences(
                   "MY_SETTINGS", // 设置的标识、APP可以有多的偏好设置
                   Context.MODE_PRIVATE); //
           String id = settings.getString(ID, "");
           EditText editText = (EditText) findViewById(R.id.stu_editText1);
           editText.setText(id);
       }
       public void delect (View view){
           EditText editText = (EditText) findViewById(R.id.stu_editText1);
           editText.setText(" ");//撤销
       }
```
3.在StudentActivity中运用运用偏好设置创建delect方法实现数据一键清除
```java
    public void delect (View view){
           EditText editText = (EditText) findViewById(R.id.stu_editText1);
           editText.setText(" ");//一键清除
```
## 四、实验结果
![result](https://raw.githubusercontent.com/tiamo669/android-labs-2020/master/students/net1814080903303/fifth.jpg)
## 五、实验心得
　　本次实验是Android存储编程，实验难度适中，根据自己的实验需求我选择运用偏好设置来完成实验，主要是通过三个方法来实现对输入信息的保存、撤销、重置三种功能，以满足用户需求。
