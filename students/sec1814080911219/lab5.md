# 实验五

## 一、实验目标

1. 了解Andoid的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储

## 二、实验内容

根据选题要求使用文件存储:
1. 将应用产生的数据保存到文件存储中；
2. 说明使用的文件存储方式：内部 or 外部；
3. 将运行结果截图。

## 三、实验步骤

1. 在AndroidManifest.xml文件中添加以下代码申请系统存储空间权限
```java
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.INTERNET" />
```
2. 创建动态申请系统存储空间权限的函数
```java
private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE" };
    public static void verifyStoragePermissions(Activity activity) {
        try {
            int permission = ActivityCompat.checkSelfPermission(activity,
                    "android.permission.WRITE_EXTERNAL_STORAGE");
            if (permission != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
```
3. 设置偏好-实现登陆用户名
```java
public void setting_loginname(String username){
        SharedPreferences settings = thisActivity.getSharedPreferences("Username",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(ID,username);
        editor.commit();
    }
```
4. 获取偏好设置中的用户名
```java
public String getusername(){
        SharedPreferences settings = thisActivity.getSharedPreferences("Username",Context.MODE_PRIVATE);
        String user=settings.getString(ID,"");
        return user;
    }
```
5. 编写日志文件的文件，实现上传文件时记录上传文件的用户名、时间以及上传的文件的文件名等信息
```java
@RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void log(String date, String username, String log_path, String log_kind){
        File file=new File("/storage/emulated/0/test/",log_kind);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fileInputStream=new FileInputStream(file);
            StringBuilder stringBuilder = new StringBuilder();
            InputStreamReader inputStreamReader =
                    new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(inputStreamReader);
            String line = null;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }
            String result = stringBuilder.toString();//读上次记录的内容
            FileOutputStream fileOutputStream=new FileOutputStream(file);//获取文件的字符流
            fileOutputStream.write((result+date+" "+username+" "+log_path).getBytes());//将输入框内容写入文件
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
```
6. 获取当前系统时间，以便于在记录日志文件中写入上传文件的时间
```java
public String getsystime(){
        SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date=sDateFormat.format(new java.util.Date());;
        return date;
    }
```
7. 在activity_main.xml中添加一个TextView、EditText、Button用于输入用户名登陆
```java
<LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="20dp"
        android:orientation="horizontal">
        <TextView
            android:layout_width="100dp"
            android:layout_height="match_parent"
            android:text="用户名:"
            android:textSize="25dp"/>
        <EditText
            android:layout_width="210dp"
            android:layout_height="match_parent"
            android:id="@+id/login_name"
            />
        <Button
            android:layout_width="100dp"
            android:layout_height="match_parent"
            android:text="登陆"
            android:id="@+id/login"/>
    </LinearLayout>
```
## 四、实验结果
1. ![lab5.1](https://raw.githubusercontent.com/CGB588/android-labs-2020/master/students/sec1814080911219/lab5-1.PNG)
2. ![lab5.2](https://raw.githubusercontent.com/CGB588/android-labs-2020/master/students/sec1814080911219/lab5-2.PNG)
3. ![lab5.3](https://raw.githubusercontent.com/CGB588/android-labs-2020/master/students/sec1814080911219/lab5-3.PNG)

## 五、实验心得
这次实验所花费的时间相对于前几个实验较长，因为在这个实验中需要实现记录用户名、创建上传文件的日志文件以及调用系统中的文件管理器来实现选择上传的文件，实验过程中虽然遇到一些困难，但是通过网上查找资料还是可以解决的，
就是比较费时间。
