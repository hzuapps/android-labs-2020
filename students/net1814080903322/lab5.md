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
 private static final String classroomaddresseditText = "classroomaddresseditText";
    private static final String classroomnumbereditText = "classroomnumbereditText";
    private static final String booktimeeditText = "booktimeeditText";
    private static final String applicanteditText= "applicanteditText";
    private static final String PurposeapplicationText= "PurposeapplicationeditText";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edticlassroom);
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
        contens[0]= settings.getString(classroomaddresseditText, "");
        contens[1]= settings.getString(classroomnumbereditText, "");
        contens[2]= settings.getString(booktimeeditText, "");
        contens[3]= settings.getString(applicanteditText, "");
        contens[4]= settings.getString(PurposeapplicationText, "");
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
        editor.putString(classroomaddresseditText,imformations[0]);     // 字符串值
        editor.putString(classroomnumbereditText ,imformations[1]);     // 字符串值
        editor.putString(booktimeeditText,imformations[2]);     // 字符串值
        editor.putString(applicanteditText,imformations[3]);     // 字符串值
        editor.putString(PurposeapplicationText,imformations[4]);     // 字符串值



        editor.commit(); // 保存

    }

    public EditText[] getEditText(){
        EditText editTexts[]=new EditText[7];
        editTexts[0]=(EditText)findViewById(R.id.classroomaddressText);
        editTexts[1]=(EditText)findViewById(R.id.classroomnumbereditText);
        editTexts[2]=(EditText)findViewById(R.id.booktimeeditText);
        editTexts[3]=(EditText)findViewById(R.id.applicanteditText);
        editTexts[4]=(EditText)findViewById(R.id.PurposeapplicationeditText);


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


&emsp; 2.创建activity_edticlassroom.xml
~~~
<TextView
        android:id="@+id/classroomaddresstextView"
        android:layout_width="88dp"
        android:layout_height="45dp"
        android:layout_marginTop="68dp"
        android:text="教学楼地点"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <EditText
        android:id="@+id/classroomaddressText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="20dp"
        android:layout_marginLeft="20dp"
        android:layout_marginTop="68dp"
        android:ems="10"
        android:inputType="textPersonName"
        android:text=""
        app:layout_constraintStart_toEndOf="@+id/classroomaddresstextView"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/classroomnumbertextView"
        android:layout_width="88dp"
        android:layout_height="45dp"
        android:layout_marginTop="45dp"
        android:text="教室房间号"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/classroomaddresstextView" />

    <EditText
        android:id="@+id/classroomnumbereditText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="20dp"
        android:layout_marginLeft="20dp"
        android:layout_marginTop="45dp"
        android:ems="10"
        android:inputType="textPersonName"
        android:text=""
        app:layout_constraintStart_toEndOf="@+id/classroomnumbertextView"
        app:layout_constraintTop_toBottomOf="@+id/classroomaddresstextView" />

    <TextView
        android:id="@+id/booktimetextView"
        android:layout_width="88dp"
        android:layout_height="45dp"
        android:layout_marginTop="45dp"
        android:text="预订时间"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/classroomnumbertextView" />

    <EditText
        android:id="@+id/booktimeeditText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="20dp"
        android:layout_marginLeft="20dp"
        android:layout_marginTop="45dp"
        android:ems="10"
        android:inputType="textPersonName"
        android:text=""
        app:layout_constraintStart_toEndOf="@+id/booktimetextView"
        app:layout_constraintTop_toBottomOf="@+id/classroomnumbereditText" />

    <TextView
        android:id="@+id/applicanttextView"
        android:layout_width="88dp"
        android:layout_height="45dp"
        android:layout_marginTop="45dp"
        android:text="申请人"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/booktimetextView" />

    <EditText
        android:id="@+id/applicanteditText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="20dp"
        android:layout_marginLeft="20dp"
        android:layout_marginTop="45dp"
        android:ems="10"
        android:inputType="textPersonName"
        android:text=""
        app:layout_constraintStart_toEndOf="@+id/applicanttextView"
        app:layout_constraintTop_toBottomOf="@+id/booktimeeditText" />

    <TextView
        android:id="@+id/PurposeapplicationtextView"
        android:layout_width="88dp"
        android:layout_height="45dp"
        android:layout_marginTop="45dp"
        android:text="申请目的"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/applicanttextView" />

    <EditText
        android:id="@+id/PurposeapplicationeditText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="20dp"
        android:layout_marginLeft="20dp"
        android:layout_marginTop="45dp"
        android:ems="10"
        android:inputType="textPersonName"
        android:text=""
        app:layout_constraintStart_toEndOf="@+id/PurposeapplicationtextView"
        app:layout_constraintTop_toBottomOf="@+id/applicanteditText" />




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


## 四、实验心得
&emsp; 本次实验学习了使用首选项存储文本，并显示文本，通过查阅网上的知识和同学的帮助，可以顺利完成！
