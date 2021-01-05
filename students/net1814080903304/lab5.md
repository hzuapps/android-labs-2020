# 实验五
## 一、实验目标
&emsp; 1.了解Andoid的存储手段；  
&emsp; 2.掌握Android的文件存储；  
&emsp; 3.掌握Android的数据库存储；  
## 二、实验内容
&emsp; 1.将应用的首选项方式进行存储；  
&emsp; 2.将应用运行结果截图；  
## 三、实验步骤
&emsp; 1.创建EditHomework.java
~~~
private static final String chineseeditText = "chineseeditText";
    private static final String matheditText = "matheditText";
    private static final String englisheditText = "englisheditText";
    private static final String biologyeditText= "biologyeditText";
    private static final String geographyeditText= "geographyeditText";
    private static final String politicseditText= "politicseditText";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_homework);
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

        String contens[]=new String[6];
        contens[0]= settings.getString(chineseeditText, "");
        contens[1]= settings.getString(matheditText, "");
        contens[2]= settings.getString(englisheditText, "");
        contens[3]= settings.getString(biologyeditText, "");
        contens[4]= settings.getString(geographyeditText, "");
        contens[5]= settings.getString(politicseditText, "");
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
        editor.putString(chineseeditText,imformations[0]);     // 字符串值
        editor.putString(matheditText ,imformations[1]);     // 字符串值
        editor.putString(englisheditText,imformations[2]);     // 字符串值
        editor.putString(biologyeditText,imformations[3]);     // 字符串值
        editor.putString(geographyeditText,imformations[4]);     // 字符串值
        editor.putString(politicseditText,imformations[5]);     // 字符串值


        editor.commit(); // 保存

    }

    public EditText[] getEditText(){
        EditText editTexts[]=new EditText[7];
        editTexts[0]=(EditText)findViewById(R.id.chineseeditText);
        editTexts[1]=(EditText)findViewById(R.id.matheditText);
        editTexts[2]=(EditText)findViewById(R.id.englisheditText);
        editTexts[3]=(EditText)findViewById(R.id.biologyeditText);
        editTexts[4]=(EditText)findViewById(R.id.geographyeditText);
        editTexts[5]=(EditText)findViewById(R.id.politicseditText);

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

~~~


&emsp; 2.创建activity_edit_homework.xml
~~~
<TextView
        android:id="@+id/chinesetextView"
        android:layout_width="88dp"
        android:layout_height="45dp"
        android:layout_marginTop="68dp"
        android:text="语文"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <EditText
        android:id="@+id/chineseeditText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="20dp"
        android:layout_marginLeft="20dp"
        android:layout_marginTop="68dp"
        android:ems="10"
        android:inputType="textPersonName"
        android:text=""
        app:layout_constraintStart_toEndOf="@+id/chinesetextView"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/mathtextView"
        android:layout_width="88dp"
        android:layout_height="45dp"
        android:layout_marginTop="45dp"
        android:text="数学"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/chinesetextView" />

    <EditText
        android:id="@+id/matheditText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="20dp"
        android:layout_marginLeft="20dp"
        android:layout_marginTop="45dp"
        android:ems="10"
        android:inputType="textPersonName"
        android:text=""
        app:layout_constraintStart_toEndOf="@+id/mathtextView"
        app:layout_constraintTop_toBottomOf="@+id/chineseeditText" />

    <TextView
        android:id="@+id/englishtextView"
        android:layout_width="88dp"
        android:layout_height="45dp"
        android:layout_marginTop="45dp"
        android:text="英语"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/mathtextView" />

    <EditText
        android:id="@+id/englisheditText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="20dp"
        android:layout_marginLeft="20dp"
        android:layout_marginTop="45dp"
        android:ems="10"
        android:inputType="textPersonName"
        android:text=""
        app:layout_constraintStart_toEndOf="@+id/englishtextView"
        app:layout_constraintTop_toBottomOf="@+id/matheditText" />

    <TextView
        android:id="@+id/biologytextView"
        android:layout_width="88dp"
        android:layout_height="45dp"
        android:layout_marginTop="45dp"
        android:text="生物"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/englishtextView" />

    <EditText
        android:id="@+id/biologyeditText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="20dp"
        android:layout_marginLeft="20dp"
        android:layout_marginTop="45dp"
        android:ems="10"
        android:inputType="textPersonName"
        android:text=""
        app:layout_constraintStart_toEndOf="@+id/biologytextView"
        app:layout_constraintTop_toBottomOf="@+id/englisheditText" />

    <TextView
        android:id="@+id/geographytextView"
        android:layout_width="88dp"
        android:layout_height="45dp"
        android:layout_marginTop="45dp"
        android:text="地理"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/biologytextView" />

    <EditText
        android:id="@+id/geographyeditText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="20dp"
        android:layout_marginLeft="20dp"
        android:layout_marginTop="45dp"
        android:ems="10"
        android:inputType="textPersonName"
        android:text=""
        app:layout_constraintStart_toEndOf="@+id/geographytextView"
        app:layout_constraintTop_toBottomOf="@+id/biologyeditText" />

    <TextView
        android:id="@+id/politicstextView"
        android:layout_width="88dp"
        android:layout_height="45dp"
        android:layout_marginTop="45dp"
        android:text="政治"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/geographytextView" />

    <EditText
        android:id="@+id/politicseditText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="20dp"
        android:layout_marginLeft="20dp"
        android:layout_marginTop="45dp"
        android:ems="10"
        android:inputType="textPersonName"
        android:text=""
        app:layout_constraintStart_toEndOf="@+id/politicstextView"
        app:layout_constraintTop_toBottomOf="@+id/geographyeditText" />


    <Button
        android:id="@+id/CourseChange"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="4dp"
        android:layout_marginLeft="4dp"
        android:layout_marginTop="620dp"
        android:onClick="change"
        android:text="修改"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/courseRestart"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="140dp"
        android:layout_marginLeft="140dp"
        android:layout_marginTop="620dp"
        android:onClick="restart"
        android:text="刷新"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

~~~

## 四、实验结果
![lab5](https://raw.githubusercontent.com/Hacker-LAM/android-labs-2020/master/students/net1814080903304/lab5.png)

## 五、实验心得
&emsp; 本次实验学习了使用首选项存储文本，并显示文本，上网查询相关资料和视频后得以解决，后面再把功能完善起来。
