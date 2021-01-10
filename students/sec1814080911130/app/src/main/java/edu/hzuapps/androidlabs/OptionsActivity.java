package edu.hzuapps.androidlabs;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class OptionsActivity extends Activity {
	CheckBox cbBackMusic = null;
	CheckBox cbSound = null;
	Editor editor = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_options);
		cbBackMusic = (CheckBox) findViewById(R.id.cb_back);
		cbSound = (CheckBox) findViewById(R.id.cb_Sound);
		SharedPreferences share = getSharedPreferences("test", Context.MODE_PRIVATE+Context.MODE_PRIVATE);
		editor = share.edit();

		PlayActivity.backMusicFlag = share.getBoolean("backMusicFlag", true);
		PlayActivity.soundFlag = share.getBoolean("soundFlag", true);
		if(PlayActivity.backMusicFlag){
			cbBackMusic.setChecked(true);
		}
		if(PlayActivity.soundFlag){
			cbSound.setChecked(true);
		}

		cbBackMusic.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				editor.putBoolean("backMusicFlag", isChecked);
				editor.commit();
			}
		});

		cbSound.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				editor.putBoolean("soundFlag", isChecked);
				editor.commit();
			}
		});
	}
}
