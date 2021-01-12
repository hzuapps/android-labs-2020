# 实验七：Android设备编程
## 一、实验要求
- 理解Android相机、蓝牙、传感器等设备编程方法。
- 理解Android设备编程与前面所学组件、存储、网络及界面开发的知识点关系。
## 二、实验内容
- 根据功能新增播放音乐功能
- 功能截图
## 三、实验步骤
- 根据功能新增activity_music.xml音乐界面
- 新增两个实现播放音乐的java文件：MusicActivity、MusicServiceActivity
- Net1814080903323Activity新增跳转MusicActivity

-新增activity_music.xml
```java
    <ImageView
        android:id="@+id/iv_music"
        android:layout_width="240dp"
        android:layout_height="240dp"
        android:layout_gravity="center_horizontal"
        android:layout_margin="15dp"
        android:src="@drawable/music0"
        tools:layout_editor_absoluteX="85dp"
        tools:layout_editor_absoluteY="205dp"
        tools:ignore="MissingConstraints" />

    <TextView
        android:id="@+id/music_name"
        android:layout_width="77dp"
        android:layout_height="29dp"
        android:layout_marginTop="376dp"
        android:layout_marginEnd="164dp"
        android:layout_marginRight="164dp"
        android:text="歌曲名称"
        android:textColor="#000000"
        android:textSize="18sp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView5"
        tools:ignore="MissingConstraints" />

    <TextView
        android:id="@+id/textView5"
        android:layout_width="309dp"
        android:layout_height="78dp"
        android:layout_marginStart="4dp"
        android:layout_marginLeft="4dp"
        android:layout_marginBottom="93dp"
        android:background="#2187B5"
        android:text="网愈云"
        android:textColor="#FFFFFF"
        android:textSize="36sp"
        app:layout_constraintBottom_toTopOf="@+id/button1"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.0" />

    <TextView
        android:id="@+id/textView6"
        android:layout_width="153dp"
        android:layout_height="51dp"
        android:layout_marginTop="64dp"
        android:text="听听音乐"
        android:textColor="#26C9DD"
        android:textSize="36sp"
        app:layout_constraintTop_toBottomOf="@+id/textView5"
        tools:ignore="MissingConstraints"
        tools:layout_editor_absoluteX="129dp" />

    <Button
        android:id="@+id/btn_play"
        android:layout_width="82dp"
        android:layout_height="24dp"
        android:layout_marginBottom="185dp"
        android:background="#26C9DD"
        android:text="播放"
        android:textColor="#FFFFFF"
        android:textSize="16sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.085"
        app:layout_constraintStart_toStartOf="parent"
        tools:ignore="MissingConstraints" />

    <Button
        android:id="@+id/btn_pause"
        android:layout_width="82dp"
        android:layout_height="24dp"
        android:layout_marginBottom="185dp"
        android:background="#26C9DD"
        android:text="暂停"
        android:textColor="#FFFFFF"
        android:textSize="16sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.361"
        app:layout_constraintStart_toStartOf="parent"
        tools:ignore="MissingConstraints" />

    <Button
        android:id="@+id/btn_continue_play"
        android:layout_width="82dp"
        android:layout_height="24dp"
        android:layout_marginBottom="185dp"
        android:background="#26C9DD"
        android:text="继续"
        android:textColor="#FFFFFF"
        android:textSize="16sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.641"
        app:layout_constraintStart_toStartOf="parent"
        tools:ignore="MissingConstraints" />

    <Button
        android:id="@+id/btn_exit"
        android:layout_width="82dp"
        android:layout_height="24dp"
        android:layout_marginBottom="184dp"
        android:background="#26C9DD"
        android:text="退出"
        android:textColor="#FFFFFF"
        android:textSize="16sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.917"
        app:layout_constraintStart_toStartOf="parent"
        tools:ignore="MissingConstraints" />
```

-MusicActivity
```java
public class MusicActivity extends AppCompatActivity implements View.OnClickListener{
    private static TextView name_song;
    private ObjectAnimator animator;
    private MusicServiceActivity.MusicControl musicControl;
    String name;
    Intent intent1,intent2;
    MyServiceConn conn;
    private boolean isUnbind =false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        intent1=getIntent();
        init();
    }
    private void init(){
        name_song=(TextView)findViewById(R.id.music_name);
        findViewById(R.id.btn_play).setOnClickListener(this);
        findViewById(R.id.btn_pause).setOnClickListener(this);
        findViewById(R.id.btn_continue_play).setOnClickListener(this);
        findViewById(R.id.btn_exit).setOnClickListener(this);

        name=intent1.getStringExtra("name");
        name_song.setText(name);
        intent2=new Intent(this,MusicServiceActivity.class);
        conn=new MyServiceConn();
        bindService(intent2,conn,BIND_AUTO_CREATE);
    }

    class MyServiceConn implements ServiceConnection {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service){
            musicControl=(MusicServiceActivity.MusicControl) service;
        }
        @Override
        public void onServiceDisconnected(ComponentName name){

        }
    }
    private void unbind(boolean isUnbind){
        if(!isUnbind){
            musicControl.pausePlay();
            unbindService(conn);
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_play:
                String position=intent1.getStringExtra("position");
                int i=parseInt(position);
                musicControl.play(i);
                animator.start();
                break;
            case R.id.btn_pause:
                musicControl.pausePlay();
                animator.pause();
                break;
            case R.id.btn_continue_play:
                musicControl.continuePlay();
                animator.start();
                break;
            case R.id.btn_exit:
                unbind(isUnbind);
                isUnbind=true;
                finish();
                break;
        }
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        unbind(isUnbind);
    }
}
```

-MusicServiceActivity
```java
public class MusicServiceActivity extends Service {
    private MediaPlayer player;
    public MusicServiceActivity() {}
    @Override
    public  IBinder onBind(Intent intent){
        return (IBinder) new MusicControl();
    }
    @Override
    public void onCreate(){
        super.onCreate();
        player=new MediaPlayer();//创建音乐播放器对象
    }
    class MusicControl extends Binder {//Binder是一种跨进程的通信方式
        public void play(int i){//String path
            Uri uri=Uri.parse("android.resource://"+getPackageName()+"/raw/"+"music"+i);
            try{
                player.reset();//重置音乐播放器
                //加载多媒体文件
                player=MediaPlayer.create(getApplicationContext(),uri);
                player.start();//播放音乐
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        public void pausePlay(){
            player.pause();//暂停播放音乐
        }
        public void continuePlay(){
            player.start();//继续播放音乐
        }
        public void seekTo(int progress){
            player.seekTo(progress);//设置音乐的播放位置
        }
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        if(player==null) return;
        if(player.isPlaying()) player.stop();//停止播放音乐
        player.release();//释放占用的资源
        player=null;//将player置为空
    }
}
```

-新增跳转MusicActivity
```java
        final Button botton3;
        botton3 = findViewById(R.id.button3);
        botton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botton3.setBackgroundColor(Color.rgb(255, 0, 0));
                Intent i = new Intent(Net1814080903323Activity.this, MusicActivity.class);
                startActivity(i);
            }
        });
```

## 四、实验结果
  
![示例截图](https://github.com/joshua-ben/android-labs-2020/blob/master/students/net1814080903323/test7.jpg)  


## 五、实验心得
本次实验完善项目的第三个模块听听音乐，补充使用设备编程。
