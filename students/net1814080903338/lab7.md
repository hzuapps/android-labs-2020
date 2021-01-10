# 一、实验目标
1. 掌握数据库操作方法
2. 掌握输入输出判断

# 二、实验内容
1. 在数据库中添加心情一项
2. 修改写界面、详细界面
3. 添加输入判断

# 三、实验步骤
1. 在操作数据库函数中添加mood
2. 在写界面和详细界面添加输入框
```xml
<EditText
        android:id="@+id/EditWrite_mood"
        android:layout_width="120dp"
        android:layout_height="70dp"
        android:layout_marginBottom="468dp"
        android:hint="心情"
        android:imeOptions="actionDone"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent" />
```
3. 添加输入判断。
```java
 buttonB1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String text = editTextB2.getText() + "";
                String mood = editTextB3.getText() + "";
                if(text != "" && mood != "")
                {
                    userDao.dbInsert(text,mood);
                    Intent intent = new Intent(WriteActivity.this,
                            ReadActivity.class);
                    startActivity(intent);
                }
                else
                {Toast.makeText(
                        WriteActivity.this,
                        "请输入完整信息" , Toast.LENGTH_SHORT)
                        .show();}
            }
        });
```
# 四、实验结果
![详情界面](https://github.com/guo02/android-labs-2020/blob/master/students/net1814080903338/%E8%AF%A6%E7%BB%86%E7%95%8C%E9%9D%A2.jpg?raw=true)
![写界面](https://github.com/guo02/android-labs-2020/blob/master/students/net1814080903338/%E5%86%99%E7%95%8C%E9%9D%A2.jpg?raw=true)
# 五、实验心得
这次实验相对来说比较简单，我添加了心情一项，还对输入等进行了判断，确保APP可以更加符合实际的使用。
