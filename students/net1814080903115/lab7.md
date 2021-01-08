# 一、实验目标

1. 了解Andoid的音乐播放功能    
2. 掌握Android的MediaPlayer    
3. 理解Android设备编程与前面所学组件、存储、网络及界面开发的知识点关系
  

# 二、实验内容
1. 修改PlayActivity.java文件   
2. 修改播放界面activity_play.xml文件代码设计布局   
3. 将运行结果截图  


# 三、实验步骤
1. 配置activity_play.xml  
```xml
    <TextView
        android:id="@+id/textview_01"
        android:layout_width="509dp"
        android:layout_height="420dp"
        android:drawableTop="@drawable/pic"
        android:scaleType="centerInside"

        />
    <Button
        android:id="@+id/btnPlay"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textAllCaps="false"
        android:text="Play"/>
    <Button
        android:id="@+id/btnPause"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textAllCaps="false"
        android:text="Pause"/>
    <Button
        android:id="@+id/btnStop"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textAllCaps="false"
        android:text="Stop"/>
```
2. 在PlayActivity.java文件实现播放音乐功能    
```
public class PlayActivity extends AppCompatActivity implements View.OnClickListener{
    private MediaPlayer mediaPlayer = new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        Button btnPlay = (Button) findViewById(R.id.btnPlay);
        Button btnPause = (Button) findViewById(R.id.btnPause);
        Button btnStop = (Button) findViewById(R.id.btnStop);
        btnPlay.setOnClickListener(this);
        btnPause.setOnClickListener(this);
        btnStop.setOnClickListener(this);

        //权限判断，如果没有权限就请求权限
        if (ContextCompat.checkSelfPermission(PlayActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(PlayActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        } else {
            initMediaPlayer();//初始化播放器 MediaPlayer
        }

    }

    private void initMediaPlayer() {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), "music.mp3");
            mediaPlayer.setDataSource(file.getPath());//指定音频文件路径
            mediaPlayer.setLooping(true);//设置为循环播放
            mediaPlayer.prepare();//初始化播放器MediaPlayer

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    initMediaPlayer();
                }else{
                    Toast.makeText(this, "拒绝权限，将无法使用程序。", Toast.LENGTH_LONG).show();
                    finish();
                }
                break;
            default:
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnPlay:

                //如果没在播放中，立刻开始播放。
                if(!mediaPlayer.isPlaying()){

                    openRawMusicS();
                }
                break;
            case R.id.btnPause:
                //如果在播放中，立刻暂停。
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                }
                break;
            case R.id.btnStop:
                //如果在播放中，立刻停止。
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.reset();
                    initMediaPlayer();//初始化播放器 MediaPlayer
                }
                break;
            default:
                break;
        }
    }
    /**
     * 打开raw目录下的音乐mp3文件
     */
    private void openRawMusicS() {
        mediaPlayer = MediaPlayer.create(this, R.raw.music);
        //用prepare方法，会报错误java.lang.IllegalStateExceptio
        //mediaPlayer1.prepare();
        mediaPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }
}
``` 


# 四、实验结果
![lab7_1](https://github.com/1CHONG/android-labs-2020/blob/master/students/net1814080903115/lab7_2.png)
![lab7_2](https://github.com/1CHONG/android-labs-2020/blob/master/students/net1814080903115/lab7_1.png)  
# 五、实验心得
本次实验主要是对我自己的选题功能进行最后的完善，对播放界面进行了一个布局设计，还有修改PlayActivity.java代码实现播放raw目录下的音频的功能。
