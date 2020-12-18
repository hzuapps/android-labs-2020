package edu.hzuapps.androidlabs;

import android.app.IntentService;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class MyService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    public static final String ACTION_FOO = "com.example.zouqi.bgmusicdemo.action.FOO";
    public static final String ACTION_BAZ = "com.example.zouqi.bgmusicdemo.action.BAZ";

    // action声明
    public static final String ACTION_MUSIC = "com.example.zouqi.bgmusicdemo.action.music";

    // TODO: Rename parameters
    public static final String EXTRA_PARAM1 = "com.example.zouqi.bgmusicdemo.extra.PARAM1";
    public static final String EXTRA_PARAM2 = "com.example.zouqi.bgmusicdemo.extra.PARAM2";

    // 声明MediaPlayer对象
    private MediaPlayer mediaPlayer;

    public MyService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_FOO.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionFoo(param1, param2);
            } else if (ACTION_BAZ.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionBaz(param1, param2);
            }

            // 根据intent设置的action来执行对应服务的操作
            if (ACTION_MUSIC.equals(action)){
                handleActionMusic();
            }
        }
    }

    /**
     * 该服务执行的操作用来播放背景音乐
     */
    private void handleActionMusic() {

        if (mediaPlayer == null){
            // 根据音乐资源文件创建MediaPlayer对象 设置循环播放属性 开始播放
            mediaPlayer = MediaPlayer.create(this, R.raw.test_520);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
        }

    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(String param1, String param2) {
        // TODO: Handle action Foo
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
