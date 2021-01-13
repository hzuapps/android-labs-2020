# 实验六

## 一、 实验目标

1. 掌握Android进行socket通信

## 二、 实验内容

1. 实现客户端与服务端的对话，传送消息

## 三、 实验步骤

1. 创建一个chat.xml文件和Chat.java类并将其连接起来

2. 设置点击“发送消息”按钮，跳转到chat界面

   ```java
   final Net1814080903130Activity t=this;
        textView1=findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread Thread1 = new Thread() {
                    @Override
                    public void run() {
                        Intent intent = new Intent();
                        intent.setClass(t, Chat.class);
                        startActivity(intent);
                    }
                };
                Thread1.start();
            }
        });
   ```

3. 在chat中添加一个EditText控件来输入内容，添加“发送”按钮来实现socket信息传送，添加TextView控件来显示发送的消息，再添加一个toolbar工具栏用于显示返回键

   ```java
    <Button
        android:id="@+id/button2"
        android:layout_width="117dp"
        android:layout_height="0dp"
        android:text="发送"
        android:textSize="24sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toEndOf="@+id/ettp2"
        app:layout_constraintTop_toBottomOf="@+id/textView11" />

    <TextView
        android:id="@+id/textView11"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:layout_marginTop="60dp"
        android:layout_marginBottom="60dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <EditText
        android:id="@+id/ettp2"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:layout_marginEnd="10dp"
        android:background="@null"
        android:ems="10"
        android:inputType="textPersonName"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toStartOf="@+id/button2"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView11" />
        
    <androidx.appcompat.widget.Toolbar
        android:id="@+id/toolbar2"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:background="@android:color/holo_blue_light"
        android:minHeight="?attr/actionBarSize"
        android:theme="?attr/actionBarTheme"
        app:layout_constraintBottom_toTopOf="@+id/textView11"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
   ```

4. 在chat.java类中创建鼠标点击事件实现多线程socket通信，在工具栏添加返回键

   ```java
   public class Chat extends AppCompatActivity {
    TextView textView11;
    EditText ettp2;
    Button button2;
    Socket socket1;
    PrintWriter cout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);

        textView11=findViewById(R.id.textView11);
        ettp2=findViewById(R.id.ettp2);
        button2=findViewById(R.id.button2);

        Toolbar toolbar2=findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new fs().start();
            }
        });

        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    CServer();
                    SClient();
                }
                catch (IOException e) {
                    System.out.println(e);
                }
            }
        };
        new Thread() {
            public void run() {
                Looper.prepare();
                new Handler().post(runnable);
                Looper.loop();
            }
        }.start();

    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                try {
                    cout.close();
                    socket1.close();
                    System.out.println("聊天服务已关闭");
                }
                catch (IOException e) {
                    System.out.println(e);
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    finishAfterTransition();
                }
                break;
        }
        return true;
    }

    public void CServer() throws IOException
    {
        System.out.print("正在等待连接，请勿操作\n");
        new c_server().start();
    }

    public void SClient() throws IOException {
        new s_client().start();
    }

    class fs extends Thread{
        public void run(){
            try {
                cout=new PrintWriter(socket1.getOutputStream(),true);
                cout.println(ettp2.getText());
                textView11.append("我："+ettp2.getText()+"\n");
                ettp2.setText("");
            }
            catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    class c_server extends Thread{
        public void run(){
            try {
                ServerSocket server=new ServerSocket(8080);
                Socket client=server.accept();
                String line="服务器已启动"+"\n";
                textView11.append(line);
                System.out.println("服务器已启动\n");
                while(true){
                    BufferedReader br=new BufferedReader(new InputStreamReader(client.getInputStream()));
                    while((line=br.readLine())!=null){
                        System.out.println("服务器接收："+line);
                    }
                }
            }
            catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    class s_client extends Thread{
        public void run(){
            try {
                socket1=new Socket("10.3.208.180",8080);
            }
            catch (IOException e) {
                System.out.println(e);
            }
        }
    }

  }
    ```

## 四、 实验结果

![实验六图片1](https://github.com/waljja/android-labs-2020/blob/master/students/net1814080903130/sy6.1.PNG)
![实验六图片2](https://github.com/waljja/android-labs-2020/blob/master/students/net1814080903130/sy6.2.jpg)
![实验六图片3](https://github.com/waljja/android-labs-2020/blob/master/students/net1814080903130/sy6.3.jpg)
![实验六图片4](https://github.com/waljja/android-labs-2020/blob/master/students/net1814080903130/sy6.4.jpg)

## 五、 实验心得体会

通过这次实验我学会了用Android Studio来实现socket通信，在实践过程中遇到很多问题，都一一的解决了，加深了我对Android通信的了解。
