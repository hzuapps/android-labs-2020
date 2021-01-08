#实验五 Android存储编程
##一、实验目标
1.了解Andoid的存储手段
2.掌握Android的文件存储
3.掌握Android的数据库存储
##二、实验内容
1.  根据选题要求使用文件存储
2.  将应用产生的数据保存到文件存储中；
3.  说明使用的文件存储方式：内部 or 外部；
4.  将运行结果截图。
##三、实验步骤 
1、采取内部存储的方式的方式，增加相关代码：
（1）在对MarkActivity.java文件中，增加相关代码实现存储过程，并且显示出存储过程，代码如下：
public class MarkActivity extends  AppCompatActivity {
    Button btn_start;
    EditText et_1,et_2;
    TextView text;
    String fileName = "Hello_file";

    private TextView pu_1;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punchtheclock);
        pu_1 = (TextView) findViewById(R.id.pu_1);
        btn_start= findViewById(R.id.btn_start);
        et_2 = findViewById(R.id.et_2);
        et_1 =  findViewById(R.id.et_1);

    }
    public void btClick (View view) throws IOException {
        String t1 = et_1.getText().toString();
        String t2= et_2.getText().toString();
        FileOutputStream fileOutputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
        fileOutputStream.write((t1+"##"+t2).getBytes());
        if(fileOutputStream !=null){
            fileOutputStream.close();
        }
        Toast.makeText(this,"存储成功",Toast.LENGTH_LONG).show();
    }

    }
（2）在activity_punchtheclock.xml中，将按钮内容改为“”“SAVE IT.”
代码如下：
android:text="save it."
2、在模拟机上面显示已经存储成功后，查看hello_file 文件，查看已经存储了刚刚存储的信息，如图：

3、在gitbash上提交activity_punchtheclock.xml，MarkActivity.java代码，git pus结束。
##四、实验结果

##五、实验心得 
   通过在b站上面学习相关知识，我最后选择了内部存储方式，学习了一些新的函数，对信息的读取以及存储有了一定认知和掌握。
