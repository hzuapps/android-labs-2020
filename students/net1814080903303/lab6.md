# 实验六 Android网络编程

## 一、实验目标

1. 掌握Android网络访问方法；
2. 理解XML和JSON表示数据的方法。

## 二、实验内容

1. 在个人目录中创建一个表示数据的XML或JSON文件；
2. 数据文件代码提交之后从GitHub获取文件URL；
3. 在应用中通过网络编程访问GitHub的数据文件；
4. 在应用中解析并显示文件所包含的数据；
5. 将应用运行结果截图。

## 三、实验步骤

1. 在ClassActivity中运用运用偏好设置创建setview方法实现数据保存

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
2.在ClassActivity中运用运用偏好设置创建backview方法实现数据撤销
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
3.在ClassActivity中运用运用偏好设置创建delect方法实现数据一键清除
```java
    public void delect (View view){
           EditText editText = (EditText) findViewById(R.id.stu_editText1);
           editText.setText(" ");//一键清除
```
## 四、实验结果
![result](https://raw.githubusercontent.com/tiamo669/android-labs-2020/master/students/net1814080903303/sixth_1.jpg)
## 五、实验心得
　　本次实验是Android网络编程，但是根据自己的项目需求我没有运用网络编程，而是继续选择运用偏好设置来完成实验，给“事假请假记录”界面进一步美化，主要是通过三个方法来实现对输入信息的保存、撤销、重置三种功能，
  以满足用户需求。
