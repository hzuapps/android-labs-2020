package edu.hzuapps.androidlabs;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

public class PlayActivity extends Activity {
	/** Called when the activity is first created. */
	FrameLayout frame;
	final static int PAUSE = 1;
	final static int STOP = 0;
	public static boolean backMusicFlag = true;
	public static boolean soundFlag = false;
	boolean flag = true;
	FightingView FightingView = null;
	static MediaPlayer backMusic = null;
	static MediaPlayer shotMusic = null;
	static MediaPlayer bombMusic = null;
	@SuppressLint("HandlerLeak")
	Handler handler = new Handler(){
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			switch(msg.what){
				case PAUSE:
					FightingView.pause = true;
					FightingView.flag = false;

					Intent intent = new Intent(PlayActivity.this, RankActivity.class);
					intent.putExtra("score", FightingView.score);
					FightingView.enemyDestroyedNum = 0;
					FightingView.score = 0;
					PlayActivity.this.startActivityForResult(intent, 1);

					PlayActivity.this.finish();

					break;
			}
		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//全屏显示窗口
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		//获取当前屏幕的属性
		Display display = getWindowManager().getDefaultDisplay();
		backMusic = MediaPlayer.create(this, R.raw.back);
		shotMusic = MediaPlayer.create(this, R.raw.bullet);
		bombMusic = MediaPlayer.create(this, R.raw.bomb);
		backMusic.setLooping(true);
		SharedPreferences share = getSharedPreferences("test", Context.MODE_PRIVATE+Context.MODE_PRIVATE);
		backMusicFlag = share.getBoolean("backMusicFlag", true);
		soundFlag = share.getBoolean("soundFlag", true);

		frame = new FrameLayout(this);
		FightingView = new FightingView(this, display.getWidth(), display.getHeight());
		frame.addView(FightingView);

		setContentView(frame);

		Thread thread = new Thread(){

			public void run() {
				while(flag){
					if(FightingView.round == 6){
						FightingView.pause = true;
						handler.sendEmptyMessage(PAUSE);
						flag = false;
					}else if(FightingView.plane.lives <= 0){
						handler.sendEmptyMessage(PAUSE);
						flag = false;
					}
				}
			};
		};
		thread.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.i("wy", "战斗暂停");
		FightingView.pause = true;//战斗暂停
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.i("wy", "战斗停止");
		FightingView.flag = false;//线程终止
		FightingView.enemyDestroyedNum = 0;
		FightingView.round = 1;
		FightingView.score = 0;
		backMusic.stop();
		flag = false;
	}
}