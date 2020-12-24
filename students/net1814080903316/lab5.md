# 实验五
## 1.实验目标
1. 了解Andoid的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储
## 2.实验内容
1. 将应用产生的数据保存到偏好设置中；
2. 说明使用的偏好设置存储方式；
3. 将运行结果截图。
## 3.实验步骤
1. 创建一个activity文件，名字为ImformationActivity，其相应界面文件activity_imformation.xml采用默认的约束布局。
2. 在activity_imformation.xml上设置组件用于显示与输入信息，分别是文字框、输入框、按钮。
```
<TextView
    android:id="@+id/textView2"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_marginStart="24dp"
    android:layout_marginLeft="24dp"
    android:layout_marginTop="60dp"
    android:text="学号："
    android:textSize="24sp"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toTopOf="parent" />

<EditText
    android:id="@+id/ID"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_marginStart="51dp"
    android:layout_marginLeft="51dp"
    android:ems="10"
    android:enabled="true"
    android:inputType="textPersonName"
    android:text="ID"
    app:layout_constraintBaseline_toBaselineOf="@+id/textView2"
    app:layout_constraintStart_toEndOf="@+id/textView2" />
```

２. 设计函数，获取输入框对象。
```
public EditText[] getEditText(){
    EditText editTexts[]=new EditText[7];
    editTexts[0]=(EditText)findViewById(R.id.ID);
    editTexts[1]=(EditText)findViewById(R.id.Name);
    editTexts[2]=(EditText)findViewById(R.id.School);
    editTexts[3]=(EditText)findViewById(R.id.Major);
    editTexts[4]=(EditText)findViewById(R.id.CollegeName);
    editTexts[5]=(EditText)findViewById(R.id.ClassName);
    editTexts[6]=(EditText)findViewById(R.id.Grade);
    return editTexts;
　}
```

３. 设计函数，获取从activity_imformation.xml界面输入框上的信息。
```
public String[] getText(){
    EditText []editTexts=getEditText();
    String texts[]=new String[7];
    for(int i=0;i<7;i++){
        texts[i]=editTexts[i].getText().toString();
    }
    return texts;
}
```

4. 使用偏好设置存储方式，存储来自输入框的信息。
```
public void changeImformation(){
    SharedPreferences settings = this.getSharedPreferences(
            "MY_IMFORMATION",Context.MODE_PRIVATE); 
    SharedPreferences.Editor editor = settings.edit(); // 开始编辑设置
    String imformations[]=getText();
    editor.putString(ID,imformations[0]);     // 字符串值
    editor.putString(NAME ,imformations[1]);     // 字符串值
    editor.putString(SCHOOL,imformations[2]);     // 字符串值
    editor.putString(COLLEGE,imformations[3]);     // 字符串值
    editor.putString(MAJOR,imformations[4]);     // 字符串值
    editor.putString(CLASSNAME,imformations[5]);     // 字符串值
    editor.putString(GRADE,imformations[6]);     // 字符串值
    editor.commit(); // 保存
}
```

5. 设计函数，将偏好设置中存储的信息显示在界面上。
```
public void changeEditText(String[] imformations){
    EditText []editTexts=getEditText();
    for(int i=0;i<imformations.length;i++) {
        editTexts[i].setText(imformations[i]);
    }
}
```
## 4.实验结果
![项目图片](https://github.com/alllovetaken/android-labs-2020/blob/master/students/net1814080903316/lab5result.PNG)
## 5.实验心得
  这次实验的重点是实现前端与后端的交互。前端设计方面因为有图形化界面设计，所以并没有遇到太大的问题。而前后端交互由于在之前的Java课程中已经有所接触，虽然部分语法有所不同，但在思想上差别不大，所以理解起来难度并不大。在存储方式的选择上，偏好设置相较于其他两种存储方式要简单很多，如果对Map容器比较熟悉的话，很快就能上手。
