# 实验五：Android存储编程

## 一、实验目标

1. 了解Andoid的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储

## 二、实验内容

1. 定义一个文件保存的方法，写入到文件中
2. 定义文件读取的方法
3. 在Net1814080903326Activity中调用

## 三、实验步骤
```xml

<TextView
        android:id="@+id/tv_show"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:padding="20dp"
        android:text="123"
        android:textSize="20dp"

        ></TextView>

    <EditText
        android:id="@+id/tv_show"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="20dp"
        android:layout_marginLeft="20dp"
        android:layout_marginTop="68dp"
        android:ems="10"
        android:inputType="textPersonName"
        android:text=""
        app:layout_constraintStart_toEndOf="@+id/tv_show"
        app:layout_constraintTop_toTopOf="parent" />

```

```java

public class Net1814080903326Activity extends AppCompatActivity {
         private static final String tv_show = "tv_show";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903326); 
    }

    public void change(View view){
        changeImformation();
    }

    public void restart(View view){
        String []texts=getImformation();
        changeEditText(texts);
    }

    public String[] getImformation(){
        SharedPreferences settings = this.getSharedPreferences(
                "MY_IMFORMATION", // 设置的标识、APP可以有多的偏好设置
                Context.MODE_PRIVATE); //

        String contens[]=new String[1];
        contens[0]= settings.getString(tv_show, "");

        return contens;
    }

    public void changeImformation(){
        SharedPreferences settings = this.getSharedPreferences(
                "MY_IMFORMATION", // 设置的标识、APP可以有多的偏好设置
                Context.MODE_PRIVATE); //
        //SharedPreferences settings = this.getSharedPreferences(
        //        Context.MODE_PRIVATE); // 不指定ID、使用默认偏好设置（只有一个）
        SharedPreferences.Editor editor = settings.edit(); // 开始编辑设置

        String imformations[]=getText();
        editor.putString(tv_show,imformations[0]);     // 字符串值
        editor.commit(); // 保存

    }

    public EditText[] getEditText(){
        EditText editTexts[]=new EditText[2];
        editTexts[0]=(EditText)findViewById(R.id.tv_show);

        return editTexts;
    }

    public void changeEditText(String[] imformations){
        EditText []editTexts=getEditText();
        for(int i=0;i<imformations.length;i++) {
            editTexts[i].setText(imformations[i]);
        }
    }

    public String[] getText(){
        EditText []editTexts=getEditText();
        String texts[]=new String[6];
        for(int i=0;i<6;i++){
            texts[i]=editTexts[i].getText().toString();
        }
        return texts;
    }
}
```


## 四、实验结果


## 五、实验心得体会
实验将String字符串以字节流的形式写入到输出流中，本地存储较容易实现。
