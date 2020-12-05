实验六：Android网络编程

## 一、实验目标

1. 掌握Android网络访问方法；
2. 理解XML和JSON表示数据的方法。

```
注意：选择实现的功能，一定要跟你的选题相关！
```

## 二、实验内容

1. 从网络下载一个文件（图片、MP3、MP4）；
2. 保存到手机，在应用中使用文件；
3. 将应用运行结果截图。

## 三、实验步骤

1. 在 AndroidManifest.xml 上添加网络权限

```
    <uses-permission
        android:name="android.permission.RECEIVE_BOOT_COMPLETED"/>
```

```java
 <receiver
            android:name=".AlarmReceiver"
            android:screenOrientation="portrait">
            <!--android:enabled="true"-->
            <!--android:exported="true"-->

            <intent-filter>
                <action android:name="android.intent.cation.BOOT_COMPLETED"/>
            </intent-filter>
        </receiver>
```

2. 在layout创建alarm_play_aty.xml作为闹钟播放界面

   ```java
   <?xml version="1.0" encoding="utf-8"?>
   <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
       android:layout_width="match_parent"
       android:layout_height="match_parent">
       
       <TextView
           android:textAppearance="?android:attr/textAppearanceLarge"
           android:gravity="center"
           android:layout_width="fill_parent"
           android:layout_height="fill_parent"
           android:text="Play Sound"/>
   </LinearLayout>
   
   ```

3. 修改AlarmActivity.java

```
 public class AlarmActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceSate){
        super.onCreate(savedInstanceSate);
        setContentView(R.layout.alarm_play_aty);

        mp = MediaPlayer.create(this,R.raw.music);
        mp.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mp.stop();
        mp.release();
    }

    private MediaPlayer mp;
}
```

4. 创建AlarmReceive.java

```
    public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("闹钟执行了");
        AlarmManager am =(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        am.cancel(PendingIntent.getBroadcast(context,getResultCode(),new Intent(context,AlarmReceiver.class),0));

        Intent i = new Intent(context,AlarmActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(i);

    }
}
```

4.在resource创建raw文件，引入下载的music.mp3作为闹钟铃声

## 四、实验结果及截图

![lab6（2）](D:\Desktop\Markdown\移动应用开发\lab6（2）.PNG)

如下图：闹钟播放界面

![lab6 (1)](D:\Desktop\Markdown\移动应用开发\lab6 (1).PNG)



## 五、实验心得

通过这次实验，我学习了如何使用Android多媒体框架中的一个重要组件MediaPlayer和广播接收器，在这个实验中值得注意的是，在使用广播接收器时一定要在AndroidManifest.xml中注册广播接收器来监听制定的广播意图，无论什么时候Android设备被启动，都将被广播接收器Receiver所拦截，并且在onReceive()中实现的逻辑将被执行。