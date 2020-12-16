# 一、实验目标 #

1. 了解Andoid的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储

# 二、实验内容 #
1. 将应用产生的数据保存到文件存储中；
2. 使用内部存储将产生的数据保存到文件存储中；
3. 将运行结果截图

# 三、实验步骤 #
1. 创造一个新的activity并命名为activity_file.xml
2. 在activity_file.xml中创造一个textView
3. 新建java类Net1814080903207FileActivity
4. 在Net1814080903207FileActivity类中写入下列文件输入输出流的代码
```java
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        OutputStream os = null;
        try {

            os = openFileOutput("user_files", MODE_PRIVATE);
            os.write("i am a string in the file!".getBytes());
            os.write("i am the second string in the file!".getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        FileInputStream fis = null;
        try {
            StringBuilder sb = new StringBuilder();
            fis = openFileInput("user_files");
            byte[] buff =new byte[1024];
            int len = 0;
            while((len = fis.read(buff))!=-1){
                sb.append(new String(buff,0,len));
            }

            TextView textView;
            textView=findViewById(R.id.textView);
            textView.setText(sb.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
```
5. 修改Mainfest使此activity可以直接运行
```java
        <activity
            android:name=".Net1814080903207FileActivity"
            android:configChanges="orientation|screenSize|keyboardHidden"
            android:exported="true"
            android:screenOrientation="portrait">
            <!--此处设置 intent-filter-->
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
```

# 四、实验结果 #
![程序界面1](https://raw.githubusercontent.com/522090231/android-labs-2020/master/students/net1814080903207/lab5_answer1.png)

# 五、实验心得 #
  本次实验我选择使用的是内部存储，因为自己选择的APP功能不用使用存储，就新建了一个activity和java类来展示内部存储的功能。本次实验主要是文件输入输出的操作，由于在java课程中有学习过，只要理解好了OutputStream和FileInputStream，本次实验就不会太难。
