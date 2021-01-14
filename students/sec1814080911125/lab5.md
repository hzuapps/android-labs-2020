# 实验五：Android存储编程
## 一、实验目标
- 了解Andoid的存储手段
- 掌握Android的文件存储
- 掌握Android的数据库存储
## 二、实验内容
- 根据选题要求使用数据库存储

1. 将应用产生的数据存储到数据库中；
2. 将应用运行结果截图。
## 三、实验步骤
1. 创建两个新java文件，命名为DBOpenHelper.java、User.java

2. 创建两个空Activity，命名为LoginActivity.java、RegisterActivity.java，为登录界面和注册界面

3. 在activity_login.xml设置布局为ConstraintLayout，设置6个组件，分别是标题、用户名输入、密码输入、记住密码、用户注册、登录按钮

4. 在activity_registered.xml设置布局为ConstraintLayout，设置6个组件，分别是返回按钮、用户名输入、手机号输入、密码输入、确认密码、注册按钮

5. 注册时将获取的数据存储到数据库中

   ```java
    protected void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
           setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);//禁止横屏
           setContentView(R.layout.activity_registered);
           setTitle("用户注册");//顶部标题改成用户注册
   
           initView();//初始化界面
           mDBOpenHelper = new DBOpenHelper(this);
       }
   
       private void initView() {
           et_rgsName = findViewById(R.id.et_rgsName);
           et_rgsPhoneNum = findViewById(R.id.et_rgsPhoneNum);
           et_rgsPsw1 = findViewById(R.id.et_rgsPsw1);
           et_rgsPsw2 = findViewById(R.id.et_rgsPsw2);
   
           Button btn_register = findViewById(R.id.btn_rgs);
           ImageView iv_back = findViewById(R.id.iv_back);
   
           //监听注册页面返回按钮、注册按钮
           iv_back.setOnClickListener(this);
           btn_register.setOnClickListener(this);
       }
   
       @Override
       public void onClick(View v) {
           switch (v.getId()) {
               case R.id.iv_back://返回按钮，返回登录界面
                   Intent intent = new Intent(RegisteredActivity.this, LoginActivity.class);
                   startActivity(intent);
                   finish();
                   break;
               case R.id.btn_rgs://注册按钮
                   //获取用户输入的用户名、密码
                   String username = et_rgsName.getText().toString().trim();
                   String password1 = et_rgsPsw1.getText().toString().trim();
                   String password2 = et_rgsPsw2.getText().toString().trim();
                   String phonenum = et_rgsPhoneNum.getText().toString().trim();
                   //注册验证
                   if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password1) && !TextUtils.isEmpty(password2)) {
                       //判断两次密码是否一致
                       if (password1.equals(password2)) {
                           //将用户名和密码加入到数据库中
                           mDBOpenHelper.add(username, password2, phonenum);
                           Intent intent1 = new Intent(RegisteredActivity.this, LoginActivity.class);
                           startActivity(intent1);
                           finish();
                           Toast.makeText(this, "验证通过，注册成功", Toast.LENGTH_SHORT).show();
                       } else {
                           Toast.makeText(this, "两次密码不一致,注册失败", Toast.LENGTH_SHORT).show();
                       }
                   } else {
                       Toast.makeText(this, "注册信息不完善,注册失败", Toast.LENGTH_SHORT).show();
                   }
                   break;
           }
       }
   ```

6. 连接数据库DBOpenHelper

   ```java
   public class DBOpenHelper extends SQLiteOpenHelper {
   
       //声明数据库db
       private SQLiteDatabase db;
   
       //构造函数，指明上下文、数据库名、工厂默认空值、版本号为1
       DBOpenHelper(Context context){
           super(context,"db_test",null,1);
           db = getReadableDatabase();
       }
   
       //重写onCreate()、onUpgrade()方法
       @Override
       public void onCreate(SQLiteDatabase db){
           db.execSQL("CREATE TABLE IF NOT EXISTS user(" +
                   "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                   "name TEXT," +
                   "password TEXT," +
                   "email TEXT," +
                   "phonenum TEXT)"
           );
       }
       //版本适应
       @Override
       public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
           db.execSQL("DROP TABLE IF EXISTS user");
           onCreate(db);
       }
   
       //定义增方法
       void add(String name, String password,String phonenum){
           db.execSQL("INSERT INTO user (name,password,email,phonenum) VALUES(?,?,?,?)",new Object[]{name,password,phonenum});
       }
   
   
       //使用游标获取数据存放到list容器中
       ArrayList<User> getAllData(){
           ArrayList<User> list = new ArrayList<User>();
           @SuppressLint("Recycle") Cursor cursor = db.query("user",null,null,null,null,null,"name DESC");
           while(cursor.moveToNext()){
               String name = cursor.getString(cursor.getColumnIndex("name"));
               String phonenum = cursor.getString(cursor.getColumnIndex("phonenum"));
               String password = cursor.getString(cursor.getColumnIndex("password"));
   
               list.add(new User(name,password,phonenum));
           }
           return list;
       }
   }
   ```

7. User.java

   ```java
   public class User {
       private String name;            //用户名
       private String password;        //密码
       private String phonenum;        //手机号码
   
       User(String name, String password,String phonenum) {
           this.name = name;
           this.password = password;
           this.phonenum = phonenum;
       }
   
       public String getPhonenum() {
           return phonenum;
       }
   
       public void setPhonenum(String phonenum) {
           this.phonenum = phonenum;
       }
   
       public String getName() {
           return name;
       }
   
       public void setName(String name) {
           this.name = name;
       }
   
       public String getPassword() {
           return password;
       }
   
       public void setPassword(String password) {
           this.password = password;
       }
   
       @Override
       public String toString() {
           return "User{" +
                   "name='" + name + '\'' +
                   ", password='" + password + '\'' +
                   ", phonenum='" + phonenum + '\'' +
                   '}';
       }
   }
   ```

8. 登录时与数据库中数据进行匹配，匹配成功进行页面跳转

   ```java
   public void onClick(View v) {
           switch (v.getId()){
               case R.id.tv_Register: //注册
                   Intent intent = new Intent(LoginActivity.this, RegisteredActivity.class);//跳转到注册界面
                   startActivity(intent);
                   finish();
                   break;
               //登录验证
               case R.id.btn_Login:
                   //获取输入数据
                   String name = et_User.getText().toString().trim();
                   String password = et_Psw.getText().toString().trim();
                   //判断输入数据是否为空，若不为空则与数据库中数据进行匹配，匹配成功进行页面跳转
                   if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(password)) {
                       ArrayList<User> data = mDBOpenHelper.getAllData();
                       boolean match = false;
                       boolean match2 = false;
                       for (int i = 0; i < data.size(); i++) {
                           User user = data.get(i);
                           if ((name.equals(user.getName()) && password.equals(user.getPassword()))||
                                   (name.equals(user.getPhonenum())&&password.equals(user.getPassword()))) {
                               userName = user.getName();
                               match = true;
                               if(cb_rmbPsw.isChecked()){
                                   editor.putBoolean("flag",true);
                                   editor.putString("user",user.getName());
                                   editor.putString("psw",user.getPassword());
                                   editor.apply();
                                   match2 = true;
                               }else {
                                   editor.putString("user",user.getName());
                                   editor.putString("psw","");
                                   editor.apply();
                                   match2 = false;
                               }
                               break;
                           } else {
                               match = false;
                           }
                       }
                       if (match) {
                           if(match2){
                               Toast.makeText(this, "成功记住密码", Toast.LENGTH_SHORT).show();
                               cb_rmbPsw.setChecked(true);
                           }
                           Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                           Runnable target;
                           //用线程启动
                           Thread thread = new Thread(){
                               @Override
                               public void run(){
                                   try {
                                       sleep(2000);//延时2秒
                                       String user_name = userName;
                                       Intent intent1 = new Intent(LoginActivity.this, MainActivity.class);//设置跳转到成功的界面
   
                                       startActivity(intent1);
                                       finish();
                                   }catch (Exception e){
                                       e.printStackTrace();
                                   }
                               }
                           };
                           thread.start();//打开线程
                       } else {
                           Toast.makeText(this, "用户名或密码不正确，请重新输入", Toast.LENGTH_SHORT).show();
                       }
                   } else {
                       Toast.makeText(this, "请输入你的用户名或密码", Toast.LENGTH_SHORT).show();
                   }
                   break;
           }
       }
   ```

9. activity_login.xml登录界面

   ```java
   <TextView
           android:id="@+id/tv_loginview"
           android:layout_width="wrap_content"
           android:layout_height="wrap_content"
           android:text="@string/logint"
           android:textSize="45sp"
           android:textColor="@color/colorPrimary"
           app:layout_constraintBottom_toTopOf="@+id/guideline2"
           app:layout_constraintEnd_toEndOf="parent"
           app:layout_constraintHorizontal_bias="0.129"
           app:layout_constraintStart_toStartOf="parent"
           app:layout_constraintTop_toTopOf="parent"
           app:layout_constraintVertical_bias="0.494" />
   
       <EditText
           android:id="@+id/et_User"
           android:layout_width="350dp"
           android:layout_height="wrap_content"
           android:autofillHints="user"
           android:background="@drawable/round_border"
           android:drawableStart="@drawable/ic_user"
           android:drawablePadding="16dp"
           android:ems="10"
           android:hint="@string/etUser_hint"
           android:inputType="textEmailAddress"
           android:padding="16dp"
           app:layout_constraintBottom_toTopOf="@+id/guideline3"
           app:layout_constraintEnd_toEndOf="parent"
           app:layout_constraintStart_toStartOf="parent"
           tools:ignore="LabelFor"
           app:layout_constraintTop_toTopOf="@+id/guideline2"
           android:drawableLeft="@drawable/ic_user" />
   
       <EditText
           android:id="@+id/et_Psw"
           android:layout_width="350dp"
           android:layout_height="wrap_content"
           android:autofillHints=""
           android:background="@drawable/round_border"
           android:drawableStart="@drawable/ic_lock"
           android:drawablePadding="16dp"
           android:ems="10"
           android:hint="@string/pswHint"
           android:inputType="textPassword"
           android:padding="16dp"
           app:layout_constraintBottom_toTopOf="@+id/guideline4"
           app:layout_constraintEnd_toEndOf="parent"
           app:layout_constraintHorizontal_bias="0.508"
           app:layout_constraintStart_toStartOf="parent"
           app:layout_constraintTop_toTopOf="@+id/guideline3"
           app:layout_constraintVertical_bias="0.47"
           android:drawableLeft="@drawable/ic_lock" />
   
       <CheckBox
           android:id="@+id/cb_rmbPsw"
           android:layout_width="wrap_content"
           android:layout_height="wrap_content"
           android:checked="true"
           android:drawingCacheQuality="auto"
           android:shadowColor="@color/colorPrimaryDark"
           android:text="@string/rempsw"
           android:textColor="@color/colorPrimary"
           android:textColorHighlight="@color/colorPrimary"
           android:textColorLink="@color/colorPrimary"
           android:textSize="18sp"
           app:layout_constraintBottom_toTopOf="@+id/guideline5"
           app:layout_constraintEnd_toStartOf="@+id/guideline"
           app:layout_constraintStart_toStartOf="parent"
           app:layout_constraintTop_toTopOf="@+id/guideline4" />
   
       <Button
           android:id="@+id/btn_Login"
           android:layout_width="350dp"
           android:layout_height="wrap_content"
           android:background="@drawable/round_bg"
           android:text="@string/logintxt"
           android:textColor="#FDFAFA"
           android:textSize="18sp"
           app:layout_constraintBottom_toTopOf="@+id/guideline6"
           app:layout_constraintEnd_toEndOf="parent"
           app:layout_constraintHorizontal_bias="0.498"
           app:layout_constraintStart_toStartOf="parent"
           app:layout_constraintTop_toTopOf="@+id/guideline5"
           app:layout_constraintVertical_bias="0.538"  />
   
       <TextView
           android:id="@+id/tv_Register"
           android:layout_width="wrap_content"
           android:layout_height="wrap_content"
           android:text="@string/yhzc"
           android:textColor="@color/colorPrimary"
           android:textSize="18sp"
           app:layout_constraintBottom_toTopOf="@+id/guideline5"
           app:layout_constraintEnd_toEndOf="parent"
           app:layout_constraintStart_toStartOf="@+id/guideline"
           app:layout_constraintTop_toTopOf="@+id/guideline4" />
   ```

10. activity_registered.xml注册界面

    ```java
    <ImageView
            android:id="@+id/iv_back"
            android:layout_width="50dp"
            android:layout_height="50dp"
            android:layout_marginTop="16dp"
            app:layout_constraintBottom_toTopOf="@+id/guideline8"
            app:layout_constraintEnd_toStartOf="@+id/guideline7"
            app:layout_constraintHorizontal_bias="0.242"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            app:layout_constraintVertical_bias="0.477"
            app:srcCompat="@drawable/ic_back"
            tools:ignore="VectorDrawableCompat" />
    
        <EditText
            android:id="@+id/et_rgsName"
            android:layout_width="350dp"
            android:layout_height="wrap_content"
            android:autofillHints=""
            android:background="@drawable/round_border"
            android:drawableStart="@drawable/ic_user"
            android:drawableEnd="@drawable/ic_star"
            android:drawablePadding="16dp"
            android:ems="10"
            android:hint="@string/plsu"
            android:inputType="textPersonName"
            android:padding="12dp"
            app:layout_constraintBottom_toTopOf="@+id/guideline9"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="@+id/guideline8"
            android:drawableLeft="@drawable/ic_user"
            android:drawableRight="@drawable/ic_star" />
    
    
        <EditText
            android:id="@+id/et_rgsPhoneNum"
            android:layout_width="350dp"
            android:layout_height="wrap_content"
            android:autofillHints=""
            android:background="@drawable/round_border"
            android:drawableStart="@drawable/ic_phone"
            android:drawablePadding="16dp"
            android:ems="10"
            android:hint="@string/plsohone"
            android:inputType="textPersonName"
            android:padding="12dp"
            app:layout_constraintBottom_toTopOf="@+id/guideline10"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="@+id/guideline9"
            android:drawableLeft="@drawable/ic_phone"
            android:drawableRight="@drawable/ic_star" />
    
        <EditText
            android:id="@+id/et_rgsPsw1"
            android:layout_width="350dp"
            android:layout_height="wrap_content"
            android:autofillHints=""
            android:background="@drawable/round_border"
            android:drawableStart="@drawable/ic_lock"
            android:drawableEnd="@drawable/ic_star"
            android:drawablePadding="16dp"
            android:ems="10"
            android:hint="@string/plspsw"
            android:inputType="textPersonName"
            android:padding="12dp"
            app:layout_constraintBottom_toTopOf="@+id/guideline11"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="@+id/guideline10"
            android:drawableLeft="@drawable/ic_lock"
            android:drawableRight="@drawable/ic_star" />
    
        <EditText
            android:id="@+id/et_rgsPsw2"
            android:layout_width="350dp"
            android:layout_height="wrap_content"
            android:autofillHints=""
            android:background="@drawable/round_border"
            android:drawableStart="@drawable/ic_lock"
            android:drawableEnd="@drawable/ic_star"
            android:drawablePadding="16dp"
            android:ems="10"
            android:hint="@string/plspsw"
            android:inputType="textPersonName"
            android:padding="12dp"
            app:layout_constraintBottom_toTopOf="@+id/guideline12"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="@+id/guideline11"
            android:drawableLeft="@drawable/ic_lock"
            android:drawableRight="@drawable/ic_star" />
    
        <Button
            android:id="@+id/btn_rgs"
            android:layout_width="350dp"
            android:layout_height="wrap_content"
            android:background="@drawable/round_bg"
            android:text="@string/reg"
            android:textColor="#FFFFFF"
            android:textSize="14sp"
            app:layout_constraintBottom_toTopOf="@+id/guideline13"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.491"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="@+id/guideline12"
            app:layout_constraintVertical_bias="0.692" />
    ```

## 四、实验结果

![实验5截图1](https://github.com/1nnocent1/android-labs-2020/blob/master/students/sec1814080911125/lab5_1.png)  

![实验5截图2](https://github.com/1nnocent1/android-labs-2020/blob/master/students/sec1814080911125/lab5_2.png) 


## 五、实验心得
本次实验是存储编程，学习使用了数据库存储，布局使用到了ConstraintLayout，在本次实验中对AS有了更深的了解。
