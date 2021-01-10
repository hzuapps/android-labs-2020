package edu.hzuapps.androidlabs;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class Sec1814080911130Activity extends AppCompatActivity implements View.OnClickListener {
	Button button_start = null;
	Button button_rank = null;
	Button button_options = null;
	Button button_out = null;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sec1814080911130);
		button_start = (Button) findViewById(R.id.button_play);
		button_rank = (Button) findViewById(R.id.button_rank);
		button_options = (Button) findViewById(R.id.button_options);
		button_out = (Button) findViewById(R.id.button_out);
		button_start.setOnClickListener(this);
		button_rank.setOnClickListener(this);
		button_options.setOnClickListener(this);
		button_out.setOnClickListener(this);
	}
	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		if(view == button_start){
			Intent intent = new Intent(this, PlayActivity.class);
			startActivity(intent);
		}else if(view == button_rank){
			Intent intent = new Intent(this, RankActivity.class);
			startActivity(intent);
		}else if(view == button_options){
			Intent intent = new Intent(this, OptionsActivity.class);
			startActivity(intent);
		}else if(view == button_out){
			FightingView.flag = false;
			FightingView.pause = true;
			finish();
		}
	}

}
