# 实验六

## 一、实验目标

1. 掌握Android网络访问方法；
2. 理解XML和JSON表示数据的方法。

## 二、实验内容

1. 从网络下载一个文件；
2. 保存到手机，在应用中使用文件；
3. 将应用运行结果截图。

## 三、实验步骤

1. 创建Filepath类，定义一个静态的String变量，用于在不同的Activity.java之间传递选择的文件的路径。
```java
public class Filepath {
    public static String path;
}
```
2. 在activity_showfilelist.xml中添加TextView、EditText、Button等控件，用于选择文档和显示文件列表
```java
<TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="文件名:"
            android:textSize="20dp"/>
        <EditText
            android:layout_width="200dp"
            android:layout_height="wrap_content"
            android:textSize="20dp"
            android:id="@+id/filename"/>
        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textSize="20dp"
            android:id="@+id/download"
            android:text="下载"/>
```
```java
<TextView
        android:id="@+id/file_list"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:textSize="20dp"
        />
```
3. 在ShowfilelistActivity.java中创建一个线程用于通过网络获取数据库中存储的文件名，并显示在TextView中

定义一个Runnable变量，用于将文件名显示在TextView中
```java
Runnable runnable = new Runnable() {
        public void run() {
            textView.setText(massage);
        }
    };
```
创建线程获取文件名
```java
new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    client = new Socket("192.168.43.26", 12345);
                    in = new DataInputStream(client.getInputStream());
                    out = new DataOutputStream(client.getOutputStream());
                    out.writeUTF("1");
                    massage = in.readUTF();
                    handler.post(runnable);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
```
4. 在ShowfilelistActivity.java中创建下载按钮的触发事件，先将输入框内容读出，然后创建线程连接服务端，将要下载文件的文件名和用户的权限发送到服务端，服务端根据接收到的字段判断文件是否存在和用户的申请是否合法，据此返回字段，客户端接收服务端的字段，若返回的字段为“error”，则提示错误，否则创建一个文件，将接收到的文件字节流写入文件中
```java
button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String filename=editText.getText().toString();
                        try {
                            client = new Socket("192.168.43.26", 12345);
                            in = new DataInputStream(client.getInputStream());
                            out = new DataOutputStream(client.getOutputStream());
                            out.writeUTF("3");
                            out.writeUTF(filename);
                            out.writeUTF("admins");
                            String content=in.readUTF();
                            if(content.equals("error")){
                                handler.post(runnable1);
                            }
                            else{
                                File file=new File("/storage/emulated/0/",filename);
                                try {
                                    file.createNewFile();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                FileOutputStream fileOutputStream=new FileOutputStream(file);
                                fileOutputStream.write(content.getBytes());
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });
```
5. 在CipheruploadActivity.java中创建上传文件的确定按钮触发事件，先确定各个复选框是否选中，然后创建线程连接服务端，将选中的文件的字节流读出，最后将各个字段通过socket发出并返回到主界面
```java
sure=findViewById(R.id.sure);
        checkBox1=findViewById(R.id.administration);//管理部门
        checkBox2=findViewById(R.id.sale);//销售部门
        checkBox3=findViewById(R.id.finance);//财政部门
        checkBox4=findViewById(R.id.produce);//生产部门
        checkBox5=findViewById(R.id.allstaff);//全体员工
        activity=this;
        handler=new Handler();
        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox1.isChecked()){
                    admin="1";
                }
                else
                    admin="0";
                if(checkBox2.isChecked()){
                    sale="1";
                }
                else
                    sale="0";
                if(checkBox3.isChecked()){
                    finance="1";
                }
                else
                    finance="0";
                if(checkBox4.isChecked()){
                    produce="1";
                }
                else
                    produce="0";
                if(checkBox5.isChecked()){
                    all="1";
                }
                else
                    all="0";
                file=new File(Filepath.path);
                new Thread(new Runnable() {
                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                    @Override
                    public void run() {
                        try {
                            client = new Socket("192.168.43.26", 12345);
                            in = new DataInputStream(client.getInputStream());
                            out = new DataOutputStream(client.getOutputStream());
                            FileInputStream fileInputStream=new FileInputStream(file);
                            StringBuilder stringBuilder = new StringBuilder();
                            InputStreamReader inputStreamReader =
                                    new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
                            BufferedReader br = new BufferedReader(inputStreamReader);
                            String line = null;
                            while ((line = br.readLine()) != null) {
                                stringBuilder.append(line);
                            }
                            String result = stringBuilder.toString();
                            out.writeUTF("2");
                            out.writeUTF(file.getName());
                            out.writeUTF(all);
                            out.writeUTF(produce);
                            out.writeUTF(admin);
                            out.writeUTF(sale);
                            out.writeUTF(finance);
                            out.writeUTF(result);
                            Intent intent=new Intent(activity,Sec1814080911219Activity.class);
                            activity.startActivity(intent);
                            handler.post(runnable);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }).start();
                Intent intent=new Intent(activity,Sec1814080911219Activity.class);
                activity.startActivity(intent);
            }
        });
```

## 四、实验结果
1. ![lab6.1](https://raw.githubusercontent.com/CGB588/android-labs-2020/master/students/sec1814080911219/lab6-1.jpg)
2. ![lab6.2](https://raw.githubusercontent.com/CGB588/android-labs-2020/master/students/sec1814080911219/lab6-2.jpg)
3. ![lab6.3](https://raw.githubusercontent.com/CGB588/android-labs-2020/master/students/sec1814080911219/lab6-3.jpg)

## 五、实验心得
  这次实验的内容是网络编程，由于我的选题是做文件传输的，所以这次实验主要实现通过网络来上传和下载文件，开始的想法是直接连接MySQL数据库，但是不知道为什么连接不上，报不支持操作异常，所以自己写了一个socket的服务端，通过服务端连接数据库，获取数据库的数据。
