# 实验七 Android设备编程

## 一、实验目标

1. 理解Android相机、蓝牙、传感器等设备编程方法。
2. 理解Android设备编程与前面所学组件、存储、网络及界面开发的知识点关系。

## 二、实验内容

1.选择一个跟选题相关的设备功能；
（1）拍照显示、录视频；
（2）控制和检测网络；
（3）获取用户位置信息；
（4）判断屏幕方向并提示用户旋转手机（小游戏）；
（5）摇一摇手机。

## 三、实验步骤

1. 在InfomationActivity中运用运用偏好设置创建setview方法实现数据保存

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
2.在InfomationActivity中运用运用偏好设置创建backview方法实现数据撤销
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
3.在InfomationActivity中运用运用偏好设置创建delect方法实现数据一键清除
```java
    public void delect (View view){
           EditText editText = (EditText) findViewById(R.id.stu_editText1);
           editText.setText(" ");//一键清除
```
## 四、实验结果
![result](https://raw.githubusercontent.com/tiamo669/android-labs-2020/master/students/net1814080903303/seventh.jpg)
## 五、实验心得
　　本次实验是Android设备编程，但是根据自己的项目需求我没有运用设备编程，而是继续选择运用偏好设置来完成实验，给“病假请假记录”界面进一步美化，主要是通过三个方法来实现对输入信息的保存、撤销、重置三种功能，
  以满足用户需求。
